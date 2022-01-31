package com.tencent.mobileqq.structmsg.view;

import ainv;
import ainw;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgNode;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SingleLineTextView;
import java.io.ObjectInput;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

public class StructMsgItemLayout20
  extends AbsStructMsgItem
{
  boolean a;
  String u;
  String v;
  String w;
  String x;
  
  View a(View paramView, Context paramContext, String paramString)
  {
    ainw localainw2;
    try
    {
      i = Integer.parseInt(this.u);
      if (paramView == null)
      {
        ainw localainw1 = new ainw(this);
        paramView = View.inflate(paramContext, 2130970962, null);
        localainw1.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131362759));
        localainw1.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131362724));
        localainw1.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131365303));
        localainw1.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131362732);
        paramView.setTag(localainw1);
        localainw1.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(paramString);
        if (i != 1) {
          break label331;
        }
        localainw1.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        localainw1.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(Color.parseColor("#777777"));
        localainw1.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextSize(14.0F);
        localainw1.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables(null, null);
        localainw1.jdField_a_of_type_AndroidWidgetTextView.setText(this.w);
        localainw1.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
        localainw1.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(paramContext.getResources().getDrawable(2130838534));
        paramView.setTag(2131362185, this.b);
        localainw1.jdField_a_of_type_AndroidWidgetTextView.setTag(2131362185, this.b);
        i = AIOUtils.a(17.0F, paramContext.getResources());
        int j = AIOUtils.a(16.0F, paramContext.getResources());
        localainw1.jdField_a_of_type_AndroidWidgetTextView.setPadding(j, 0, j, 0);
        localainw1.jdField_a_of_type_AndroidWidgetTextView.post(new ainv(this, i, localainw1));
        paramView.setOnClickListener(this);
        localainw1.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
        return paramView;
      }
    }
    catch (Exception localException)
    {
      label331:
      do
      {
        for (;;)
        {
          QLog.e("StructMsgItemLayout20", 1, "content type:" + this.u);
          i = 0;
          continue;
          localainw2 = (ainw)paramView.getTag();
        }
      } while (i != 0);
      localainw2.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramString = paramContext.getResources().getDrawable(2130839147);
      if (TextUtils.isEmpty(this.v)) {
        break label636;
      }
    }
    int i = AIOUtils.a(40.0F, paramContext.getResources());
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = paramString;
    localURLDrawableOptions.mFailedDrawable = paramString;
    paramString = URLDrawable.getDrawable(this.v, localURLDrawableOptions);
    if (paramString.getStatus() == 2) {
      paramString.restartDownload();
    }
    paramString.setTag(URLDrawableDecodeHandler.a(i, i, i / 2));
    paramString.setDecodeHandler(URLDrawableDecodeHandler.b);
    localainw2.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramString);
    label446:
    if (this.jdField_a_of_type_Boolean)
    {
      paramString = paramContext.getResources().getDrawable(2130839766);
      localainw2.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablePadding(AIOUtils.a(3.0F, paramContext.getResources()));
      paramString.setBounds(0, 0, AIOUtils.a(15.0F, paramContext.getResources()), AIOUtils.a(15.0F, paramContext.getResources()));
      localainw2.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables(null, paramString);
      localainw2.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(Color.parseColor("#000000"));
      localainw2.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextSize(17.0F);
      localainw2.jdField_a_of_type_AndroidWidgetTextView.setTag(localainw2);
      if (!((PublicAccountDataManager)((BaseActivity)paramContext).app.getManager(55)).a(Long.valueOf(Long.parseLong(this.x)))) {
        break label661;
      }
      localainw2.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(null);
      localainw2.jdField_a_of_type_AndroidWidgetTextView.setText("已关注");
      localainw2.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
    }
    for (;;)
    {
      label514:
      paramView.setTag(2131362184, this.x);
      localainw2.jdField_a_of_type_AndroidWidgetTextView.setTag(2131362184, this.x);
      break;
      label636:
      localainw2.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramString);
      break label446;
      localainw2.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables(null, null);
      break label514;
      label661:
      localainw2.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(paramContext.getResources().getDrawable(2130838534));
      localainw2.jdField_a_of_type_AndroidWidgetTextView.setText("关注");
      localainw2.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
    }
  }
  
  void a()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(this.h);
      this.u = localJSONObject.optString("contentType");
      if (localJSONObject.optInt("isCert") == 1) {}
      for (boolean bool = true;; bool = false)
      {
        this.jdField_a_of_type_Boolean = bool;
        this.v = localJSONObject.optString("faceUrl");
        this.w = localJSONObject.optString("btnText");
        this.x = localJSONObject.optString("puin");
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("StructMsgItemLayout20", 1, "Exception:" + localException);
    }
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    a();
  }
  
  public boolean a(StructMsgNode paramStructMsgNode)
  {
    super.a(paramStructMsgNode);
    a();
    return true;
  }
  
  protected int b()
  {
    return 20;
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    Object localObject;
    if ((paramView != null) && ((paramView instanceof LinearLayout)) && (((LinearLayout)paramView).getChildCount() == this.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      paramBundle = (LinearLayout)paramView;
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      int i = 0;
      for (;;)
      {
        if (((Iterator)localObject).hasNext())
        {
          AbsStructMsgElement localAbsStructMsgElement = (AbsStructMsgElement)((Iterator)localObject).next();
          localAbsStructMsgElement.jdField_a_of_type_JavaLangRefWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
          if ("content".equals(localAbsStructMsgElement.jdField_a_of_type_JavaLangString))
          {
            localObject = ((StructMsgItemContent)localAbsStructMsgElement).A;
            a(((LinearLayout)paramView).getChildAt(i), paramContext, (String)localObject);
          }
        }
        else
        {
          return paramBundle;
        }
        i += 1;
      }
    }
    paramView = new LinearLayout(paramContext);
    paramBundle = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (paramBundle.hasNext())
    {
      localObject = (AbsStructMsgElement)paramBundle.next();
      ((AbsStructMsgElement)localObject).jdField_a_of_type_JavaLangRefWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
      if (("content".equals(((AbsStructMsgElement)localObject).jdField_a_of_type_JavaLangString)) && ((localObject instanceof StructMsgItemContent))) {
        paramView.addView(a(null, paramContext, ((StructMsgItemContent)localObject).A), new LinearLayout.LayoutParams(-1, -2));
      }
    }
    return paramView;
  }
  
  public String b()
  {
    return "Layout20";
  }
  
  /* Error */
  public void onClick(View paramView)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 21	com/tencent/mobileqq/structmsg/view/StructMsgItemLayout20:u	Ljava/lang/String;
    //   4: invokestatic 27	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   7: istore_2
    //   8: aload_1
    //   9: invokevirtual 390	android/view/View:getContext	()Landroid/content/Context;
    //   12: astore 5
    //   14: aload 5
    //   16: instanceof 392
    //   19: ifne +4 -> 23
    //   22: return
    //   23: aload 5
    //   25: checkcast 392	android/support/v4/app/FragmentActivity
    //   28: astore 4
    //   30: aload 5
    //   32: checkcast 392	android/support/v4/app/FragmentActivity
    //   35: invokevirtual 396	android/support/v4/app/FragmentActivity:getChatFragment	()Lcom/tencent/mobileqq/activity/ChatFragment;
    //   38: astore_3
    //   39: aload_3
    //   40: ifnull +131 -> 171
    //   43: aload_3
    //   44: invokevirtual 401	com/tencent/mobileqq/activity/ChatFragment:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   47: astore_3
    //   48: aload_3
    //   49: ifnull -27 -> 22
    //   52: aload_3
    //   53: bipush 88
    //   55: invokevirtual 404	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   58: checkcast 406	com/tencent/biz/pubaccount/ecshopassit/EcshopReportHandler
    //   61: astore 6
    //   63: iload_2
    //   64: iconst_1
    //   65: if_icmpne +128 -> 193
    //   68: aload_1
    //   69: ldc 121
    //   71: invokevirtual 409	android/view/View:getTag	(I)Ljava/lang/Object;
    //   74: checkcast 356	java/lang/String
    //   77: astore_1
    //   78: aload_1
    //   79: invokestatic 187	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   82: ifne -60 -> 22
    //   85: new 411	android/content/Intent
    //   88: dup
    //   89: aload 5
    //   91: ldc_w 413
    //   94: invokespecial 416	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   97: astore 4
    //   99: aload 4
    //   101: ldc_w 418
    //   104: aload_1
    //   105: invokevirtual 422	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   108: pop
    //   109: aload 4
    //   111: ldc_w 424
    //   114: invokestatic 430	java/lang/System:currentTimeMillis	()J
    //   117: invokevirtual 433	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   120: pop
    //   121: aload 5
    //   123: aload 4
    //   125: invokevirtual 437	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   128: new 439	com/tencent/gdtad/net/GdtAdHandler$ReportInfo
    //   131: dup
    //   132: invokespecial 440	com/tencent/gdtad/net/GdtAdHandler$ReportInfo:<init>	()V
    //   135: astore_1
    //   136: aload_1
    //   137: bipush 6
    //   139: putfield 443	com/tencent/gdtad/net/GdtAdHandler$ReportInfo:a	I
    //   142: aload_1
    //   143: aload_0
    //   144: getfield 446	com/tencent/mobileqq/structmsg/view/StructMsgItemLayout20:jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   147: getfield 452	com/tencent/mobileqq/structmsg/AbsStructMsg:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   150: invokestatic 457	com/tencent/gdtad/net/GdtAdHandler:a	(Lcom/tencent/gdtad/net/GdtAdHandler$ReportInfo;Lcom/tencent/mobileqq/data/MessageRecord;)Lcom/tencent/gdtad/net/GdtAdHandler$ReportInfo;
    //   153: astore_1
    //   154: aload_3
    //   155: bipush 110
    //   157: invokevirtual 404	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   160: checkcast 454	com/tencent/gdtad/net/GdtAdHandler
    //   163: aload_1
    //   164: aconst_null
    //   165: invokevirtual 460	com/tencent/gdtad/net/GdtAdHandler:a	(Lcom/tencent/gdtad/net/GdtAdHandler$ReportInfo;Ljava/lang/String;)V
    //   168: return
    //   169: astore_1
    //   170: return
    //   171: invokestatic 466	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   174: invokevirtual 470	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   177: astore_3
    //   178: aload_3
    //   179: instanceof 253
    //   182: ifeq +213 -> 395
    //   185: aload_3
    //   186: checkcast 253	com/tencent/mobileqq/app/QQAppInterface
    //   189: astore_3
    //   190: goto -142 -> 48
    //   193: iload_2
    //   194: ifne -172 -> 22
    //   197: aload_1
    //   198: ldc_w 277
    //   201: invokevirtual 409	android/view/View:getTag	(I)Ljava/lang/Object;
    //   204: checkcast 356	java/lang/String
    //   207: astore 5
    //   209: aload_1
    //   210: invokevirtual 473	android/view/View:getId	()I
    //   213: ldc_w 474
    //   216: if_icmpne +71 -> 287
    //   219: new 411	android/content/Intent
    //   222: dup
    //   223: invokespecial 475	android/content/Intent:<init>	()V
    //   226: astore_1
    //   227: aload_1
    //   228: ldc_w 477
    //   231: bipush 115
    //   233: invokevirtual 480	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   236: pop
    //   237: aload_1
    //   238: aload_3
    //   239: aload 4
    //   241: aload 5
    //   243: bipush 251
    //   245: invokestatic 485	com/tencent/biz/pubaccount/util/PublicAccountUtil:a	(Landroid/content/Intent;Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;Ljava/lang/String;I)V
    //   248: aload 6
    //   250: ldc_w 486
    //   253: aload_0
    //   254: getfield 446	com/tencent/mobileqq/structmsg/view/StructMsgItemLayout20:jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   257: getfield 489	com/tencent/mobileqq/structmsg/AbsStructMsg:uin	Ljava/lang/String;
    //   260: aload_0
    //   261: getfield 446	com/tencent/mobileqq/structmsg/view/StructMsgItemLayout20:jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   264: getfield 452	com/tencent/mobileqq/structmsg/AbsStructMsg:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   267: ldc_w 491
    //   270: invokevirtual 496	com/tencent/mobileqq/data/MessageRecord:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   273: aconst_null
    //   274: aconst_null
    //   275: aload 5
    //   277: invokestatic 267	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   280: iconst_0
    //   281: invokevirtual 499	com/tencent/biz/pubaccount/ecshopassit/EcshopReportHandler:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JZ)V
    //   284: return
    //   285: astore_1
    //   286: return
    //   287: aload_1
    //   288: invokevirtual 473	android/view/View:getId	()I
    //   291: ldc 56
    //   293: if_icmpne -271 -> 22
    //   296: aload_1
    //   297: invokevirtual 178	android/view/View:getTag	()Ljava/lang/Object;
    //   300: checkcast 29	ainw
    //   303: astore_1
    //   304: aload_1
    //   305: getfield 61	ainw:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   308: iconst_4
    //   309: invokevirtual 500	android/widget/TextView:setVisibility	(I)V
    //   312: aload_1
    //   313: getfield 65	ainw:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   316: iconst_0
    //   317: invokevirtual 501	android/view/View:setVisibility	(I)V
    //   320: aload_3
    //   321: aload 4
    //   323: aload 5
    //   325: new 503	ainx
    //   328: dup
    //   329: aload_0
    //   330: aload_1
    //   331: invokespecial 506	ainx:<init>	(Lcom/tencent/mobileqq/structmsg/view/StructMsgItemLayout20;Lainw;)V
    //   334: iconst_1
    //   335: iconst_3
    //   336: invokestatic 509	com/tencent/biz/pubaccount/util/PublicAccountUtil:a	(Lcom/tencent/common/app/AppInterface;Landroid/content/Context;Ljava/lang/String;Lcom/tencent/mobileqq/app/PublicAccountObserver;ZI)V
    //   339: new 439	com/tencent/gdtad/net/GdtAdHandler$ReportInfo
    //   342: dup
    //   343: invokespecial 440	com/tencent/gdtad/net/GdtAdHandler$ReportInfo:<init>	()V
    //   346: astore_1
    //   347: aload_1
    //   348: iconst_5
    //   349: putfield 443	com/tencent/gdtad/net/GdtAdHandler$ReportInfo:a	I
    //   352: aload_1
    //   353: aload 5
    //   355: invokestatic 267	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   358: putfield 512	com/tencent/gdtad/net/GdtAdHandler$ReportInfo:b	J
    //   361: aload_1
    //   362: aload_0
    //   363: getfield 446	com/tencent/mobileqq/structmsg/view/StructMsgItemLayout20:jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   366: getfield 452	com/tencent/mobileqq/structmsg/AbsStructMsg:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   369: invokestatic 457	com/tencent/gdtad/net/GdtAdHandler:a	(Lcom/tencent/gdtad/net/GdtAdHandler$ReportInfo;Lcom/tencent/mobileqq/data/MessageRecord;)Lcom/tencent/gdtad/net/GdtAdHandler$ReportInfo;
    //   372: astore_1
    //   373: aload_3
    //   374: bipush 110
    //   376: invokevirtual 404	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   379: checkcast 454	com/tencent/gdtad/net/GdtAdHandler
    //   382: aload_1
    //   383: aconst_null
    //   384: invokevirtual 460	com/tencent/gdtad/net/GdtAdHandler:a	(Lcom/tencent/gdtad/net/GdtAdHandler$ReportInfo;Ljava/lang/String;)V
    //   387: return
    //   388: astore_1
    //   389: return
    //   390: astore 4
    //   392: goto -31 -> 361
    //   395: aconst_null
    //   396: astore_3
    //   397: goto -349 -> 48
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	400	0	this	StructMsgItemLayout20
    //   0	400	1	paramView	View
    //   7	187	2	i	int
    //   38	359	3	localObject1	Object
    //   28	294	4	localObject2	Object
    //   390	1	4	localException	Exception
    //   12	342	5	localObject3	Object
    //   61	188	6	localEcshopReportHandler	com.tencent.biz.pubaccount.ecshopassit.EcshopReportHandler
    // Exception table:
    //   from	to	target	type
    //   128	168	169	java/lang/Exception
    //   248	284	285	java/lang/Exception
    //   339	352	388	java/lang/Exception
    //   361	387	388	java/lang/Exception
    //   352	361	390	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemLayout20
 * JD-Core Version:    0.7.0.1
 */