package com.tencent.mobileqq.structmsg.view;

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
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
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
  String ac;
  String ad;
  String ae;
  String af;
  
  View a(View paramView, Context paramContext, String paramString)
  {
    StructMsgItemLayout20.Holder localHolder2;
    try
    {
      i = Integer.parseInt(this.ac);
      if (paramView == null)
      {
        StructMsgItemLayout20.Holder localHolder1 = new StructMsgItemLayout20.Holder(this);
        paramView = View.inflate(paramContext, 2131562058, null);
        localHolder1.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131372115));
        localHolder1.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368603));
        localHolder1.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367277));
        localHolder1.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131370723);
        paramView.setTag(localHolder1);
        localHolder1.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(paramString);
        if (i != 1) {
          break label331;
        }
        localHolder1.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        localHolder1.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(Color.parseColor("#777777"));
        localHolder1.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextSize(14.0F);
        localHolder1.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables(null, null);
        localHolder1.jdField_a_of_type_AndroidWidgetTextView.setText(this.ae);
        localHolder1.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
        localHolder1.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(paramContext.getResources().getDrawable(2130839460));
        paramView.setTag(2131375248, this.b);
        localHolder1.jdField_a_of_type_AndroidWidgetTextView.setTag(2131375248, this.b);
        i = AIOUtils.a(17.0F, paramContext.getResources());
        int j = AIOUtils.a(16.0F, paramContext.getResources());
        localHolder1.jdField_a_of_type_AndroidWidgetTextView.setPadding(j, 0, j, 0);
        localHolder1.jdField_a_of_type_AndroidWidgetTextView.post(new StructMsgItemLayout20.1(this, i, localHolder1));
        paramView.setOnClickListener(this);
        localHolder1.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
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
          QLog.e("StructMsgItemLayout20", 1, "content type:" + this.ac);
          i = 0;
          continue;
          localHolder2 = (StructMsgItemLayout20.Holder)paramView.getTag();
        }
      } while (i != 0);
      localHolder2.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramString = paramContext.getResources().getDrawable(2130840452);
      if (TextUtils.isEmpty(this.ad)) {
        break label640;
      }
    }
    int i = AIOUtils.a(40.0F, paramContext.getResources());
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = paramString;
    localURLDrawableOptions.mFailedDrawable = paramString;
    paramString = URLDrawable.getDrawable(this.ad, localURLDrawableOptions);
    if (paramString.getStatus() == 2) {
      paramString.restartDownload();
    }
    paramString.setTag(URLDrawableDecodeHandler.b(i, i, i / 2));
    paramString.setDecodeHandler(URLDrawableDecodeHandler.c);
    localHolder2.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramString);
    label446:
    if (this.jdField_a_of_type_Boolean)
    {
      paramString = paramContext.getResources().getDrawable(2130841947);
      localHolder2.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablePadding(AIOUtils.a(3.0F, paramContext.getResources()));
      paramString.setBounds(0, 0, AIOUtils.a(15.0F, paramContext.getResources()), AIOUtils.a(15.0F, paramContext.getResources()));
      localHolder2.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables(null, paramString);
      localHolder2.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(Color.parseColor("#000000"));
      localHolder2.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextSize(17.0F);
      localHolder2.jdField_a_of_type_AndroidWidgetTextView.setTag(localHolder2);
      if (!((PublicAccountDataManager)((BaseActivity)paramContext).app.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER)).a(Long.valueOf(Long.parseLong(this.af)))) {
        break label665;
      }
      localHolder2.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(null);
      localHolder2.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131714471));
      localHolder2.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
    }
    for (;;)
    {
      label514:
      paramView.setTag(2131375250, this.af);
      localHolder2.jdField_a_of_type_AndroidWidgetTextView.setTag(2131375250, this.af);
      break;
      label640:
      localHolder2.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramString);
      break label446;
      localHolder2.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables(null, null);
      break label514;
      label665:
      localHolder2.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(paramContext.getResources().getDrawable(2130839460));
      localHolder2.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131714477));
      localHolder2.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
    }
  }
  
  void a()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(this.h);
      this.ac = localJSONObject.optString("contentType");
      if (localJSONObject.optInt("isCert") == 1) {}
      for (boolean bool = true;; bool = false)
      {
        this.jdField_a_of_type_Boolean = bool;
        this.ad = localJSONObject.optString("faceUrl");
        this.ae = localJSONObject.optString("btnText");
        this.af = localJSONObject.optString("puin");
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
  
  public int b()
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
            localObject = ((StructMsgItemContent)localAbsStructMsgElement).ai;
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
        paramView.addView(a(null, paramContext, ((StructMsgItemContent)localObject).ai), new LinearLayout.LayoutParams(-1, -2));
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
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: getfield 21	com/tencent/mobileqq/structmsg/view/StructMsgItemLayout20:ac	Ljava/lang/String;
    //   6: invokestatic 27	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   9: istore_2
    //   10: aload_1
    //   11: invokevirtual 400	android/view/View:getContext	()Landroid/content/Context;
    //   14: astore 4
    //   16: aload 4
    //   18: instanceof 402
    //   21: ifne +11 -> 32
    //   24: invokestatic 408	com/tencent/qqlive/module/videoreport/collect/EventCollector:getInstance	()Lcom/tencent/qqlive/module/videoreport/collect/EventCollector;
    //   27: aload_1
    //   28: invokevirtual 411	com/tencent/qqlive/module/videoreport/collect/EventCollector:onViewClicked	(Landroid/view/View;)V
    //   31: return
    //   32: aload 4
    //   34: checkcast 402	android/support/v4/app/FragmentActivity
    //   37: astore 5
    //   39: aload 4
    //   41: checkcast 402	android/support/v4/app/FragmentActivity
    //   44: invokevirtual 415	android/support/v4/app/FragmentActivity:getChatFragment	()Lcom/tencent/mobileqq/activity/ChatFragment;
    //   47: astore 6
    //   49: aload 6
    //   51: ifnull +69 -> 120
    //   54: aload 6
    //   56: invokevirtual 420	com/tencent/mobileqq/activity/ChatFragment:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   59: astore_3
    //   60: aload_3
    //   61: ifnull -37 -> 24
    //   64: aload_3
    //   65: getstatic 425	com/tencent/mobileqq/app/BusinessHandlerFactory:EC_SHOP_REPORT_HANDLER	Ljava/lang/String;
    //   68: invokevirtual 429	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   71: checkcast 431	com/tencent/biz/pubaccount/ecshopassit/EcshopReportHandler
    //   74: astore 6
    //   76: iload_2
    //   77: iconst_1
    //   78: if_icmpne +217 -> 295
    //   81: aload_0
    //   82: getfield 434	com/tencent/mobileqq/structmsg/view/StructMsgItemLayout20:Y	Ljava/lang/String;
    //   85: invokestatic 439	com/tencent/biz/pubaccount/ecshopassit/EcShopAssistantManager:b	(Ljava/lang/String;)Z
    //   88: ifeq +57 -> 145
    //   91: aload_3
    //   92: getstatic 442	com/tencent/mobileqq/app/QQManagerFactory:EC_SHOP_ASSISTANT_MANAGER	I
    //   95: invokevirtual 264	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   98: checkcast 436	com/tencent/biz/pubaccount/ecshopassit/EcShopAssistantManager
    //   101: astore_3
    //   102: aload_3
    //   103: ifnull -79 -> 24
    //   106: aload_3
    //   107: aload_0
    //   108: aload 4
    //   110: checkcast 444	android/app/Activity
    //   113: invokevirtual 447	com/tencent/biz/pubaccount/ecshopassit/EcShopAssistantManager:a	(Lcom/tencent/mobileqq/structmsg/AbsStructMsgElement;Landroid/app/Activity;)Z
    //   116: pop
    //   117: goto -93 -> 24
    //   120: invokestatic 453	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   123: invokevirtual 457	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   126: astore 6
    //   128: aload 6
    //   130: instanceof 260
    //   133: ifeq -73 -> 60
    //   136: aload 6
    //   138: checkcast 260	com/tencent/mobileqq/app/QQAppInterface
    //   141: astore_3
    //   142: goto -82 -> 60
    //   145: aload_1
    //   146: ldc 121
    //   148: invokevirtual 460	android/view/View:getTag	(I)Ljava/lang/Object;
    //   151: checkcast 366	java/lang/String
    //   154: astore 5
    //   156: aload 5
    //   158: invokestatic 187	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   161: ifne -137 -> 24
    //   164: new 462	android/content/Intent
    //   167: dup
    //   168: aload 4
    //   170: ldc_w 464
    //   173: invokespecial 467	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   176: astore 6
    //   178: aload 6
    //   180: ldc_w 469
    //   183: aload 5
    //   185: invokevirtual 473	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   188: pop
    //   189: aload 6
    //   191: ldc_w 475
    //   194: invokestatic 481	java/lang/System:currentTimeMillis	()J
    //   197: invokevirtual 484	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   200: pop
    //   201: aload 6
    //   203: ldc_w 486
    //   206: ldc_w 488
    //   209: invokestatic 494	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   212: checkcast 488	com/tencent/biz/pubaccount/util/api/IPublicAccountUtil
    //   215: aload_0
    //   216: getfield 497	com/tencent/mobileqq/structmsg/view/StructMsgItemLayout20:ab	Ljava/lang/String;
    //   219: invokeinterface 500 2 0
    //   224: invokevirtual 473	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   227: pop
    //   228: aload 4
    //   230: aload 6
    //   232: invokevirtual 504	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   235: aload_0
    //   236: getfield 507	com/tencent/mobileqq/structmsg/view/StructMsgItemLayout20:jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   239: ifnull -215 -> 24
    //   242: new 509	com/tencent/biz/pubaccount/ecshopassit/EcshopAdHandler$ReportInfo
    //   245: dup
    //   246: invokespecial 510	com/tencent/biz/pubaccount/ecshopassit/EcshopAdHandler$ReportInfo:<init>	()V
    //   249: astore 4
    //   251: aload 4
    //   253: bipush 6
    //   255: putfield 512	com/tencent/biz/pubaccount/ecshopassit/EcshopAdHandler$ReportInfo:a	I
    //   258: aload 4
    //   260: aload_0
    //   261: getfield 507	com/tencent/mobileqq/structmsg/view/StructMsgItemLayout20:jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   264: getfield 518	com/tencent/mobileqq/structmsg/AbsStructMsg:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   267: invokestatic 523	com/tencent/biz/pubaccount/ecshopassit/EcshopAdHandler:a	(Lcom/tencent/biz/pubaccount/ecshopassit/EcshopAdHandler$ReportInfo;Lcom/tencent/mobileqq/data/MessageRecord;)Lcom/tencent/biz/pubaccount/ecshopassit/EcshopAdHandler$ReportInfo;
    //   270: astore 4
    //   272: aload_3
    //   273: getstatic 526	com/tencent/mobileqq/app/BusinessHandlerFactory:ESHOP_AD_HANDLER	Ljava/lang/String;
    //   276: invokevirtual 429	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   279: checkcast 520	com/tencent/biz/pubaccount/ecshopassit/EcshopAdHandler
    //   282: aload 4
    //   284: aconst_null
    //   285: invokevirtual 529	com/tencent/biz/pubaccount/ecshopassit/EcshopAdHandler:a	(Lcom/tencent/biz/pubaccount/ecshopassit/EcshopAdHandler$ReportInfo;Ljava/lang/String;)V
    //   288: goto -264 -> 24
    //   291: astore_3
    //   292: goto -268 -> 24
    //   295: iload_2
    //   296: ifne -272 -> 24
    //   299: aload_1
    //   300: ldc_w 288
    //   303: invokevirtual 460	android/view/View:getTag	(I)Ljava/lang/Object;
    //   306: checkcast 366	java/lang/String
    //   309: astore 4
    //   311: aload_1
    //   312: invokevirtual 532	android/view/View:getId	()I
    //   315: ldc_w 533
    //   318: if_icmpne +89 -> 407
    //   321: new 462	android/content/Intent
    //   324: dup
    //   325: invokespecial 534	android/content/Intent:<init>	()V
    //   328: astore 7
    //   330: aload 7
    //   332: ldc_w 536
    //   335: bipush 115
    //   337: invokevirtual 539	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   340: pop
    //   341: ldc_w 488
    //   344: invokestatic 494	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   347: checkcast 488	com/tencent/biz/pubaccount/util/api/IPublicAccountUtil
    //   350: aload 7
    //   352: aload_3
    //   353: aload 5
    //   355: aload 4
    //   357: bipush 251
    //   359: invokeinterface 543 6 0
    //   364: aload 6
    //   366: ldc_w 544
    //   369: aload_0
    //   370: getfield 507	com/tencent/mobileqq/structmsg/view/StructMsgItemLayout20:jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   373: getfield 547	com/tencent/mobileqq/structmsg/AbsStructMsg:uin	Ljava/lang/String;
    //   376: aload_0
    //   377: getfield 507	com/tencent/mobileqq/structmsg/view/StructMsgItemLayout20:jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   380: getfield 518	com/tencent/mobileqq/structmsg/AbsStructMsg:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   383: ldc_w 549
    //   386: invokevirtual 554	com/tencent/mobileqq/data/MessageRecord:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   389: aconst_null
    //   390: aconst_null
    //   391: aload 4
    //   393: invokestatic 274	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   396: iconst_0
    //   397: invokevirtual 557	com/tencent/biz/pubaccount/ecshopassit/EcshopReportHandler:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JZ)V
    //   400: goto -376 -> 24
    //   403: astore_3
    //   404: goto -380 -> 24
    //   407: aload_1
    //   408: invokevirtual 532	android/view/View:getId	()I
    //   411: ldc 56
    //   413: if_icmpne -389 -> 24
    //   416: aload_1
    //   417: invokevirtual 178	android/view/View:getTag	()Ljava/lang/Object;
    //   420: checkcast 29	com/tencent/mobileqq/structmsg/view/StructMsgItemLayout20$Holder
    //   423: astore 6
    //   425: aload 6
    //   427: getfield 61	com/tencent/mobileqq/structmsg/view/StructMsgItemLayout20$Holder:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   430: iconst_4
    //   431: invokevirtual 558	android/widget/TextView:setVisibility	(I)V
    //   434: aload 6
    //   436: getfield 65	com/tencent/mobileqq/structmsg/view/StructMsgItemLayout20$Holder:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   439: iconst_0
    //   440: invokevirtual 559	android/view/View:setVisibility	(I)V
    //   443: ldc_w 488
    //   446: invokestatic 494	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   449: checkcast 488	com/tencent/biz/pubaccount/util/api/IPublicAccountUtil
    //   452: aload_3
    //   453: aload 5
    //   455: aload 4
    //   457: new 561	com/tencent/mobileqq/structmsg/view/StructMsgItemLayout20$PubObserver
    //   460: dup
    //   461: aload_0
    //   462: aload 6
    //   464: invokespecial 564	com/tencent/mobileqq/structmsg/view/StructMsgItemLayout20$PubObserver:<init>	(Lcom/tencent/mobileqq/structmsg/view/StructMsgItemLayout20;Lcom/tencent/mobileqq/structmsg/view/StructMsgItemLayout20$Holder;)V
    //   467: iconst_1
    //   468: iconst_3
    //   469: invokeinterface 568 7 0
    //   474: new 509	com/tencent/biz/pubaccount/ecshopassit/EcshopAdHandler$ReportInfo
    //   477: dup
    //   478: invokespecial 510	com/tencent/biz/pubaccount/ecshopassit/EcshopAdHandler$ReportInfo:<init>	()V
    //   481: astore 5
    //   483: aload 5
    //   485: iconst_5
    //   486: putfield 512	com/tencent/biz/pubaccount/ecshopassit/EcshopAdHandler$ReportInfo:a	I
    //   489: aload 5
    //   491: aload 4
    //   493: invokestatic 274	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   496: putfield 571	com/tencent/biz/pubaccount/ecshopassit/EcshopAdHandler$ReportInfo:b	J
    //   499: aload 5
    //   501: aload_0
    //   502: getfield 507	com/tencent/mobileqq/structmsg/view/StructMsgItemLayout20:jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   505: getfield 518	com/tencent/mobileqq/structmsg/AbsStructMsg:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   508: invokestatic 523	com/tencent/biz/pubaccount/ecshopassit/EcshopAdHandler:a	(Lcom/tencent/biz/pubaccount/ecshopassit/EcshopAdHandler$ReportInfo;Lcom/tencent/mobileqq/data/MessageRecord;)Lcom/tencent/biz/pubaccount/ecshopassit/EcshopAdHandler$ReportInfo;
    //   511: astore 4
    //   513: aload_3
    //   514: getstatic 526	com/tencent/mobileqq/app/BusinessHandlerFactory:ESHOP_AD_HANDLER	Ljava/lang/String;
    //   517: invokevirtual 429	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   520: checkcast 520	com/tencent/biz/pubaccount/ecshopassit/EcshopAdHandler
    //   523: aload 4
    //   525: aconst_null
    //   526: invokevirtual 529	com/tencent/biz/pubaccount/ecshopassit/EcshopAdHandler:a	(Lcom/tencent/biz/pubaccount/ecshopassit/EcshopAdHandler$ReportInfo;Ljava/lang/String;)V
    //   529: goto -505 -> 24
    //   532: astore_3
    //   533: goto -509 -> 24
    //   536: astore 4
    //   538: goto -39 -> 499
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	541	0	this	StructMsgItemLayout20
    //   0	541	1	paramView	View
    //   9	287	2	i	int
    //   1	272	3	localObject1	Object
    //   291	62	3	localException1	Exception
    //   403	111	3	localException2	Exception
    //   532	1	3	localException3	Exception
    //   14	510	4	localObject2	Object
    //   536	1	4	localException4	Exception
    //   37	463	5	localObject3	Object
    //   47	416	6	localObject4	Object
    //   328	23	7	localIntent	android.content.Intent
    // Exception table:
    //   from	to	target	type
    //   235	288	291	java/lang/Exception
    //   364	400	403	java/lang/Exception
    //   474	489	532	java/lang/Exception
    //   499	529	532	java/lang/Exception
    //   489	499	536	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemLayout20
 * JD-Core Version:    0.7.0.1
 */