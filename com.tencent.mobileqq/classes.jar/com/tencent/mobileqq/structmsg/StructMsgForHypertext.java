package com.tencent.mobileqq.structmsg;

import agej;
import agjk;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.method.LinkMovementMethod;
import android.util.Xml;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import bdow;
import bdpk;
import bdpl;
import bdpm;
import bdqc;
import beqz;
import beyq;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener.Adapter;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
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
  public ArrayList<bdpm> mHpertextArray;
  protected boolean mHyperClick;
  public int mHypertextContentLayout = 0;
  public String mSourceIcon;
  public String mSourceName;
  protected View.OnClickListener mSourceOnClickListener = new bdpl(this);
  public String mSourceUrl;
  private URLDrawableDownListener.Adapter mUrlAdapter = new bdpk(this);
  
  public StructMsgForHypertext() {}
  
  public StructMsgForHypertext(Bundle paramBundle)
  {
    super(paramBundle);
    this.mMsgServiceID = 3;
    a(paramBundle.getString("forward_text"));
    this.mSourceName = paramBundle.getString("struct_share_key_source_name");
    this.mSourceIcon = paramBundle.getString("struct_share_key_source_icon");
    this.mSourceUrl = paramBundle.getString("struct_share_key_source_url");
  }
  
  public StructMsgForHypertext(bdqc parambdqc, int paramInt)
  {
    super(parambdqc);
    this.mMsgServiceID = paramInt;
    int i = parambdqc.a();
    paramInt = 0;
    if (paramInt < i)
    {
      bdqc localbdqc = parambdqc.a(paramInt);
      if (localbdqc == null) {}
      for (;;)
      {
        paramInt += 1;
        break;
        if (localbdqc.b.equals("source"))
        {
          parseSourceNode(localbdqc);
        }
        else if (localbdqc.a == 1)
        {
          for (localbdqc = localbdqc.b(); (localbdqc != null) && (localbdqc.a != 1); localbdqc = bdow.a(localbdqc)) {}
          parseItem(localbdqc);
        }
      }
    }
  }
  
  private void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.mHpertextArray = new ArrayList();
    StringBuilder localStringBuilder = new StringBuilder();
    Matcher localMatcher = Pattern.compile("<a.*?/a>").matcher(paramString);
    for (int i = 0; localMatcher.find(); i = localMatcher.end())
    {
      String str = paramString.substring(i, localMatcher.start());
      this.mHpertextArray.add(new bdpm(str));
      localStringBuilder.append(str);
      Object localObject2 = localMatcher.group();
      str = "";
      Object localObject1 = Pattern.compile(">.*?</a>").matcher((CharSequence)localObject2);
      while (((Matcher)localObject1).find()) {
        str = ((Matcher)localObject1).group().replaceAll(">|</a>", "");
      }
      localObject1 = "";
      localObject2 = Pattern.compile("href\\s*=\\s*(\"([^\"]*\")|'[^']*'|([^'\">\\s]+))").matcher((CharSequence)localObject2);
      while (((Matcher)localObject2).find()) {
        localObject1 = ((Matcher)localObject2).group().replaceAll("href\\s*=\\s*(['|\"]*)|['|\"]*", "");
      }
      this.mHpertextArray.add(new bdpm((String)localObject1, "web", null, null, null, null, null, str));
      localStringBuilder.append(str);
    }
    paramString = paramString.substring(i);
    this.mHpertextArray.add(new bdpm(paramString));
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
      if (QLog.isColorLevel()) {
        QLog.d("HypertextMsg", 2, "getBytes failure");
      }
    }
    return null;
  }
  
  public View getPreDialogView(Context paramContext, View paramView)
  {
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    localLinearLayout.setOrientation(1);
    paramView = localLinearLayout.getLayoutParams();
    if (paramView == null) {
      paramView = new LinearLayout.LayoutParams(BaseChatItemLayout.B, -2);
    }
    for (;;)
    {
      localLinearLayout.setLayoutParams(paramView);
      paramView = new StructMsgForHypertext.HyperTextView(paramContext);
      Resources localResources = paramContext.getResources();
      paramView.setPadding((int)localResources.getDimension(2131298913), (int)localResources.getDimension(2131298915), (int)localResources.getDimension(2131298914), (int)localResources.getDimension(2131298912));
      paramView.setText(getSpannableString(false));
      paramView.setMaxLines(10);
      paramView.setTextSize(0, ChatTextSizeSettingActivity.a(paramContext));
      paramView.setTextColor(paramContext.getResources().getColor(2131165409));
      paramView.setLinkTextColor(paramContext.getResources().getColor(2131165857));
      paramView.setLinksClickable(false);
      paramView.setMovementMethod(LinkMovementMethod.getInstance());
      localLinearLayout.addView(paramView);
      localLinearLayout.setLongClickable(true);
      localLinearLayout.setTag(2131378101, this);
      return localLinearLayout;
      paramView.width = BaseChatItemLayout.B;
      paramView.height = -2;
    }
  }
  
  public String getSourceName()
  {
    return this.mSourceName;
  }
  
  public View getSourceView(Context paramContext, View paramView)
  {
    boolean bool2 = true;
    if ((TextUtils.isEmpty(this.mSourceName)) && (TextUtils.isEmpty(this.mSourceIcon))) {
      return null;
    }
    Resources localResources = paramContext.getResources();
    if (paramView == null)
    {
      paramView = new TextView(paramContext);
      paramView.setSingleLine(true);
      paramView.setGravity(16);
      paramView.setEllipsize(TextUtils.TruncateAt.END);
      paramView.setTextColor(-1);
      paramView.setTextSize(2, 12.0F);
      paramView.setPadding(agej.a(5.0F, localResources), 0, agej.a(5.0F, localResources), 0);
      paramView.setBackgroundResource(2130842581);
    }
    TextView localTextView;
    for (;;)
    {
      localTextView = (TextView)paramView;
      localTextView.setText(this.mSourceName);
      try
      {
        new URL(this.mSourceIcon);
        i = 1;
      }
      catch (MalformedURLException localMalformedURLException)
      {
        for (;;)
        {
          String str;
          Object localObject;
          ColorDrawable localColorDrawable;
          localMalformedURLException.printStackTrace();
          int i = 0;
          continue;
          boolean bool1 = false;
          continue;
          localTextView.setCompoundDrawables(null, null, null, null);
        }
      }
      if ((!TextUtils.isEmpty(this.mSourceIcon)) && (i != 0))
      {
        str = this.mSourceIcon;
        localObject = localResources.getDrawable(2130850462);
        ((Drawable)localObject).setBounds(0, 0, agej.a(12.0F, localResources), agej.a(12.0F, localResources));
        localColorDrawable = new ColorDrawable(15790320);
        localColorDrawable.setBounds(0, 0, agej.a(12.0F, localResources), agej.a(12.0F, localResources));
        localObject = URLDrawable.getDrawable(str, (Drawable)localObject, localColorDrawable);
        bool1 = bool2;
        if (!beqz.b(str))
        {
          if (!beyq.a(paramContext)) {
            bool1 = bool2;
          }
        }
        else
        {
          ((URLDrawable)localObject).setAutoDownload(bool1);
          ((URLDrawable)localObject).setBounds(0, 0, agej.a(12.0F, localResources), agej.a(12.0F, localResources));
          localTextView.setCompoundDrawablePadding(agej.a(3.0F, localResources));
          localTextView.setCompoundDrawables((Drawable)localObject, null, null, null);
          localTextView.setPadding(agej.a(5.0F, localResources), 0, agej.a(5.0F, localResources), 0);
          paramView.setTag(this);
          paramView.setOnClickListener(this.mSourceOnClickListener);
          return paramView;
        }
      }
    }
  }
  
  /* Error */
  public android.text.SpannableStringBuilder getSpannableString(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 123	com/tencent/mobileqq/structmsg/StructMsgForHypertext:mHpertextArray	Ljava/util/ArrayList;
    //   4: ifnonnull +13 -> 17
    //   7: new 451	android/text/SpannableStringBuilder
    //   10: dup
    //   11: ldc 168
    //   13: invokespecial 453	android/text/SpannableStringBuilder:<init>	(Ljava/lang/CharSequence;)V
    //   16: areturn
    //   17: new 451	android/text/SpannableStringBuilder
    //   20: dup
    //   21: invokespecial 454	android/text/SpannableStringBuilder:<init>	()V
    //   24: astore 8
    //   26: aload_0
    //   27: getfield 123	com/tencent/mobileqq/structmsg/StructMsgForHypertext:mHpertextArray	Ljava/util/ArrayList;
    //   30: invokevirtual 458	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   33: astore 9
    //   35: aload 9
    //   37: invokeinterface 463 1 0
    //   42: ifeq +256 -> 298
    //   45: aload 9
    //   47: invokeinterface 467 1 0
    //   52: checkcast 153	bdpm
    //   55: astore 7
    //   57: aload 7
    //   59: getfield 470	bdpm:h	Ljava/lang/String;
    //   62: astore 10
    //   64: aload 7
    //   66: getfield 471	bdpm:b	Ljava/lang/String;
    //   69: invokestatic 118	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   72: ifne +215 -> 287
    //   75: aload 8
    //   77: invokevirtual 472	android/text/SpannableStringBuilder:toString	()Ljava/lang/String;
    //   80: invokevirtual 475	java/lang/String:length	()I
    //   83: istore 5
    //   85: aload 10
    //   87: invokevirtual 475	java/lang/String:length	()I
    //   90: iload 5
    //   92: iadd
    //   93: istore 6
    //   95: aload 8
    //   97: aload 10
    //   99: invokevirtual 478	android/text/SpannableStringBuilder:append	(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;
    //   102: pop
    //   103: iload_1
    //   104: ifeq -69 -> 35
    //   107: aload 8
    //   109: new 480	com/tencent/mobileqq/structmsg/StructMsgForHypertext$HyperSpannable
    //   112: dup
    //   113: aload_0
    //   114: aload 7
    //   116: invokespecial 483	com/tencent/mobileqq/structmsg/StructMsgForHypertext$HyperSpannable:<init>	(Lcom/tencent/mobileqq/structmsg/StructMsgForHypertext;Lbdpm;)V
    //   119: iload 5
    //   121: iload 6
    //   123: bipush 33
    //   125: invokevirtual 487	android/text/SpannableStringBuilder:setSpan	(Ljava/lang/Object;III)V
    //   128: aload_0
    //   129: getfield 491	com/tencent/mobileqq/structmsg/StructMsgForHypertext:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   132: ifnull -97 -> 35
    //   135: aload 7
    //   137: getfield 494	bdpm:f	Ljava/lang/String;
    //   140: invokestatic 118	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   143: ifne -108 -> 35
    //   146: aload_0
    //   147: getfield 491	com/tencent/mobileqq/structmsg/StructMsgForHypertext:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   150: new 125	java/lang/StringBuilder
    //   153: dup
    //   154: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   157: aload_0
    //   158: getfield 28	com/tencent/mobileqq/structmsg/StructMsgForHypertext:KEY_QD_HYPERTEXT_CLICK_STATE	Ljava/lang/String;
    //   161: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: aload 7
    //   166: getfield 494	bdpm:f	Ljava/lang/String;
    //   169: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: invokevirtual 194	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   175: invokevirtual 499	com/tencent/mobileqq/data/MessageRecord:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   178: astore 10
    //   180: aload 7
    //   182: getfield 502	bdpm:g	Ljava/lang/String;
    //   185: invokestatic 118	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   188: ifne +118 -> 306
    //   191: aload 7
    //   193: getfield 502	bdpm:g	Ljava/lang/String;
    //   196: invokestatic 508	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   199: invokevirtual 511	java/lang/Integer:intValue	()I
    //   202: istore_2
    //   203: iload_2
    //   204: istore_3
    //   205: aload 10
    //   207: invokestatic 118	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   210: ifne +69 -> 279
    //   213: aload 10
    //   215: invokestatic 508	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   218: invokevirtual 511	java/lang/Integer:intValue	()I
    //   221: istore_3
    //   222: iload_2
    //   223: istore 4
    //   225: iload_3
    //   226: istore_2
    //   227: iload_2
    //   228: ifle -193 -> 35
    //   231: iload_2
    //   232: iload 4
    //   234: if_icmplt -199 -> 35
    //   237: aload 8
    //   239: new 513	android/text/style/ForegroundColorSpan
    //   242: dup
    //   243: ldc_w 514
    //   246: invokespecial 515	android/text/style/ForegroundColorSpan:<init>	(I)V
    //   249: iload 5
    //   251: iload 6
    //   253: bipush 33
    //   255: invokevirtual 487	android/text/SpannableStringBuilder:setSpan	(Ljava/lang/Object;III)V
    //   258: goto -223 -> 35
    //   261: astore 7
    //   263: iconst_0
    //   264: istore_2
    //   265: ldc_w 517
    //   268: iconst_1
    //   269: aload 7
    //   271: invokevirtual 520	java/lang/NumberFormatException:getMessage	()Ljava/lang/String;
    //   274: invokestatic 234	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   277: iload_2
    //   278: istore_3
    //   279: iconst_0
    //   280: istore_2
    //   281: iload_3
    //   282: istore 4
    //   284: goto -57 -> 227
    //   287: aload 8
    //   289: aload 10
    //   291: invokevirtual 478	android/text/SpannableStringBuilder:append	(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;
    //   294: pop
    //   295: goto -260 -> 35
    //   298: aload 8
    //   300: areturn
    //   301: astore 7
    //   303: goto -38 -> 265
    //   306: iconst_0
    //   307: istore_2
    //   308: goto -105 -> 203
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	311	0	this	StructMsgForHypertext
    //   0	311	1	paramBoolean	boolean
    //   202	106	2	i	int
    //   204	78	3	j	int
    //   223	60	4	k	int
    //   83	167	5	m	int
    //   93	159	6	n	int
    //   55	137	7	localbdpm	bdpm
    //   261	9	7	localNumberFormatException1	java.lang.NumberFormatException
    //   301	1	7	localNumberFormatException2	java.lang.NumberFormatException
    //   24	275	8	localSpannableStringBuilder	android.text.SpannableStringBuilder
    //   33	13	9	localIterator	Iterator
    //   62	228	10	str	String
    // Exception table:
    //   from	to	target	type
    //   180	203	261	java/lang/NumberFormatException
    //   205	222	301	java/lang/NumberFormatException
  }
  
  public View getView(Context paramContext, View paramView, agjk paramagjk, Bundle paramBundle)
  {
    paramView = (ViewGroup)super.getView(paramContext, paramView, paramagjk, paramBundle);
    paramBundle = new StructMsgForHypertext.HyperTextView(paramContext);
    Resources localResources = paramContext.getResources();
    paramBundle.setPadding((int)localResources.getDimension(2131298913), (int)localResources.getDimension(2131298915), (int)localResources.getDimension(2131298914), (int)localResources.getDimension(2131298912));
    paramBundle.setText(getSpannableString(true));
    paramBundle.setTextSize(0, ChatTextSizeSettingActivity.a(paramContext));
    paramBundle.setTextColor(paramContext.getResources().getColor(2131165409));
    paramBundle.setLinkTextColor(paramContext.getResources().getColor(2131165857));
    paramBundle.setLinksClickable(false);
    paramBundle.setMovementMethod(LinkMovementMethod.getInstance());
    paramBundle.setOnTouchListener(paramagjk);
    paramBundle.setOnLongClickListener(paramagjk);
    paramBundle.setTag(2131368207, this);
    paramView.addView(paramBundle);
    paramContext = paramView.getLayoutParams();
    if (paramContext == null) {
      new LinearLayout.LayoutParams(BaseChatItemLayout.B, -2);
    }
    for (;;)
    {
      paramView.setLongClickable(true);
      paramView.setTag(2131378101, this);
      return paramView;
      paramContext.width = BaseChatItemLayout.B;
      paramContext.height = -2;
    }
  }
  
  protected void parseItem(bdqc parambdqc)
  {
    if (parambdqc == null) {
      return;
    }
    this.mHpertextArray = new ArrayList();
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    if (i < parambdqc.a())
    {
      Object localObject3 = parambdqc.a(i);
      if (localObject3 == null) {}
      for (;;)
      {
        i += 1;
        break;
        Object localObject1;
        Object localObject2;
        if (((bdqc)localObject3).a())
        {
          localObject1 = ((bdqc)localObject3).a("url");
          localObject2 = ((bdqc)localObject3).a("action");
          String str1 = ((bdqc)localObject3).a("actionData");
          String str2 = ((bdqc)localObject3).a("a_actionData");
          String str3 = ((bdqc)localObject3).a("i_actionData");
          String str4 = ((bdqc)localObject3).a("key");
          String str5 = ((bdqc)localObject3).a("clickcnt");
          localObject3 = bdow.a((bdqc)localObject3);
          localObject1 = new bdpm((String)localObject1, (String)localObject2, str1, str2, str3, str4, str5, (String)localObject3);
          this.mHpertextArray.add(localObject1);
          localStringBuilder.append((String)localObject3);
        }
        else
        {
          localObject1 = bdow.a((bdqc)localObject3);
          localObject2 = new bdpm((String)localObject1);
          this.mHpertextArray.add(localObject2);
          localStringBuilder.append((String)localObject1);
        }
      }
    }
    this.mMsgBrief = localStringBuilder.toString();
  }
  
  protected void parseSourceNode(bdqc parambdqc)
  {
    this.mSourceName = parambdqc.a("name");
    this.mSourceIcon = parambdqc.a("icon");
    this.mSourceUrl = parambdqc.a("url");
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
          bdpm localbdpm = new bdpm(paramObjectInput.readUTF(), paramObjectInput.readUTF(), paramObjectInput.readUTF(), paramObjectInput.readUTF(), paramObjectInput.readUTF(), paramObjectInput.readUTF(), paramObjectInput.readUTF(), paramObjectInput.readUTF());
          this.mHpertextArray.add(localbdpm);
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
    XmlSerializer localXmlSerializer = Xml.newSerializer();
    try
    {
      localXmlSerializer.setOutput(paramByteArrayOutputStream, paramString);
      localXmlSerializer.startDocument(paramString, Boolean.valueOf(true));
      localXmlSerializer.startTag(null, "msg");
      localXmlSerializer.attribute(null, "serviceID", String.valueOf(this.mMsgServiceID));
      localXmlSerializer.attribute(null, "templateID", String.valueOf(this.mMsgTemplateID));
      label187:
      int i;
      if (this.mMsgAction == null)
      {
        paramByteArrayOutputStream = "";
        localXmlSerializer.attribute(null, "action", paramByteArrayOutputStream);
        if (!TextUtils.isEmpty(this.mMsgActionData)) {
          localXmlSerializer.attribute(null, "actionData", this.mMsgActionData);
        }
        if (!TextUtils.isEmpty(this.mMsg_A_ActionData)) {
          localXmlSerializer.attribute(null, "a_actionData", this.mMsg_A_ActionData);
        }
        if (!TextUtils.isEmpty(this.mMsg_I_ActionData)) {
          localXmlSerializer.attribute(null, "i_actionData", this.mMsg_I_ActionData);
        }
        if (this.mMsgUrl != null) {
          break label542;
        }
        paramByteArrayOutputStream = "";
        localXmlSerializer.attribute(null, "url", paramByteArrayOutputStream);
        if (this.fwFlag == 1) {
          localXmlSerializer.attribute(null, "fwflag", String.valueOf(this.fwFlag));
        }
        localXmlSerializer.startTag(null, "item");
        localXmlSerializer.attribute(null, "layout", String.valueOf(this.mHypertextContentLayout));
        localXmlSerializer.startTag(null, "hypertext");
        if (this.mHpertextArray == null) {
          break label558;
        }
        i = 0;
        label279:
        if (i >= this.mHpertextArray.size()) {
          break label558;
        }
        paramByteArrayOutputStream = (bdpm)this.mHpertextArray.get(i);
        localXmlSerializer.startTag(null, "text");
        if (!TextUtils.isEmpty(paramByteArrayOutputStream.b))
        {
          if (!TextUtils.isEmpty(paramByteArrayOutputStream.a)) {
            localXmlSerializer.attribute(null, "url", paramByteArrayOutputStream.a);
          }
          localXmlSerializer.attribute(null, "action", paramByteArrayOutputStream.b);
          if (!TextUtils.isEmpty(paramByteArrayOutputStream.c)) {
            localXmlSerializer.attribute(null, "actionData", paramByteArrayOutputStream.c);
          }
          if (!TextUtils.isEmpty(paramByteArrayOutputStream.d)) {
            localXmlSerializer.attribute(null, "a_actionData", paramByteArrayOutputStream.d);
          }
          if (!TextUtils.isEmpty(paramByteArrayOutputStream.e)) {
            localXmlSerializer.attribute(null, "i_actionData", paramByteArrayOutputStream.e);
          }
          if (!TextUtils.isEmpty(paramByteArrayOutputStream.f)) {
            localXmlSerializer.attribute(null, "key", paramByteArrayOutputStream.f);
          }
          if (!TextUtils.isEmpty(paramByteArrayOutputStream.g)) {
            localXmlSerializer.attribute(null, "clickcnt", paramByteArrayOutputStream.g);
          }
        }
        if (paramByteArrayOutputStream.h != null) {
          break label550;
        }
      }
      label542:
      label550:
      for (paramByteArrayOutputStream = "";; paramByteArrayOutputStream = paramByteArrayOutputStream.h)
      {
        localXmlSerializer.text(paramByteArrayOutputStream);
        localXmlSerializer.endTag(null, "text");
        i += 1;
        break label279;
        paramByteArrayOutputStream = this.mMsgAction;
        break;
        paramByteArrayOutputStream = this.mMsgUrl;
        break label187;
      }
      label558:
      localXmlSerializer.endTag(null, "hypertext");
      localXmlSerializer.endTag(null, "item");
      localXmlSerializer.startTag(null, "source");
      if (this.mSourceName == null)
      {
        paramByteArrayOutputStream = "";
        localXmlSerializer.attribute(null, "name", paramByteArrayOutputStream);
        if (this.mSourceIcon != null) {
          break label708;
        }
        paramByteArrayOutputStream = "";
        label626:
        localXmlSerializer.attribute(null, "icon", paramByteArrayOutputStream);
        if (this.mSourceUrl != null) {
          break label716;
        }
      }
      label708:
      label716:
      for (paramByteArrayOutputStream = "";; paramByteArrayOutputStream = this.mSourceUrl)
      {
        localXmlSerializer.attribute(null, "url", paramByteArrayOutputStream);
        localXmlSerializer.endTag(null, "source");
        localXmlSerializer.endTag(null, "msg");
        localXmlSerializer.endDocument();
        localXmlSerializer.flush();
        return;
        paramByteArrayOutputStream = this.mSourceName;
        break;
        paramByteArrayOutputStream = this.mSourceIcon;
        break label626;
      }
      return;
    }
    catch (Exception paramByteArrayOutputStream)
    {
      if (QLog.isColorLevel()) {
        QLog.d("structMsg", 2, paramByteArrayOutputStream.getMessage(), paramByteArrayOutputStream);
      }
    }
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
  {
    paramObjectOutput.writeInt(this.mMsgServiceID);
    paramObjectOutput.writeInt(this.mVersion);
    paramObjectOutput.writeInt(this.mMsgTemplateID);
    label57:
    label74:
    label91:
    label108:
    label125:
    bdpm localbdpm;
    if (this.mMsgAction == null)
    {
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.mMsgActionData != null) {
        break label359;
      }
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.mMsg_A_ActionData != null) {
        break label367;
      }
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.mMsg_I_ActionData != null) {
        break label375;
      }
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.mMsgUrl != null) {
        break label383;
      }
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.mMsgBrief != null) {
        break label391;
      }
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.mHpertextArray == null) {
        break label447;
      }
      paramObjectOutput.writeInt(this.mHpertextArray.size());
      Iterator localIterator = this.mHpertextArray.iterator();
      label160:
      if (!localIterator.hasNext()) {
        break label454;
      }
      localbdpm = (bdpm)localIterator.next();
      if (localbdpm.a == null) {
        break label399;
      }
      str = localbdpm.a;
      label194:
      paramObjectOutput.writeUTF(str);
      if (localbdpm.b == null) {
        break label405;
      }
      str = localbdpm.b;
      label215:
      paramObjectOutput.writeUTF(str);
      if (localbdpm.c == null) {
        break label411;
      }
      str = localbdpm.c;
      label236:
      paramObjectOutput.writeUTF(str);
      if (localbdpm.d == null) {
        break label417;
      }
      str = localbdpm.d;
      label257:
      paramObjectOutput.writeUTF(str);
      if (localbdpm.e == null) {
        break label423;
      }
      str = localbdpm.e;
      label278:
      paramObjectOutput.writeUTF(str);
      if (localbdpm.f == null) {
        break label429;
      }
      str = localbdpm.f;
      label299:
      paramObjectOutput.writeUTF(str);
      if (localbdpm.g == null) {
        break label435;
      }
      str = localbdpm.g;
      label320:
      paramObjectOutput.writeUTF(str);
      if (localbdpm.h == null) {
        break label441;
      }
    }
    label391:
    label399:
    label405:
    label411:
    label417:
    label423:
    label429:
    label435:
    label441:
    for (String str = localbdpm.h;; str = "")
    {
      paramObjectOutput.writeUTF(str);
      break label160;
      str = this.mMsgAction;
      break;
      label359:
      str = this.mMsgActionData;
      break label57;
      label367:
      str = this.mMsg_A_ActionData;
      break label74;
      label375:
      str = this.mMsg_I_ActionData;
      break label91;
      label383:
      str = this.mMsgUrl;
      break label108;
      str = this.mMsgBrief;
      break label125;
      str = "";
      break label194;
      str = "";
      break label215;
      str = "";
      break label236;
      str = "";
      break label257;
      str = "";
      break label278;
      str = "";
      break label299;
      str = "";
      break label320;
    }
    label447:
    paramObjectOutput.writeInt(0);
    label454:
    paramObjectOutput.writeInt(this.fwFlag);
    if (this.mSourceName == null)
    {
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.mSourceIcon != null) {
        break label588;
      }
      str = "";
      label491:
      paramObjectOutput.writeUTF(str);
      if (this.mSourceUrl != null) {
        break label596;
      }
      str = "";
      label508:
      paramObjectOutput.writeUTF(str);
      paramObjectOutput.writeLong(this.msgId);
      paramObjectOutput.writeInt(this.mPromotionType);
      if (this.mPromotionMsg != null) {
        break label604;
      }
      str = "";
      label545:
      paramObjectOutput.writeUTF(str);
      if (this.mPromotionMenus != null) {
        break label612;
      }
    }
    label588:
    label596:
    label604:
    label612:
    for (str = "";; str = this.mPromotionMenus)
    {
      paramObjectOutput.writeUTF(str);
      paramObjectOutput.writeInt(this.mPromotionMenuDestructiveIndex);
      return;
      str = this.mSourceName;
      break;
      str = this.mSourceIcon;
      break label491;
      str = this.mSourceUrl;
      break label508;
      str = this.mPromotionMsg;
      break label545;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgForHypertext
 * JD-Core Version:    0.7.0.1
 */