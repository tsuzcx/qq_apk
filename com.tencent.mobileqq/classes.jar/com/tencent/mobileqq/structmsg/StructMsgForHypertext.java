package com.tencent.mobileqq.structmsg;

import afce;
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
import bchh;
import bchv;
import bchw;
import bchx;
import bcin;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener.Adapter;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
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
  public ArrayList<bchx> mHpertextArray;
  protected boolean mHyperClick;
  public int mHypertextContentLayout = 0;
  public String mSourceIcon;
  public String mSourceName;
  protected View.OnClickListener mSourceOnClickListener = new bchw(this);
  public String mSourceUrl;
  private URLDrawableDownListener.Adapter mUrlAdapter = new bchv(this);
  
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
  
  public StructMsgForHypertext(bcin parambcin, int paramInt)
  {
    super(parambcin);
    this.mMsgServiceID = paramInt;
    int i = parambcin.a();
    paramInt = 0;
    if (paramInt < i)
    {
      bcin localbcin = parambcin.a(paramInt);
      if (localbcin == null) {}
      for (;;)
      {
        paramInt += 1;
        break;
        if (localbcin.b.equals("source"))
        {
          parseSourceNode(localbcin);
        }
        else if (localbcin.a == 1)
        {
          for (localbcin = localbcin.b(); (localbcin != null) && (localbcin.a != 1); localbcin = bchh.a(localbcin)) {}
          parseItem(localbcin);
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
      this.mHpertextArray.add(new bchx(str));
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
      this.mHpertextArray.add(new bchx((String)localObject1, "web", null, null, null, null, null, str));
      localStringBuilder.append(str);
    }
    paramString = paramString.substring(i);
    this.mHpertextArray.add(new bchx(paramString));
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
      paramView.setPadding((int)localResources.getDimension(2131298978), (int)localResources.getDimension(2131298980), (int)localResources.getDimension(2131298979), (int)localResources.getDimension(2131298977));
      paramView.setText(getSpannableString(false));
      paramView.setMaxLines(10);
      paramView.setTextSize(0, ChatTextSizeSettingActivity.a(paramContext));
      paramView.setTextColor(paramContext.getResources().getColor(2131165417));
      paramView.setLinkTextColor(paramContext.getResources().getColor(2131165875));
      paramView.setLinksClickable(false);
      paramView.setMovementMethod(LinkMovementMethod.getInstance());
      localLinearLayout.addView(paramView);
      localLinearLayout.setLongClickable(true);
      localLinearLayout.setTag(2131377871, this);
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
      paramView.setPadding(AIOUtils.dp2px(5.0F, localResources), 0, AIOUtils.dp2px(5.0F, localResources), 0);
      paramView.setBackgroundResource(2130842626);
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
        localObject = localResources.getDrawable(2130850387);
        ((Drawable)localObject).setBounds(0, 0, AIOUtils.dp2px(12.0F, localResources), AIOUtils.dp2px(12.0F, localResources));
        localColorDrawable = new ColorDrawable(15790320);
        localColorDrawable.setBounds(0, 0, AIOUtils.dp2px(12.0F, localResources), AIOUtils.dp2px(12.0F, localResources));
        localObject = URLDrawable.getDrawable(str, (Drawable)localObject, localColorDrawable);
        bool1 = bool2;
        if (!AbsDownloader.hasFile(str))
        {
          if (!URLDrawableHelper.isMobileNetAndAutodownDisabled(paramContext)) {
            bool1 = bool2;
          }
        }
        else
        {
          ((URLDrawable)localObject).setAutoDownload(bool1);
          ((URLDrawable)localObject).setBounds(0, 0, AIOUtils.dp2px(12.0F, localResources), AIOUtils.dp2px(12.0F, localResources));
          localTextView.setCompoundDrawablePadding(AIOUtils.dp2px(3.0F, localResources));
          localTextView.setCompoundDrawables((Drawable)localObject, null, null, null);
          localTextView.setPadding(AIOUtils.dp2px(5.0F, localResources), 0, AIOUtils.dp2px(5.0F, localResources), 0);
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
    //   7: new 454	android/text/SpannableStringBuilder
    //   10: dup
    //   11: ldc 168
    //   13: invokespecial 456	android/text/SpannableStringBuilder:<init>	(Ljava/lang/CharSequence;)V
    //   16: areturn
    //   17: new 454	android/text/SpannableStringBuilder
    //   20: dup
    //   21: invokespecial 457	android/text/SpannableStringBuilder:<init>	()V
    //   24: astore 8
    //   26: aload_0
    //   27: getfield 123	com/tencent/mobileqq/structmsg/StructMsgForHypertext:mHpertextArray	Ljava/util/ArrayList;
    //   30: invokevirtual 461	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   33: astore 9
    //   35: aload 9
    //   37: invokeinterface 466 1 0
    //   42: ifeq +256 -> 298
    //   45: aload 9
    //   47: invokeinterface 470 1 0
    //   52: checkcast 153	bchx
    //   55: astore 7
    //   57: aload 7
    //   59: getfield 473	bchx:h	Ljava/lang/String;
    //   62: astore 10
    //   64: aload 7
    //   66: getfield 474	bchx:b	Ljava/lang/String;
    //   69: invokestatic 118	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   72: ifne +215 -> 287
    //   75: aload 8
    //   77: invokevirtual 475	android/text/SpannableStringBuilder:toString	()Ljava/lang/String;
    //   80: invokevirtual 478	java/lang/String:length	()I
    //   83: istore 5
    //   85: aload 10
    //   87: invokevirtual 478	java/lang/String:length	()I
    //   90: iload 5
    //   92: iadd
    //   93: istore 6
    //   95: aload 8
    //   97: aload 10
    //   99: invokevirtual 481	android/text/SpannableStringBuilder:append	(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;
    //   102: pop
    //   103: iload_1
    //   104: ifeq -69 -> 35
    //   107: aload 8
    //   109: new 483	com/tencent/mobileqq/structmsg/StructMsgForHypertext$HyperSpannable
    //   112: dup
    //   113: aload_0
    //   114: aload 7
    //   116: invokespecial 486	com/tencent/mobileqq/structmsg/StructMsgForHypertext$HyperSpannable:<init>	(Lcom/tencent/mobileqq/structmsg/StructMsgForHypertext;Lbchx;)V
    //   119: iload 5
    //   121: iload 6
    //   123: bipush 33
    //   125: invokevirtual 490	android/text/SpannableStringBuilder:setSpan	(Ljava/lang/Object;III)V
    //   128: aload_0
    //   129: getfield 494	com/tencent/mobileqq/structmsg/StructMsgForHypertext:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   132: ifnull -97 -> 35
    //   135: aload 7
    //   137: getfield 497	bchx:f	Ljava/lang/String;
    //   140: invokestatic 118	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   143: ifne -108 -> 35
    //   146: aload_0
    //   147: getfield 494	com/tencent/mobileqq/structmsg/StructMsgForHypertext:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   150: new 125	java/lang/StringBuilder
    //   153: dup
    //   154: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   157: aload_0
    //   158: getfield 28	com/tencent/mobileqq/structmsg/StructMsgForHypertext:KEY_QD_HYPERTEXT_CLICK_STATE	Ljava/lang/String;
    //   161: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: aload 7
    //   166: getfield 497	bchx:f	Ljava/lang/String;
    //   169: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: invokevirtual 194	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   175: invokevirtual 502	com/tencent/mobileqq/data/MessageRecord:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   178: astore 10
    //   180: aload 7
    //   182: getfield 505	bchx:g	Ljava/lang/String;
    //   185: invokestatic 118	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   188: ifne +118 -> 306
    //   191: aload 7
    //   193: getfield 505	bchx:g	Ljava/lang/String;
    //   196: invokestatic 511	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   199: invokevirtual 514	java/lang/Integer:intValue	()I
    //   202: istore_2
    //   203: iload_2
    //   204: istore_3
    //   205: aload 10
    //   207: invokestatic 118	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   210: ifne +69 -> 279
    //   213: aload 10
    //   215: invokestatic 511	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   218: invokevirtual 514	java/lang/Integer:intValue	()I
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
    //   239: new 516	android/text/style/ForegroundColorSpan
    //   242: dup
    //   243: ldc_w 517
    //   246: invokespecial 518	android/text/style/ForegroundColorSpan:<init>	(I)V
    //   249: iload 5
    //   251: iload 6
    //   253: bipush 33
    //   255: invokevirtual 490	android/text/SpannableStringBuilder:setSpan	(Ljava/lang/Object;III)V
    //   258: goto -223 -> 35
    //   261: astore 7
    //   263: iconst_0
    //   264: istore_2
    //   265: ldc_w 520
    //   268: iconst_1
    //   269: aload 7
    //   271: invokevirtual 523	java/lang/NumberFormatException:getMessage	()Ljava/lang/String;
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
    //   291: invokevirtual 481	android/text/SpannableStringBuilder:append	(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;
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
    //   55	137	7	localbchx	bchx
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
  
  public View getView(Context paramContext, View paramView, afce paramafce, Bundle paramBundle)
  {
    paramView = (ViewGroup)super.getView(paramContext, paramView, paramafce, paramBundle);
    paramBundle = new StructMsgForHypertext.HyperTextView(paramContext);
    Resources localResources = paramContext.getResources();
    paramBundle.setPadding((int)localResources.getDimension(2131298978), (int)localResources.getDimension(2131298980), (int)localResources.getDimension(2131298979), (int)localResources.getDimension(2131298977));
    paramBundle.setText(getSpannableString(true));
    paramBundle.setTextSize(0, ChatTextSizeSettingActivity.a(paramContext));
    paramBundle.setTextColor(paramContext.getResources().getColor(2131165417));
    paramBundle.setLinkTextColor(paramContext.getResources().getColor(2131165875));
    paramBundle.setLinksClickable(false);
    paramBundle.setMovementMethod(LinkMovementMethod.getInstance());
    paramBundle.setOnTouchListener(paramafce);
    paramBundle.setOnLongClickListener(paramafce);
    paramBundle.setTag(2131368232, this);
    paramView.addView(paramBundle);
    paramContext = paramView.getLayoutParams();
    if (paramContext == null) {
      new LinearLayout.LayoutParams(BaseChatItemLayout.B, -2);
    }
    for (;;)
    {
      paramView.setLongClickable(true);
      paramView.setTag(2131377871, this);
      return paramView;
      paramContext.width = BaseChatItemLayout.B;
      paramContext.height = -2;
    }
  }
  
  protected void parseItem(bcin parambcin)
  {
    if (parambcin == null) {
      return;
    }
    this.mHpertextArray = new ArrayList();
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    if (i < parambcin.a())
    {
      Object localObject3 = parambcin.a(i);
      if (localObject3 == null) {}
      for (;;)
      {
        i += 1;
        break;
        Object localObject1;
        Object localObject2;
        if (((bcin)localObject3).a())
        {
          localObject1 = ((bcin)localObject3).a("url");
          localObject2 = ((bcin)localObject3).a("action");
          String str1 = ((bcin)localObject3).a("actionData");
          String str2 = ((bcin)localObject3).a("a_actionData");
          String str3 = ((bcin)localObject3).a("i_actionData");
          String str4 = ((bcin)localObject3).a("key");
          String str5 = ((bcin)localObject3).a("clickcnt");
          localObject3 = bchh.a((bcin)localObject3);
          localObject1 = new bchx((String)localObject1, (String)localObject2, str1, str2, str3, str4, str5, (String)localObject3);
          this.mHpertextArray.add(localObject1);
          localStringBuilder.append((String)localObject3);
        }
        else
        {
          localObject1 = bchh.a((bcin)localObject3);
          localObject2 = new bchx((String)localObject1);
          this.mHpertextArray.add(localObject2);
          localStringBuilder.append((String)localObject1);
        }
      }
    }
    this.mMsgBrief = localStringBuilder.toString();
  }
  
  protected void parseSourceNode(bcin parambcin)
  {
    this.mSourceName = parambcin.a("name");
    this.mSourceIcon = parambcin.a("icon");
    this.mSourceUrl = parambcin.a("url");
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
          bchx localbchx = new bchx(paramObjectInput.readUTF(), paramObjectInput.readUTF(), paramObjectInput.readUTF(), paramObjectInput.readUTF(), paramObjectInput.readUTF(), paramObjectInput.readUTF(), paramObjectInput.readUTF(), paramObjectInput.readUTF());
          this.mHpertextArray.add(localbchx);
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
        paramByteArrayOutputStream = (bchx)this.mHpertextArray.get(i);
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
    bchx localbchx;
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
      localbchx = (bchx)localIterator.next();
      if (localbchx.a == null) {
        break label399;
      }
      str = localbchx.a;
      label194:
      paramObjectOutput.writeUTF(str);
      if (localbchx.b == null) {
        break label405;
      }
      str = localbchx.b;
      label215:
      paramObjectOutput.writeUTF(str);
      if (localbchx.c == null) {
        break label411;
      }
      str = localbchx.c;
      label236:
      paramObjectOutput.writeUTF(str);
      if (localbchx.d == null) {
        break label417;
      }
      str = localbchx.d;
      label257:
      paramObjectOutput.writeUTF(str);
      if (localbchx.e == null) {
        break label423;
      }
      str = localbchx.e;
      label278:
      paramObjectOutput.writeUTF(str);
      if (localbchx.f == null) {
        break label429;
      }
      str = localbchx.f;
      label299:
      paramObjectOutput.writeUTF(str);
      if (localbchx.g == null) {
        break label435;
      }
      str = localbchx.g;
      label320:
      paramObjectOutput.writeUTF(str);
      if (localbchx.h == null) {
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
    for (String str = localbchx.h;; str = "")
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgForHypertext
 * JD-Core Version:    0.7.0.1
 */