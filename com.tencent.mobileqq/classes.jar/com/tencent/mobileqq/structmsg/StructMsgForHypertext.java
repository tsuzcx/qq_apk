package com.tencent.mobileqq.structmsg;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.util.Xml;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener.Adapter;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlSerializer;

public class StructMsgForHypertext
  extends AbsStructMsg
{
  private String KEY_QD_HYPERTEXT_CLICK_STATE = "qd_hypertext_click_state_";
  public ArrayList<StructMsgForHypertext.Hypertext> mHpertextArray = null;
  protected boolean mHyperClick;
  public int mHypertextContentLayout;
  public String mSourceIcon;
  public String mSourceName;
  protected View.OnClickListener mSourceOnClickListener;
  public String mSourceUrl;
  private URLDrawableDownListener.Adapter mUrlAdapter;
  
  StructMsgForHypertext()
  {
    this.mHypertextContentLayout = 0;
    this.mHyperClick = false;
    this.mSourceName = null;
    this.mSourceIcon = null;
    this.mSourceUrl = null;
    this.mUrlAdapter = new StructMsgForHypertext.1(this);
    this.mSourceOnClickListener = new StructMsgForHypertext.2(this);
  }
  
  StructMsgForHypertext(Bundle paramBundle)
  {
    super(paramBundle);
    this.mHypertextContentLayout = 0;
    this.mHyperClick = false;
    this.mSourceName = null;
    this.mSourceIcon = null;
    this.mSourceUrl = null;
    this.mUrlAdapter = new StructMsgForHypertext.1(this);
    this.mSourceOnClickListener = new StructMsgForHypertext.2(this);
    this.mMsgServiceID = 3;
    a(paramBundle.getString("forward_text"));
    this.mSourceName = paramBundle.getString("struct_share_key_source_name");
    this.mSourceIcon = paramBundle.getString("struct_share_key_source_icon");
    this.mSourceUrl = paramBundle.getString("struct_share_key_source_url");
  }
  
  StructMsgForHypertext(StructMsgNode paramStructMsgNode, int paramInt)
  {
    super(paramStructMsgNode);
    int i = 0;
    this.mHypertextContentLayout = 0;
    this.mHyperClick = false;
    this.mSourceName = null;
    this.mSourceIcon = null;
    this.mSourceUrl = null;
    this.mUrlAdapter = new StructMsgForHypertext.1(this);
    this.mSourceOnClickListener = new StructMsgForHypertext.2(this);
    this.mMsgServiceID = paramInt;
    int j = paramStructMsgNode.a();
    paramInt = i;
    while (paramInt < j)
    {
      StructMsgNode localStructMsgNode = paramStructMsgNode.a(paramInt);
      if (localStructMsgNode != null) {
        if (localStructMsgNode.b.equals("source"))
        {
          parseSourceNode(localStructMsgNode);
        }
        else if (localStructMsgNode.f == 1)
        {
          for (localStructMsgNode = localStructMsgNode.c(); (localStructMsgNode != null) && (localStructMsgNode.f != 1); localStructMsgNode = StructMsgFactory.b(localStructMsgNode)) {}
          parseItem(localStructMsgNode);
        }
      }
      paramInt += 1;
    }
  }
  
  private void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.mHpertextArray = new ArrayList();
    StringBuilder localStringBuilder = new StringBuilder();
    Matcher localMatcher1 = Pattern.compile("<a.*?/a>").matcher(paramString);
    for (int i = 0; localMatcher1.find(); i = localMatcher1.end())
    {
      String str1 = paramString.substring(i, localMatcher1.start());
      this.mHpertextArray.add(new StructMsgForHypertext.Hypertext(str1));
      localStringBuilder.append(str1);
      String str2 = localMatcher1.group();
      Matcher localMatcher2 = Pattern.compile(">.*?</a>").matcher(str2);
      for (str1 = ""; localMatcher2.find(); str1 = localMatcher2.group().replaceAll(">|</a>", "")) {}
      localMatcher2 = Pattern.compile("href\\s*=\\s*(\"([^\"]*\")|'[^']*'|([^'\">\\s]+))").matcher(str2);
      for (str2 = ""; localMatcher2.find(); str2 = localMatcher2.group().replaceAll("href\\s*=\\s*(['|\"]*)|['|\"]*", "")) {}
      this.mHpertextArray.add(new StructMsgForHypertext.Hypertext(str2, "web", null, null, null, null, null, str1));
      localStringBuilder.append(str1);
    }
    paramString = paramString.substring(i);
    this.mHpertextArray.add(new StructMsgForHypertext.Hypertext(paramString));
    localStringBuilder.append(paramString);
    this.mMsgBrief = localStringBuilder.toString();
  }
  
  public byte[] getBytes()
  {
    try
    {
      Object localObject = new ByteArrayOutputStream();
      ObjectOutputStream localObjectOutputStream = new ObjectOutputStream((OutputStream)localObject);
      writeExternal(localObjectOutputStream);
      localObjectOutputStream.close();
      localObject = ((ByteArrayOutputStream)localObject).toByteArray();
      return localObject;
    }
    catch (IOException localIOException)
    {
      label33:
      break label33;
    }
    if (QLog.isColorLevel()) {
      QLog.d("HypertextMsg", 2, "getBytes failure");
    }
    return null;
  }
  
  public View getPreDialogView(Context paramContext, View paramView)
  {
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    localLinearLayout.setOrientation(1);
    paramView = localLinearLayout.getLayoutParams();
    if (paramView == null)
    {
      paramView = new LinearLayout.LayoutParams(BaseChatItemLayout.B, -2);
    }
    else
    {
      paramView.width = BaseChatItemLayout.B;
      paramView.height = -2;
    }
    localLinearLayout.setLayoutParams(paramView);
    paramView = new StructMsgForHypertext.HyperTextView(paramContext);
    Resources localResources = paramContext.getResources();
    paramView.setPadding((int)localResources.getDimension(2131299802), (int)localResources.getDimension(2131299804), (int)localResources.getDimension(2131299803), (int)localResources.getDimension(2131299801));
    paramView.setText(getSpannableString(false));
    paramView.setMaxLines(10);
    paramView.setTextSize(0, ChatTextSizeSettingActivity.a(paramContext));
    paramView.setTextColor(paramContext.getResources().getColor(2131165687));
    paramView.setLinkTextColor(paramContext.getResources().getColor(2131166583));
    paramView.setLinksClickable(false);
    paramView.setMovementMethod(LinkMovementMethod.getInstance());
    localLinearLayout.addView(paramView);
    localLinearLayout.setLongClickable(true);
    localLinearLayout.setTag(2131446476, this);
    return localLinearLayout;
  }
  
  public String getSourceName()
  {
    return this.mSourceName;
  }
  
  public View getSourceView(Context paramContext, View paramView)
  {
    if ((TextUtils.isEmpty(this.mSourceName)) && (TextUtils.isEmpty(this.mSourceIcon))) {
      return null;
    }
    Resources localResources = paramContext.getResources();
    boolean bool2 = true;
    Object localObject1 = paramView;
    if (paramView == null)
    {
      localObject1 = new TextView(paramContext);
      ((TextView)localObject1).setSingleLine(true);
      ((TextView)localObject1).setGravity(16);
      ((TextView)localObject1).setEllipsize(TextUtils.TruncateAt.END);
      ((TextView)localObject1).setTextColor(-1);
      ((TextView)localObject1).setTextSize(2, 12.0F);
      ((TextView)localObject1).setPadding(AIOUtils.b(5.0F, localResources), 0, AIOUtils.b(5.0F, localResources), 0);
      ((TextView)localObject1).setBackgroundResource(2130843655);
    }
    paramView = (TextView)localObject1;
    paramView.setText(this.mSourceName);
    int i;
    try
    {
      new URL(this.mSourceIcon);
      i = 1;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      localMalformedURLException.printStackTrace();
      i = 0;
    }
    if ((!TextUtils.isEmpty(this.mSourceIcon)) && (i != 0))
    {
      String str = this.mSourceIcon;
      Object localObject2 = localResources.getDrawable(2130852668);
      ((Drawable)localObject2).setBounds(0, 0, AIOUtils.b(12.0F, localResources), AIOUtils.b(12.0F, localResources));
      ColorDrawable localColorDrawable = new ColorDrawable(15790320);
      localColorDrawable.setBounds(0, 0, AIOUtils.b(12.0F, localResources), AIOUtils.b(12.0F, localResources));
      localObject2 = URLDrawable.getDrawable(str, (Drawable)localObject2, localColorDrawable);
      boolean bool1 = bool2;
      if (!AbsDownloader.hasFile(str)) {
        if (!URLDrawableHelper.isMobileNetAndAutodownDisabled(paramContext)) {
          bool1 = bool2;
        } else {
          bool1 = false;
        }
      }
      ((URLDrawable)localObject2).setAutoDownload(bool1);
      ((URLDrawable)localObject2).setBounds(0, 0, AIOUtils.b(12.0F, localResources), AIOUtils.b(12.0F, localResources));
      paramView.setCompoundDrawablePadding(AIOUtils.b(3.0F, localResources));
      paramView.setCompoundDrawables((Drawable)localObject2, null, null, null);
    }
    else
    {
      paramView.setCompoundDrawables(null, null, null, null);
    }
    paramView.setPadding(AIOUtils.b(5.0F, localResources), 0, AIOUtils.b(5.0F, localResources), 0);
    ((View)localObject1).setTag(this);
    ((View)localObject1).setOnClickListener(this.mSourceOnClickListener);
    return localObject1;
  }
  
  public SpannableStringBuilder getSpannableString(boolean paramBoolean)
  {
    if (this.mHpertextArray == null) {
      return new SpannableStringBuilder("");
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    Iterator localIterator = this.mHpertextArray.iterator();
    while (localIterator.hasNext())
    {
      StructMsgForHypertext.Hypertext localHypertext = (StructMsgForHypertext.Hypertext)localIterator.next();
      Object localObject = localHypertext.h;
      if (!TextUtils.isEmpty(localHypertext.b))
      {
        int n = localSpannableStringBuilder.toString().length();
        int i1 = ((String)localObject).length() + n;
        localSpannableStringBuilder.append((CharSequence)localObject);
        if (paramBoolean)
        {
          localSpannableStringBuilder.setSpan(new StructMsgForHypertext.HyperSpannable(this, localHypertext), n, i1, 33);
          if ((this.message != null) && (!TextUtils.isEmpty(localHypertext.f)))
          {
            localObject = this.message;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(this.KEY_QD_HYPERTEXT_CLICK_STATE);
            localStringBuilder.append(localHypertext.f);
            localObject = ((MessageRecord)localObject).getExtInfoFromExtStr(localStringBuilder.toString());
            int m = 0;
            int i;
            try
            {
              if (!TextUtils.isEmpty(localHypertext.g)) {
                i = Integer.valueOf(localHypertext.g).intValue();
              } else {
                i = 0;
              }
              j = i;
              k = m;
              try
              {
                if (TextUtils.isEmpty((CharSequence)localObject)) {
                  break label281;
                }
                k = Integer.valueOf((String)localObject).intValue();
                j = i;
              }
              catch (NumberFormatException localNumberFormatException1) {}
              QLog.d("StructMsg", 1, localNumberFormatException2.getMessage());
            }
            catch (NumberFormatException localNumberFormatException2)
            {
              i = 0;
            }
            int k = m;
            int j = i;
            label281:
            if ((k > 0) && (k >= j)) {
              localSpannableStringBuilder.setSpan(new ForegroundColorSpan(-7829368), n, i1, 33);
            }
          }
        }
      }
      else
      {
        localSpannableStringBuilder.append((CharSequence)localObject);
      }
    }
    return localSpannableStringBuilder;
  }
  
  public View getView(Context paramContext, View paramView, OnLongClickAndTouchListener paramOnLongClickAndTouchListener, Bundle paramBundle)
  {
    paramView = (ViewGroup)super.getView(paramContext, paramView, paramOnLongClickAndTouchListener, paramBundle);
    paramBundle = new StructMsgForHypertext.HyperTextView(paramContext);
    Resources localResources = paramContext.getResources();
    paramBundle.setPadding((int)localResources.getDimension(2131299802), (int)localResources.getDimension(2131299804), (int)localResources.getDimension(2131299803), (int)localResources.getDimension(2131299801));
    paramBundle.setText(getSpannableString(true));
    paramBundle.setTextSize(0, ChatTextSizeSettingActivity.a(paramContext));
    paramBundle.setTextColor(paramContext.getResources().getColor(2131165687));
    paramBundle.setLinkTextColor(paramContext.getResources().getColor(2131166583));
    paramBundle.setLinksClickable(false);
    paramBundle.setMovementMethod(LinkMovementMethod.getInstance());
    paramBundle.setOnTouchListener(paramOnLongClickAndTouchListener);
    paramBundle.setOnLongClickListener(paramOnLongClickAndTouchListener);
    paramBundle.setTag(2131435213, this);
    paramView.addView(paramBundle);
    paramContext = paramView.getLayoutParams();
    if (paramContext == null)
    {
      new LinearLayout.LayoutParams(BaseChatItemLayout.B, -2);
    }
    else
    {
      paramContext.width = BaseChatItemLayout.B;
      paramContext.height = -2;
    }
    paramView.setLongClickable(true);
    paramView.setTag(2131446476, this);
    return paramView;
  }
  
  protected void parseItem(StructMsgNode paramStructMsgNode)
  {
    if (paramStructMsgNode == null) {
      return;
    }
    this.mHpertextArray = new ArrayList();
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramStructMsgNode.a())
    {
      Object localObject3 = paramStructMsgNode.a(i);
      if (localObject3 != null)
      {
        Object localObject1;
        Object localObject2;
        if (((StructMsgNode)localObject3).d())
        {
          localObject1 = ((StructMsgNode)localObject3).a("url");
          localObject2 = ((StructMsgNode)localObject3).a("action");
          String str1 = ((StructMsgNode)localObject3).a("actionData");
          String str2 = ((StructMsgNode)localObject3).a("a_actionData");
          String str3 = ((StructMsgNode)localObject3).a("i_actionData");
          String str4 = ((StructMsgNode)localObject3).a("key");
          String str5 = ((StructMsgNode)localObject3).a("clickcnt");
          localObject3 = StructMsgFactory.a((StructMsgNode)localObject3);
          localObject1 = new StructMsgForHypertext.Hypertext((String)localObject1, (String)localObject2, str1, str2, str3, str4, str5, (String)localObject3);
          this.mHpertextArray.add(localObject1);
          localStringBuilder.append((String)localObject3);
        }
        else
        {
          localObject1 = StructMsgFactory.a((StructMsgNode)localObject3);
          localObject2 = new StructMsgForHypertext.Hypertext((String)localObject1);
          this.mHpertextArray.add(localObject2);
          localStringBuilder.append((String)localObject1);
        }
      }
      i += 1;
    }
    this.mMsgBrief = localStringBuilder.toString();
  }
  
  protected void parseSourceNode(StructMsgNode paramStructMsgNode)
  {
    this.mSourceName = paramStructMsgNode.a("name");
    this.mSourceIcon = paramStructMsgNode.a("icon");
    this.mSourceUrl = paramStructMsgNode.a("url");
  }
  
  public void readExternal(ObjectInput paramObjectInput)
  {
    int i = paramObjectInput.readInt();
    this.mVersion = i;
    if (i == 1) {}
    try
    {
      this.mMsgTemplateID = paramObjectInput.readInt();
      this.mMsgAction = paramObjectInput.readUTF();
      this.mMsgActionData = paramObjectInput.readUTF();
      this.mMsg_A_ActionData = paramObjectInput.readUTF();
      this.mMsg_I_ActionData = paramObjectInput.readUTF();
      this.mMsgUrl = paramObjectInput.readUTF();
      this.mMsgBrief = paramObjectInput.readUTF();
      int j = paramObjectInput.readInt();
      if (j > 0)
      {
        this.mHpertextArray = new ArrayList();
        i = 0;
        while (i < j)
        {
          StructMsgForHypertext.Hypertext localHypertext = new StructMsgForHypertext.Hypertext(paramObjectInput.readUTF(), paramObjectInput.readUTF(), paramObjectInput.readUTF(), paramObjectInput.readUTF(), paramObjectInput.readUTF(), paramObjectInput.readUTF(), paramObjectInput.readUTF(), paramObjectInput.readUTF());
          this.mHpertextArray.add(localHypertext);
          i += 1;
        }
      }
      this.fwFlag = paramObjectInput.readInt();
      this.mSourceName = paramObjectInput.readUTF();
      this.mSourceIcon = paramObjectInput.readUTF();
      this.mSourceUrl = paramObjectInput.readUTF();
      this.msgId = paramObjectInput.readLong();
      this.mPromotionType = paramObjectInput.readInt();
      this.mPromotionMsg = paramObjectInput.readUTF();
      this.mPromotionMenus = paramObjectInput.readUTF();
      this.mPromotionMenuDestructiveIndex = paramObjectInput.readInt();
      return;
    }
    catch (IOException paramObjectInput) {}
  }
  
  protected void toXml(ByteArrayOutputStream paramByteArrayOutputStream, String paramString)
  {
    String str = "action";
    XmlSerializer localXmlSerializer = Xml.newSerializer();
    label772:
    label775:
    label778:
    for (;;)
    {
      try
      {
        localXmlSerializer.setOutput(paramByteArrayOutputStream, paramString);
        localXmlSerializer.startDocument(paramString, Boolean.valueOf(true));
        localXmlSerializer.startTag(null, "msg");
        localXmlSerializer.attribute(null, "serviceID", String.valueOf(this.mMsgServiceID));
        localXmlSerializer.attribute(null, "templateID", String.valueOf(this.mMsgTemplateID));
        paramByteArrayOutputStream = this.mMsgAction;
        paramString = "";
        if (paramByteArrayOutputStream == null) {
          paramByteArrayOutputStream = "";
        } else {
          paramByteArrayOutputStream = this.mMsgAction;
        }
        localXmlSerializer.attribute(null, "action", paramByteArrayOutputStream);
        boolean bool = TextUtils.isEmpty(this.mMsgActionData);
        if (!bool) {
          localXmlSerializer.attribute(null, "actionData", this.mMsgActionData);
        }
        bool = TextUtils.isEmpty(this.mMsg_A_ActionData);
        if (!bool) {
          localXmlSerializer.attribute(null, "a_actionData", this.mMsg_A_ActionData);
        }
        bool = TextUtils.isEmpty(this.mMsg_I_ActionData);
        if (!bool) {
          localXmlSerializer.attribute(null, "i_actionData", this.mMsg_I_ActionData);
        }
        if (this.mMsgUrl == null) {
          paramByteArrayOutputStream = "";
        } else {
          paramByteArrayOutputStream = this.mMsgUrl;
        }
        localXmlSerializer.attribute(null, "url", paramByteArrayOutputStream);
        if (this.fwFlag == 1) {
          localXmlSerializer.attribute(null, "fwflag", String.valueOf(this.fwFlag));
        }
        localXmlSerializer.startTag(null, "item");
        localXmlSerializer.attribute(null, "layout", String.valueOf(this.mHypertextContentLayout));
        localXmlSerializer.startTag(null, "hypertext");
        paramByteArrayOutputStream = paramString;
        if (this.mHpertextArray != null)
        {
          int i = 0;
          paramByteArrayOutputStream = paramString;
          if (i < this.mHpertextArray.size())
          {
            paramByteArrayOutputStream = (StructMsgForHypertext.Hypertext)this.mHpertextArray.get(i);
            localXmlSerializer.startTag(null, "text");
            if (TextUtils.isEmpty(paramByteArrayOutputStream.b)) {
              break label778;
            }
            if (TextUtils.isEmpty(paramByteArrayOutputStream.a)) {
              break label772;
            }
            localXmlSerializer.attribute(null, "url", paramByteArrayOutputStream.a);
            localXmlSerializer.attribute(null, str, paramByteArrayOutputStream.b);
            if (!TextUtils.isEmpty(paramByteArrayOutputStream.c)) {
              localXmlSerializer.attribute(null, "actionData", paramByteArrayOutputStream.c);
            }
            if (!TextUtils.isEmpty(paramByteArrayOutputStream.d)) {
              localXmlSerializer.attribute(null, "a_actionData", paramByteArrayOutputStream.d);
            }
            if (!TextUtils.isEmpty(paramByteArrayOutputStream.e)) {
              localXmlSerializer.attribute(null, "i_actionData", paramByteArrayOutputStream.e);
            }
            if (TextUtils.isEmpty(paramByteArrayOutputStream.f)) {
              break label775;
            }
            localXmlSerializer.attribute(null, "key", paramByteArrayOutputStream.f);
            if (!TextUtils.isEmpty(paramByteArrayOutputStream.g)) {
              localXmlSerializer.attribute(null, "clickcnt", paramByteArrayOutputStream.g);
            }
            if (paramByteArrayOutputStream.h == null) {
              paramByteArrayOutputStream = paramString;
            } else {
              paramByteArrayOutputStream = paramByteArrayOutputStream.h;
            }
            localXmlSerializer.text(paramByteArrayOutputStream);
            localXmlSerializer.endTag(null, "text");
            i += 1;
            continue;
          }
        }
        localXmlSerializer.endTag(null, "hypertext");
        localXmlSerializer.endTag(null, "item");
        localXmlSerializer.startTag(null, "source");
        if (this.mSourceName == null) {
          paramString = paramByteArrayOutputStream;
        } else {
          paramString = this.mSourceName;
        }
        localXmlSerializer.attribute(null, "name", paramString);
        if (this.mSourceIcon == null) {
          paramString = paramByteArrayOutputStream;
        } else {
          paramString = this.mSourceIcon;
        }
        localXmlSerializer.attribute(null, "icon", paramString);
        if (this.mSourceUrl != null) {
          paramByteArrayOutputStream = this.mSourceUrl;
        }
        localXmlSerializer.attribute(null, "url", paramByteArrayOutputStream);
        localXmlSerializer.endTag(null, "source");
        localXmlSerializer.endTag(null, "msg");
        localXmlSerializer.endDocument();
        localXmlSerializer.flush();
        return;
      }
      catch (Exception paramByteArrayOutputStream)
      {
        if (QLog.isColorLevel()) {
          QLog.d("structMsg", 2, paramByteArrayOutputStream.getMessage(), paramByteArrayOutputStream);
        }
        return;
      }
      continue;
    }
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
  {
    paramObjectOutput.writeInt(this.mMsgServiceID);
    paramObjectOutput.writeInt(this.mVersion);
    paramObjectOutput.writeInt(this.mMsgTemplateID);
    Object localObject1 = this.mMsgAction;
    String str = "";
    if (localObject1 == null) {
      localObject1 = "";
    } else {
      localObject1 = this.mMsgAction;
    }
    paramObjectOutput.writeUTF((String)localObject1);
    if (this.mMsgActionData == null) {
      localObject1 = "";
    } else {
      localObject1 = this.mMsgActionData;
    }
    paramObjectOutput.writeUTF((String)localObject1);
    if (this.mMsg_A_ActionData == null) {
      localObject1 = "";
    } else {
      localObject1 = this.mMsg_A_ActionData;
    }
    paramObjectOutput.writeUTF((String)localObject1);
    if (this.mMsg_I_ActionData == null) {
      localObject1 = "";
    } else {
      localObject1 = this.mMsg_I_ActionData;
    }
    paramObjectOutput.writeUTF((String)localObject1);
    if (this.mMsgUrl == null) {
      localObject1 = "";
    } else {
      localObject1 = this.mMsgUrl;
    }
    paramObjectOutput.writeUTF((String)localObject1);
    if (this.mMsgBrief == null) {
      localObject1 = "";
    } else {
      localObject1 = this.mMsgBrief;
    }
    paramObjectOutput.writeUTF((String)localObject1);
    localObject1 = this.mHpertextArray;
    if (localObject1 != null)
    {
      paramObjectOutput.writeInt(((ArrayList)localObject1).size());
      localObject2 = this.mHpertextArray.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        StructMsgForHypertext.Hypertext localHypertext = (StructMsgForHypertext.Hypertext)((Iterator)localObject2).next();
        if (localHypertext.a != null) {
          localObject1 = localHypertext.a;
        } else {
          localObject1 = "";
        }
        paramObjectOutput.writeUTF((String)localObject1);
        if (localHypertext.b != null) {
          localObject1 = localHypertext.b;
        } else {
          localObject1 = "";
        }
        paramObjectOutput.writeUTF((String)localObject1);
        if (localHypertext.c != null) {
          localObject1 = localHypertext.c;
        } else {
          localObject1 = "";
        }
        paramObjectOutput.writeUTF((String)localObject1);
        if (localHypertext.d != null) {
          localObject1 = localHypertext.d;
        } else {
          localObject1 = "";
        }
        paramObjectOutput.writeUTF((String)localObject1);
        if (localHypertext.e != null) {
          localObject1 = localHypertext.e;
        } else {
          localObject1 = "";
        }
        paramObjectOutput.writeUTF((String)localObject1);
        if (localHypertext.f != null) {
          localObject1 = localHypertext.f;
        } else {
          localObject1 = "";
        }
        paramObjectOutput.writeUTF((String)localObject1);
        if (localHypertext.g != null) {
          localObject1 = localHypertext.g;
        } else {
          localObject1 = "";
        }
        paramObjectOutput.writeUTF((String)localObject1);
        if (localHypertext.h != null) {
          localObject1 = localHypertext.h;
        } else {
          localObject1 = "";
        }
        paramObjectOutput.writeUTF((String)localObject1);
      }
    }
    paramObjectOutput.writeInt(0);
    paramObjectOutput.writeInt(this.fwFlag);
    Object localObject2 = this.mSourceName;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    paramObjectOutput.writeUTF((String)localObject1);
    localObject2 = this.mSourceIcon;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    paramObjectOutput.writeUTF((String)localObject1);
    localObject2 = this.mSourceUrl;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    paramObjectOutput.writeUTF((String)localObject1);
    paramObjectOutput.writeLong(this.msgId);
    paramObjectOutput.writeInt(this.mPromotionType);
    if (this.mPromotionMsg == null) {
      localObject1 = "";
    } else {
      localObject1 = this.mPromotionMsg;
    }
    paramObjectOutput.writeUTF((String)localObject1);
    if (this.mPromotionMenus == null) {
      localObject1 = str;
    } else {
      localObject1 = this.mPromotionMenus;
    }
    paramObjectOutput.writeUTF((String)localObject1);
    paramObjectOutput.writeInt(this.mPromotionMenuDestructiveIndex);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgForHypertext
 * JD-Core Version:    0.7.0.1
 */