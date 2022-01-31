import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.ProteusItemView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ValueBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ViewBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.valueitem.SizeValue;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.factory.BaseTemplateFactory;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout.Params;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.layout.helper.nativelayout.NativeLayoutImpl;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.NativeText.Builder;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class olo
{
  private static double jdField_a_of_type_Double;
  private static int jdField_a_of_type_Int;
  private static final Map<Integer, php> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  static
  {
    if (jdField_a_of_type_JavaUtilMap.isEmpty())
    {
      a(3, new phy());
      a(72, new pet());
      a(73, new pey());
      a(74, new pht());
      a(90, new phs());
      a(91, new phs());
      a(75, new pht());
      a(21, new pia());
      a(22, new pia());
      a(36, new pia());
      a(23, new pia());
      a(120, new pia());
      a(80, new pia());
      a(34, new pgp());
      a(16, new pgp());
      a(17, new pgp());
      a(19, new pgp());
      a(18, new pgp());
      a(20, new pgp());
      a(65, new pgp());
      a(64, new pgp());
      a(48, new pgp());
      a(25, new pfj());
      a(24, new pfj());
      a(26, new pfj());
      a(107, new pia());
      a(108, new pfj());
      a(37, new pfj());
      a(81, new pfj());
      a(35, new pfb());
      a(12, new pfb());
      a(10, new pfb());
      a(11, new pfb());
      a(28, new pfb());
      a(27, new pfb());
      a(49, new pfb());
      a(62, new pfb());
      a(63, new pfb());
      a(33, new pfb());
      a(31, new pgp());
      a(32, new pgp());
      a(79, new pgm());
      a(76, new pgm());
      a(77, new pgm());
      a(78, new pgm());
      a(83, new pgp());
      a(84, new pgp());
      a(85, new pgp());
      a(86, new pgp());
      a(89, new pel());
      a(92, new pfj());
      a(94, new pfb());
      a(95, new pfb());
      a(101, new pfu());
      a(102, new pfu());
      a(103, new pfu());
      a(105, new pes());
      a(66, new pen());
      a(115, new pen());
      a(39, new pem());
      a(116, new pep());
      a(117, new per());
      a(106, new peq());
      a(109, new pgw());
      a(110, new pgw());
      a(111, new pgw());
      a(132, new pgw());
      a(133, new pgw());
      a(134, new pgw());
      a(112, new pfb());
      a(113, new pfb());
      a(114, new pfb());
      a(126, new pex());
      a(2, new pew());
      a(1, new phw());
      a(121, new pfn());
      a(122, new pem());
      a(124, new pfy());
      a(125, new pfy());
      a(127, new peo());
      a(129, new pfx());
      a(130, new pfw());
      a(131, new pgd());
      a(46, new pfp());
      a(123, new pgh());
    }
  }
  
  private static double a(TemplateBean paramTemplateBean)
  {
    bfwu.a("getProteusSeparatorMarginLeftPx");
    if ((jdField_a_of_type_Double > 0.0D) && (paramTemplateBean != null))
    {
      rpr localrpr = rpr.a("default_feeds", false);
      if ((localrpr != null) && (!localrpr.a(paramTemplateBean)))
      {
        bfwu.a();
        return jdField_a_of_type_Double;
      }
    }
    if ((paramTemplateBean != null) && (paramTemplateBean.getViewBean() != null)) {}
    try
    {
      paramTemplateBean = paramTemplateBean.getViewBean().findViewById("id_separator");
      if (paramTemplateBean != null) {
        jdField_a_of_type_Double = Float.valueOf((String)paramTemplateBean.valueBean.normalValue.get("margin_left")).floatValue();
      }
    }
    catch (Exception paramTemplateBean)
    {
      for (;;)
      {
        paramTemplateBean.printStackTrace();
        QLog.d("ProteusSupportUtil", 1, "getProteusSeparatorMarginLeft exception.");
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("TemplateFactory", 2, new Object[] { "sProteusSeparatorMarginLeft = ", Double.valueOf(jdField_a_of_type_Double) });
    }
    bfwu.a();
    return jdField_a_of_type_Double;
  }
  
  private static int a(TemplateBean paramTemplateBean)
  {
    bfwu.a("getProteusSeparatorHeightPx");
    if ((jdField_a_of_type_Int > 0) && (paramTemplateBean != null))
    {
      localrpr = rpr.a("default_feeds", false);
      if ((localrpr != null) && (!localrpr.a(paramTemplateBean)))
      {
        bfwu.a();
        pjo.a("ProteusSupportUtil", "[getProteusSeparatorHeightPx] SeparatorHeight : " + jdField_a_of_type_Int);
        return jdField_a_of_type_Int;
      }
    }
    rpr localrpr = rpr.a("default_feeds", false);
    paramTemplateBean = null;
    if (localrpr != null) {
      paramTemplateBean = localrpr.getTemplate("ReadInjoy_triple_img_cell");
    }
    if ((paramTemplateBean != null) && (paramTemplateBean.getViewBean() != null)) {}
    for (;;)
    {
      try
      {
        paramTemplateBean = paramTemplateBean.getViewBean().findViewById("id_separator");
        if (paramTemplateBean == null) {
          continue;
        }
        paramTemplateBean = (SizeValue)paramTemplateBean.valueBean.normalValue.get("height");
        if (paramTemplateBean != null) {
          jdField_a_of_type_Int = paramTemplateBean.getLayoutSize();
        }
        pjo.a("ProteusSupportUtil", "[getProteusSeparatorHeightPx] getSeparatorHeightPx");
      }
      catch (Exception paramTemplateBean)
      {
        paramTemplateBean.printStackTrace();
        QLog.d("ProteusSupportUtil", 1, "getProteusSeparatorHeight exception.");
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("TemplateFactory", 2, new Object[] { "sProteusSeparatorHeight = ", Integer.valueOf(jdField_a_of_type_Int) });
      }
      bfwu.a();
      return jdField_a_of_type_Int;
      jdField_a_of_type_Int = Utils.dp2px(0.5D);
    }
  }
  
  public static ProteusItemView a(VafContext paramVafContext, int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    if (pjp.a()) {
      pjp.a("ProteusSupportUtil", "[getView] " + paramBaseArticleInfo + " adapterViewType: " + paramInt);
    }
    long l1 = System.currentTimeMillis();
    bfwu.a("ProteusSupportUtil.getView");
    Object localObject1 = null;
    bfwu.a("ProteusSupportUtil#getView#getTemplateBean");
    TemplateBean localTemplateBean = a(paramVafContext, paramInt, paramBaseArticleInfo);
    bfwu.a();
    Object localObject2 = "";
    label210:
    label226:
    long l2;
    if (localTemplateBean != null)
    {
      localObject2 = "[" + localTemplateBean.getStyleName() + "]";
      paramBaseArticleInfo = localObject1;
      localObject1 = localObject2;
      bfwu.a(localObject1 + "#inflate");
      localObject2 = paramVafContext.getViewFactory().inflate(paramVafContext, localTemplateBean);
      pjo.a("ProteusSupportUtil", "[getView] inflate");
      bfwu.a();
      if (localObject2 != null)
      {
        bfwu.a(localObject1 + "#setBackgroundDrawable");
        if ((!onh.p()) || (!bhvy.k())) {
          break label400;
        }
        paramInt = 1;
        paramBaseArticleInfo = paramVafContext.getContext().getResources();
        if (paramInt == 0) {
          break label405;
        }
        paramInt = 2130841261;
        ((Container)localObject2).setBackgroundDrawable(paramBaseArticleInfo.getDrawable(paramInt));
        paramBaseArticleInfo = new ProteusItemView(paramVafContext.getContext());
        paramBaseArticleInfo.a((Container)localObject2);
        bfwu.a();
        pjo.a("ProteusSupportUtil", "[getView]  add Container ");
      }
      if (QLog.isColorLevel()) {
        pjp.a((View)localObject2, "ProteusSupportUtil");
      }
      l2 = System.currentTimeMillis();
      if (localTemplateBean == null) {
        break label412;
      }
    }
    label400:
    label405:
    label412:
    for (paramVafContext = localTemplateBean.getStyleName();; paramVafContext = "templateBean is null")
    {
      saf.a("ProteusSupportUtil", paramVafContext, "ProteusSupportUtil.getView", l2 - l1);
      bfwu.a();
      return paramBaseArticleInfo;
      pjo.a("ProteusSupportUtil", "[getView]  new proteusItemView ");
      ProteusItemView localProteusItemView = new ProteusItemView(paramVafContext.getContext());
      localProteusItemView.setVisibility(8);
      QLog.i("ProteusSupportUtil", 1, "[getView] 未找到样式,请确认是否下发该卡片的样式:" + paramBaseArticleInfo + " adapterViewType: " + paramInt + "  " + paramVafContext.getTemplateFactory());
      localObject1 = localObject2;
      paramBaseArticleInfo = localProteusItemView;
      break;
      paramInt = 0;
      break label210;
      paramInt = 2130841262;
      break label226;
    }
  }
  
  /* Error */
  public static TemplateBean a(VafContext paramVafContext, int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +18 -> 19
    //   4: ldc 132
    //   6: iconst_0
    //   7: invokestatic 137	rpr:a	(Ljava/lang/String;Z)Lrpr;
    //   10: astore 4
    //   12: aload 4
    //   14: ifnonnull +510 -> 524
    //   17: aconst_null
    //   18: areturn
    //   19: aload_0
    //   20: invokevirtual 388	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/VafContext:getTemplateFactory	()Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/factory/BaseTemplateFactory;
    //   23: checkcast 134	rpr
    //   26: astore 4
    //   28: invokestatic 188	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   31: ifeq +39 -> 70
    //   34: ldc 206
    //   36: iconst_2
    //   37: new 218	java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   44: ldc_w 398
    //   47: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: aload_2
    //   51: invokevirtual 280	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   54: ldc_w 400
    //   57: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: iload_1
    //   61: invokevirtual 228	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   64: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: invokestatic 211	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   70: aload_2
    //   71: getfield 406	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mProteusTemplateBean	Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;
    //   74: ifnull +20 -> 94
    //   77: aload 4
    //   79: aload_2
    //   80: getfield 406	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mProteusTemplateBean	Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;
    //   83: invokevirtual 140	rpr:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;)Z
    //   86: ifne +8 -> 94
    //   89: aload_2
    //   90: getfield 406	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mProteusTemplateBean	Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;
    //   93: areturn
    //   94: getstatic 18	olo:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   97: iload_1
    //   98: invokestatic 260	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   101: invokeinterface 171 2 0
    //   106: checkcast 408	php
    //   109: astore_3
    //   110: aload_3
    //   111: ifnull +159 -> 270
    //   114: aload_3
    //   115: iload_1
    //   116: aload_2
    //   117: invokeinterface 411 3 0
    //   122: astore_0
    //   123: aload_3
    //   124: ifnull +395 -> 519
    //   127: aload_3
    //   128: iload_1
    //   129: aload_0
    //   130: invokeinterface 414 3 0
    //   135: astore_3
    //   136: aload_3
    //   137: ifnonnull +379 -> 516
    //   140: aload 4
    //   142: ifnull +314 -> 456
    //   145: aload 4
    //   147: aload_0
    //   148: invokevirtual 418	rpr:getTemplateBean	(Lorg/json/JSONObject;)Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;
    //   151: astore 4
    //   153: aload 4
    //   155: astore_3
    //   156: aload_2
    //   157: invokestatic 424	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:isAppAdvertisementInfo	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Z
    //   160: ifne +8 -> 168
    //   163: aload_2
    //   164: aload_3
    //   165: putfield 406	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mProteusTemplateBean	Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;
    //   168: new 218	java/lang/StringBuilder
    //   171: dup
    //   172: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   175: ldc_w 426
    //   178: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: astore 4
    //   183: aload_0
    //   184: ifnull +277 -> 461
    //   187: new 218	java/lang/StringBuilder
    //   190: dup
    //   191: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   194: aload_0
    //   195: ldc_w 428
    //   198: invokevirtual 434	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   201: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: ldc_w 436
    //   207: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: aload_0
    //   211: invokevirtual 437	org/json/JSONObject:toString	()Ljava/lang/String;
    //   214: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: ldc_w 439
    //   220: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   226: astore_2
    //   227: ldc 206
    //   229: iconst_2
    //   230: aload 4
    //   232: aload_2
    //   233: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   239: invokestatic 211	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   242: ldc 206
    //   244: iconst_1
    //   245: new 218	java/lang/StringBuilder
    //   248: dup
    //   249: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   252: ldc_w 441
    //   255: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: aload_0
    //   259: invokevirtual 280	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   262: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   265: invokestatic 211	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   268: aload_3
    //   269: areturn
    //   270: iload_1
    //   271: lookupswitch	default:+97->368, 1:+113->384, 5:+105->376, 29:+129->400, 34:+153->424, 40:+169->440, 41:+177->448, 42:+161->432, 47:+137->408, 60:+145->416, 96:+145->416, 104:+121->392
    //   369: invokestatic 446	peb:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   372: astore_0
    //   373: goto -250 -> 123
    //   376: aload_2
    //   377: invokestatic 449	pef:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   380: astore_0
    //   381: goto -258 -> 123
    //   384: aload_2
    //   385: invokestatic 452	pee:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   388: astore_0
    //   389: goto -266 -> 123
    //   392: aload_2
    //   393: invokestatic 455	pds:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   396: astore_0
    //   397: goto -274 -> 123
    //   400: aload_2
    //   401: invokestatic 458	ped:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   404: astore_0
    //   405: goto -282 -> 123
    //   408: aload_2
    //   409: invokestatic 461	pdn:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   412: astore_0
    //   413: goto -290 -> 123
    //   416: aload_2
    //   417: invokestatic 464	pdy:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   420: astore_0
    //   421: goto -298 -> 123
    //   424: aload_2
    //   425: invokestatic 467	pec:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   428: astore_0
    //   429: goto -306 -> 123
    //   432: aload_2
    //   433: invokestatic 470	peh:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   436: astore_0
    //   437: goto -314 -> 123
    //   440: aload_2
    //   441: invokestatic 473	peg:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   444: astore_0
    //   445: goto -322 -> 123
    //   448: aload_2
    //   449: invokestatic 476	pei:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   452: astore_0
    //   453: goto -330 -> 123
    //   456: aconst_null
    //   457: astore_3
    //   458: goto -302 -> 156
    //   461: ldc_w 298
    //   464: astore_2
    //   465: goto -238 -> 227
    //   468: astore_0
    //   469: aconst_null
    //   470: astore_3
    //   471: ldc 206
    //   473: iconst_1
    //   474: ldc_w 478
    //   477: aload_0
    //   478: invokestatic 482	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   481: goto -213 -> 268
    //   484: astore_0
    //   485: aconst_null
    //   486: astore_3
    //   487: ldc 206
    //   489: iconst_1
    //   490: ldc_w 484
    //   493: aload_0
    //   494: invokestatic 482	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   497: goto -229 -> 268
    //   500: astore_0
    //   501: goto -14 -> 487
    //   504: astore_0
    //   505: goto -18 -> 487
    //   508: astore_0
    //   509: goto -38 -> 471
    //   512: astore_0
    //   513: goto -42 -> 471
    //   516: goto -360 -> 156
    //   519: aconst_null
    //   520: astore_3
    //   521: goto -385 -> 136
    //   524: goto -496 -> 28
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	527	0	paramVafContext	VafContext
    //   0	527	1	paramInt	int
    //   0	527	2	paramBaseArticleInfo	BaseArticleInfo
    //   109	412	3	localObject1	Object
    //   10	221	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   70	94	468	org/json/JSONException
    //   94	110	468	org/json/JSONException
    //   114	123	468	org/json/JSONException
    //   127	136	468	org/json/JSONException
    //   368	373	468	org/json/JSONException
    //   376	381	468	org/json/JSONException
    //   384	389	468	org/json/JSONException
    //   392	397	468	org/json/JSONException
    //   400	405	468	org/json/JSONException
    //   408	413	468	org/json/JSONException
    //   416	421	468	org/json/JSONException
    //   424	429	468	org/json/JSONException
    //   432	437	468	org/json/JSONException
    //   440	445	468	org/json/JSONException
    //   448	453	468	org/json/JSONException
    //   70	94	484	java/lang/Exception
    //   94	110	484	java/lang/Exception
    //   114	123	484	java/lang/Exception
    //   127	136	484	java/lang/Exception
    //   368	373	484	java/lang/Exception
    //   376	381	484	java/lang/Exception
    //   384	389	484	java/lang/Exception
    //   392	397	484	java/lang/Exception
    //   400	405	484	java/lang/Exception
    //   408	413	484	java/lang/Exception
    //   416	421	484	java/lang/Exception
    //   424	429	484	java/lang/Exception
    //   432	437	484	java/lang/Exception
    //   440	445	484	java/lang/Exception
    //   448	453	484	java/lang/Exception
    //   145	153	500	java/lang/Exception
    //   156	168	504	java/lang/Exception
    //   168	183	504	java/lang/Exception
    //   187	227	504	java/lang/Exception
    //   227	268	504	java/lang/Exception
    //   145	153	508	org/json/JSONException
    //   156	168	512	org/json/JSONException
    //   168	183	512	org/json/JSONException
    //   187	227	512	org/json/JSONException
    //   227	268	512	org/json/JSONException
  }
  
  public static String a(BaseArticleInfo paramBaseArticleInfo)
  {
    String str = null;
    if (!qae.a(paramBaseArticleInfo))
    {
      QLog.d("ProteusSupportUtil", 1, "UGRuleManager getUGSchema is not ugCard");
      return null;
    }
    int i = qaa.jdField_a_of_type_Int;
    qaa localqaa = qaa.a();
    boolean bool = localqaa.a(paramBaseArticleInfo, true, i);
    if (bool)
    {
      str = localqaa.a(paramBaseArticleInfo, i, null, null);
      QLog.d("ProteusSupportUtil", 1, "UGRuleManager getUGSchema ugUrl is " + str);
    }
    localqaa.a(paramBaseArticleInfo, bool, true, i);
    return str;
  }
  
  private static void a()
  {
    pjo.a("ProteusSupportUtil", "resetProteusSeparatorHeightPx ");
    QLog.d("TemplateFactory", 4, "resetProteusSeparatorHeightPx");
    jdField_a_of_type_Int = 0;
  }
  
  public static void a(int paramInt, Container paramContainer, VafContext paramVafContext, baxy parambaxy, ram paramram, pau parampau, BaseArticleInfo paramBaseArticleInfo)
  {
    ViewFactory.findClickableViewListener(paramContainer.getVirtualView(), new olt(paramInt, paramContainer, parampau, paramVafContext, parambaxy, paramram, paramBaseArticleInfo));
  }
  
  private static void a(int paramInt1, Container paramContainer, pau parampau, int paramInt2)
  {
    bfwu.a("ProteusSupportUtil.bindView");
    if (paramContainer == null)
    {
      bfwu.a();
      return;
    }
    pjo.a("ProteusSupportUtil", "[bindView]");
    Object localObject = (php)jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt1));
    if (localObject != null)
    {
      ((php)localObject).a(paramInt1, paramContainer, parampau, paramInt2);
      bfwu.a();
    }
    for (;;)
    {
      bfwu.a();
      return;
      paramContainer = paramContainer.getVirtualView();
      switch (paramInt1)
      {
      default: 
        break;
      case 10: 
        localObject = (pju)paramContainer.findViewBaseByName("id_info_avator");
        if (localObject != null) {
          ((pju)localObject).a(parampau);
        }
        localObject = (pmk)paramContainer.findViewBaseByName("id_summary");
        if (localObject != null) {
          ((pmk)localObject).a(parampau);
        }
        localObject = (pjw)paramContainer.findViewBaseByName("id_biu_comment");
        if (localObject != null) {
          ((pjw)localObject).a(parampau);
        }
        paramContainer = (pjy)paramContainer.findViewBaseByName("id_corner_text_image");
        if (paramContainer != null) {
          paramContainer.a(parampau);
        }
        break;
      case 34: 
      case 40: 
      case 41: 
      case 42: 
        localObject = (pju)paramContainer.findViewBaseByName("id_info_avator");
        if (localObject != null) {
          ((pju)localObject).a(parampau);
        }
        localObject = (pmk)paramContainer.findViewBaseByName("id_summary");
        if (localObject != null) {
          ((pmk)localObject).a(parampau);
        }
        localObject = (pjw)paramContainer.findViewBaseByName("id_biu_comment");
        if (localObject != null) {
          ((pjw)localObject).a(parampau);
        }
        paramContainer = (pke)paramContainer.findViewBaseByName("id_multi_image");
        if (paramContainer != null) {
          paramContainer.a(parampau.a());
        }
        break;
      }
    }
  }
  
  private static void a(int paramInt, php paramphp)
  {
    if (paramphp == null) {
      throw new NullPointerException();
    }
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), paramphp);
  }
  
  public static void a(ProteusItemView paramProteusItemView, int paramInt1, BaseArticleInfo paramBaseArticleInfo, VafContext paramVafContext, baxy parambaxy, ram paramram, pau parampau, int paramInt2, String paramString)
  {
    if (pjp.a())
    {
      pjp.a("ProteusSupportUtil", "[bindData]  adapterViewType: " + paramInt1);
      if (paramBaseArticleInfo != null) {
        pjp.a("ProteusSupportUtil", " reportViewType: " + onh.a(paramBaseArticleInfo));
      }
      pjp.a("ProteusSupportUtil", "[bindData] " + paramBaseArticleInfo);
    }
    pjo.a("ProteusSupportUtil", "[bindData] adapterViewType: " + paramInt1);
    bfwu.a("ProteusSupportUtil.bindData");
    long l1 = System.currentTimeMillis();
    if ((paramProteusItemView == null) || (paramProteusItemView.a() == null))
    {
      bfwu.a();
      return;
    }
    b(paramVafContext, paramString);
    Object localObject = paramProteusItemView.a();
    TemplateBean localTemplateBean = a(paramVafContext, paramInt1, paramBaseArticleInfo);
    int i;
    int j;
    if (!a(paramProteusItemView.a(), paramInt1))
    {
      paramString = (String)localObject;
      if (localObject != null)
      {
        paramString = (String)localObject;
        if (localTemplateBean != null)
        {
          paramString = (String)localObject;
          if (localTemplateBean.getId() == ((TemplateBean)localObject).getId()) {}
        }
      }
    }
    else
    {
      if (localTemplateBean == null) {
        break label557;
      }
      i = localTemplateBean.getId();
      if (localObject == null) {
        break label563;
      }
      j = ((TemplateBean)localObject).getId();
      label229:
      QLog.i("ProteusSupportUtil", 1, "[bindData] trigger re-inflation, adapterViewType: " + paramInt1 + " new id: " + i + " old id: " + j);
      pjo.a("ProteusSupportUtil", "[bindData] trigger re-inflation, adapterViewType: " + paramInt1 + " new id: " + i + " old id: " + j);
      paramString = paramVafContext.getViewFactory().inflate(paramVafContext, localTemplateBean);
      if (paramString != null)
      {
        paramString.setBackgroundDrawable(paramVafContext.getContext().getResources().getDrawable(2130841262));
        paramProteusItemView.d();
        paramProteusItemView.a(paramString);
        pjp.a(paramString.getVirtualView(), "ProteusSupportUtil");
        pjp.a(paramString, "ProteusSupportUtil");
      }
      paramBaseArticleInfo.mProteusTemplateBean = localTemplateBean;
      a();
      paramString = null;
    }
    localObject = paramProteusItemView.a();
    paramProteusItemView.setTemplateBean(localTemplateBean);
    paramProteusItemView.setModel(parampau, paramram.a());
    bfwu.a("ProteusSupportUtil.bindDataImpl");
    label471:
    long l2;
    if (localTemplateBean != null)
    {
      QLog.i("ProteusSupportUtil", 1, "[bindData] bind data for " + localTemplateBean.getStyleName());
      a((Container)localObject, paramString, localTemplateBean);
      bfwu.a();
      a(paramInt1, (Container)localObject, parampau, paramInt2);
      a(paramInt1, (Container)localObject, paramVafContext, parambaxy, paramram, parampau, paramBaseArticleInfo);
      bfwu.a("ProteusSupportUtil.configDivider");
      a(parampau, paramVafContext);
      a((Container)localObject, parampau, localTemplateBean);
      bfwu.a();
      l2 = System.currentTimeMillis();
      if (localTemplateBean == null) {
        break label581;
      }
    }
    label557:
    label563:
    label581:
    for (paramProteusItemView = localTemplateBean.getStyleName();; paramProteusItemView = "")
    {
      saf.a("ProteusSupportUtil", paramProteusItemView, " ProteusSupportUtil.bindData", l2 - l1);
      bfwu.a();
      return;
      i = -1;
      break;
      j = -1;
      break label229;
      QLog.d("ProteusSupportUtil", 2, "[bindData] newTemplateBean is null");
      break label471;
    }
  }
  
  public static void a(ArticleInfo paramArticleInfo)
  {
    a(null, ram.c(paramArticleInfo), paramArticleInfo);
  }
  
  public static void a(BaseArticleInfo paramBaseArticleInfo, TemplateBean paramTemplateBean, ViewBase paramViewBase)
  {
    if ((!(paramBaseArticleInfo instanceof ArticleInfo)) || (paramTemplateBean == null)) {
      return;
    }
    String str = shu.b(paramBaseArticleInfo.mChannelID);
    HashMap localHashMap = new HashMap();
    Map localMap = paramTemplateBean.getDataAttribute(null);
    paramTemplateBean = paramTemplateBean.getDataAttribute(paramViewBase.getViewId());
    if (localMap != null) {
      localHashMap.putAll(localMap);
    }
    if (paramTemplateBean != null) {
      localHashMap.putAll(paramTemplateBean);
    }
    sez.a((ArticleInfo)paramBaseArticleInfo, str, str, (int)paramBaseArticleInfo.mChannelID, localHashMap);
    sez.a(paramTemplateBean);
    bhvy.a(paramBaseArticleInfo);
  }
  
  public static void a(BaseArticleInfo paramBaseArticleInfo, ViewBase paramViewBase, TemplateBean paramTemplateBean)
  {
    if ((paramBaseArticleInfo == null) || (paramViewBase == null) || (paramTemplateBean == null)) {}
    do
    {
      do
      {
        return;
        paramViewBase = paramTemplateBean.getDataAttribute(paramViewBase.getViewId()).get("rowkey");
      } while (!(paramViewBase instanceof String));
      paramViewBase = (String)paramViewBase;
    } while (TextUtils.isEmpty(paramViewBase));
    paramBaseArticleInfo.viewRowkey = paramViewBase;
  }
  
  public static void a(TemplateBean paramTemplateBean, ViewBase paramViewBase)
  {
    a(paramTemplateBean, paramViewBase, "click_T");
  }
  
  public static void a(TemplateBean paramTemplateBean, ViewBase paramViewBase, String paramString)
  {
    if ((paramTemplateBean == null) || (paramViewBase == null)) {
      return;
    }
    ono localono = new ono();
    String str = (String)paramTemplateBean.getDataAttribute(paramViewBase.getName(), paramString);
    if (str == null)
    {
      QLog.d("ProteusSupportUtil", 2, "reportDataAttrInfo bigT is null");
      return;
    }
    paramTemplateBean = paramTemplateBean.getDataAttribute(paramViewBase.getName());
    if (paramTemplateBean != null)
    {
      paramTemplateBean = paramTemplateBean.entrySet().iterator();
      while (paramTemplateBean.hasNext())
      {
        Object localObject = (Map.Entry)paramTemplateBean.next();
        paramViewBase = (String)((Map.Entry)localObject).getKey();
        localObject = ((Map.Entry)localObject).getValue();
        if (!TextUtils.equals(paramViewBase, paramString)) {
          localono.b(paramViewBase, localObject.toString());
        }
      }
    }
    nol.a(null, "CliOper", "", "", str, str, 0, 0, "", "", "", localono.a(), false);
  }
  
  public static void a(Container paramContainer, TemplateBean paramTemplateBean1, TemplateBean paramTemplateBean2)
  {
    bfwu.a("ProteusSupportUtil.bindDynamicValueWithoutRecursion");
    long l1 = System.currentTimeMillis();
    Map localMap1 = paramContainer.getViewIdMapping();
    Map localMap2 = paramTemplateBean2.getViewDataBinding();
    HashSet localHashSet = new HashSet();
    if (paramTemplateBean1 != null) {}
    for (paramContainer = paramTemplateBean1.getViewDataBinding();; paramContainer = null)
    {
      pjo.a("ProteusSupportUtil", "[bindDynamicValueWithoutRecursion] map");
      if ((localHashSet != null) && (localMap1 != null)) {
        localHashSet.addAll(localMap1.keySet());
      }
      Iterator localIterator = localMap2.keySet().iterator();
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        label138:
        long l2;
        ViewBean localViewBean;
        Object localObject;
        label178:
        label211:
        int i;
        if ("[ " + paramTemplateBean2 != null)
        {
          paramTemplateBean1 = paramTemplateBean2.getStyleName();
          bfwu.a(paramTemplateBean1);
          l2 = System.currentTimeMillis();
          localViewBean = (ViewBean)localMap2.get(str);
          if (paramContainer == null) {
            break label474;
          }
          localObject = (ViewBean)paramContainer.get(str);
          if (localHashSet != null) {
            localHashSet.remove(str);
          }
          if (localMap1 == null) {
            break label480;
          }
          paramTemplateBean1 = (ViewBase)localMap1.get(str);
          bfwu.a("bindDynamicValueWithoutRecursion.bindDynamicVal.check");
          if ((str == null) || (paramTemplateBean1 == null) || (localViewBean == null) || ((localObject != null) && (localViewBean.valueBean.dynamicValue.equals(((ViewBean)localObject).valueBean.dynamicValue)))) {
            break label485;
          }
          i = 1;
          label262:
          bfwu.a();
          if (i == 0) {
            break label498;
          }
          if ("[ " + paramTemplateBean2 == null) {
            break label490;
          }
          localObject = paramTemplateBean2.getStyleName();
          label298:
          bfwu.a((String)localObject);
          localViewBean.setVisible(true);
          paramTemplateBean1.bindDynamicValue(localViewBean);
          QLog.d("ProteusSupportUtil", 1, "bindDynamicValueWithoutRecursion | [ viewId = " + str + " value changed ] newValue: " + localViewBean.valueBean.dynamicValue + "; cost " + (System.currentTimeMillis() - l2) + "ms");
          bfwu.a();
          if (QLog.isColorLevel()) {
            QLog.i("ProteusSupportUtil", 2, "[bindDynamicValueWithoutRecursion] bind dynamicValue: " + localViewBean.valueBean.dynamicValue + " viewId = " + str);
          }
        }
        for (;;)
        {
          if (paramTemplateBean1 != null) {
            paramTemplateBean1.setVisibility(0);
          }
          bfwu.a();
          break;
          paramTemplateBean1 = "]" + str;
          break label138;
          label474:
          localObject = null;
          break label178;
          label480:
          paramTemplateBean1 = null;
          break label211;
          label485:
          i = 0;
          break label262;
          label490:
          localObject = "]_bindDynamicValue";
          break label298;
          label498:
          if ((QLog.isColorLevel()) && (localViewBean != null))
          {
            QLog.i("ProteusSupportUtil", 1, "[bindDynamicValueWithoutRecursion] skip: " + localViewBean.valueBean.dynamicValue + " viewId = " + str);
            QLog.d("ProteusSupportUtil", 2, "bindDynamicValueWithoutRecursion | [ viewId = " + str + " value not changed ] cost " + (System.currentTimeMillis() - l2) + "ms");
          }
        }
      }
      pjo.a("ProteusSupportUtil", "[bindDynamicValueWithoutRecursion] recur");
      if (localHashSet != null)
      {
        paramContainer = localHashSet.iterator();
        while (paramContainer.hasNext()) {
          ((ViewBase)localMap1.get((String)paramContainer.next())).setVisibility(8);
        }
      }
      if (paramTemplateBean2 != null)
      {
        paramContainer = paramTemplateBean2.getStyleName();
        saf.a("ProteusSupportUtil", paramContainer, "bindDynamicValueWithoutRecursion", System.currentTimeMillis() - l1);
        if ("bindDynamicValueWithoutRecursion_____ " + paramTemplateBean2 == null) {
          break label732;
        }
      }
      label732:
      for (paramContainer = paramTemplateBean2.getStyleName();; paramContainer = " cost " + (System.currentTimeMillis() - l1) + "ms")
      {
        QLog.d("ProteusSupportUtil", 2, paramContainer);
        bfwu.a();
        return;
        paramContainer = "";
        break;
      }
    }
  }
  
  public static void a(Container paramContainer, VafContext paramVafContext, TemplateBean paramTemplateBean)
  {
    ViewFactory.findClickableViewListener(paramContainer.getVirtualView(), new olp(paramVafContext, paramTemplateBean));
  }
  
  public static void a(Container paramContainer, pau parampau, TemplateBean paramTemplateBean)
  {
    if (olc.a(paramContainer, parampau)) {
      return;
    }
    ViewBase localViewBase1 = paramContainer.getVirtualView();
    ViewBase localViewBase2 = localViewBase1.findViewBaseByName("id_separator");
    ArticleInfo localArticleInfo = parampau.a();
    if ((localArticleInfo == null) || (localViewBase2 == null))
    {
      QLog.d("ProteusSupportUtil", 1, "configDivider failed, articleInfo is null or divider is null.");
      return;
    }
    Layout.Params localParams = localViewBase2.getComLayoutParams();
    int m = localParams.mLayoutHeight;
    int i = Utils.dp2px(5.0D);
    double d = Utils.dp2px(6.0D);
    int j = parampau.a();
    int k = parampau.b();
    if (localArticleInfo.mChannelID == 70L)
    {
      bfwu.a("configDivider.FollowFeeds");
      localParams.mLayoutMarginLeft = 0;
      localParams.mLayoutMarginRight = 0;
      localParams.mLayoutWidth = -1;
      i = Utils.dp2px(5.0D);
      bfwu.a();
    }
    for (;;)
    {
      localParams.mLayoutHeight = i;
      localViewBase2.setComLayoutParams(localParams);
      parampau = localViewBase1.getComLayoutParams();
      if (parampau.mLayoutHeight >= 0) {
        parampau.mLayoutHeight = (i - m + parampau.mLayoutHeight);
      }
      parampau = localViewBase1.getComLayoutParams();
      paramContainer.setLayoutParams(new RelativeLayout.LayoutParams(parampau.mLayoutWidth, parampau.mLayoutHeight));
      return;
      if (oou.c((int)localArticleInfo.mChannelID))
      {
        bfwu.a("configDivider.DailyFeeds");
        parampau = parampau.b();
        j = 0;
        k = 0;
        i = k;
        if (parampau != null)
        {
          i = k;
          if (parampau.mProteusTemplateBean != null)
          {
            if (parampau.mProteusTemplateBean.getDataAttribute(null, "position_jump") == null) {
              break label344;
            }
            i = 1;
          }
        }
        label279:
        if (localArticleInfo.mProteusTemplateBean != null)
        {
          if (localArticleInfo.mProteusTemplateBean.getDataAttribute(null, "position_jump") != null) {
            j = 1;
          }
        }
        else
        {
          label305:
          if (j == i) {
            break label356;
          }
          localParams.mLayoutMarginLeft = 0;
          localParams.mLayoutMarginRight = 0;
          localParams.mLayoutWidth = -1;
          i = Utils.dp2px(5.0D);
        }
        for (;;)
        {
          bfwu.a();
          break;
          label344:
          i = 0;
          break label279;
          j = 0;
          break label305;
          label356:
          j = b(paramTemplateBean);
          i = j;
          if (j == a(paramTemplateBean))
          {
            i = a(paramTemplateBean);
            j = Utils.dp2px(a(paramTemplateBean));
            localParams.mLayoutMarginRight = j;
            localParams.mLayoutMarginLeft = j;
            localParams.mLayoutWidth = -1;
          }
        }
      }
      if ((j == 29) || (j == 30) || (k == 29) || (k == 30))
      {
        i = a(paramTemplateBean);
        localParams.mLayoutMarginLeft = 0;
        localParams.mLayoutMarginRight = 0;
        localParams.mLayoutWidth = -1;
      }
      else if ((a(parampau.b())) || (a(parampau)))
      {
        i = 0;
        localParams.mLayoutMarginLeft = 0;
        localParams.mLayoutMarginRight = 0;
        localParams.mLayoutWidth = -1;
      }
      else if (a(j, k))
      {
        bfwu.a("configDivider.normal");
        bfwu.a("configDivider.normal.getProteusSeparatorHeightPx");
        i = a(paramTemplateBean);
        bfwu.a();
        bfwu.a("configDivider.normal.getProteusSeparatorMarginLeftPx");
        d = a(paramTemplateBean);
        bfwu.a();
        j = Utils.dp2px(d);
        localParams.mLayoutMarginRight = j;
        localParams.mLayoutMarginLeft = j;
        localParams.mLayoutWidth = -1;
        bfwu.a();
      }
      else
      {
        localParams.mLayoutMarginLeft = 0;
        localParams.mLayoutMarginRight = 0;
        localParams.mLayoutWidth = -1;
      }
    }
  }
  
  public static void a(VafContext paramVafContext, String paramString)
  {
    paramVafContext.setTemplateFactory(rpr.a(paramString, true));
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyLikeButton", new ple());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyAvatarView", new pjv());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyVariableImageContentView", new pkf());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoySummaryView", new pml());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyCommentView", new pjt());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyBiuCommentView", new pjx());
    paramVafContext.getViewFactory().registerViewBuilder("CornerTextImageView", new pjz());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyMiddleBodyView", new plj());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyUsersCommentView", new pmn());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyFriendsBiu", new pku());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyQARichView", new NativeText.Builder());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyBiuButton", new pkp());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyCoordinateView", new pks());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoySocializeRecommendFollowView", new plv());
    paramVafContext.getViewFactory().registerViewBuilder("UILabel", new pmj());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInjoyAsynImageView", new pmf());
    paramVafContext.getViewFactory().registerViewBuilder("UIImageView", new pmf());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInjoyAsynImageIcon", new pmd());
    paramVafContext.getViewFactory().registerViewBuilder("ProteusCollectionView", new pnw());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyAdVideoGuide", new pkm());
    paramVafContext.getViewFactory().registerViewBuilder("PTSAvatarView", new okh());
    paramVafContext.getViewFactory().registerViewBuilder("QQAvatarView", new okh());
    paramVafContext.getViewFactory().registerViewBuilder("QQRIJCommentEmotioinLabel", new okj());
    paramVafContext.getViewFactory().registerViewBuilder("QQRIJRichTextView", new okj());
    paramVafContext.getViewFactory().registerViewBuilder("QQRIJCommentLikeButton", new okl());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyExposeReplyCommentView", new okn());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyAwesomeCommentView", new pko());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyAdDownloadView", new occ());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyAdLocationView", new pkk());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyIconText", new oct());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInjoyDoubleImageView", new oda());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInjoyTripleImageInteractView", new odc());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyAdInnerOperateView", new oce());
    paramVafContext.getViewFactory().registerViewBuilder("ReadinjoyNativeArticleAdDownloadView", new odh());
    paramVafContext.getViewFactory().registerViewBuilder("ProteusTickerView", new pkh());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInjoyShareView", new pll());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInjoyApngImageView", new pmb());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyAdBrandOptimizationView", new oca());
    a();
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyArticleBottomVideoView", new oco());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyVideoView", new plz());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyGifView", new pkw());
    paramVafContext.getViewFactory().registerViewBuilder("ProteusMarqueeLabel", new NativeText.Builder());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyLinkClickableLabel", new pmj());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyLottieView", new plh());
    paramVafContext.getViewFactory().registerViewBuilder("FusionBiuButton", new pkd());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyLikeBiuFusionFloatView", new pla());
  }
  
  public static void a(ViewBase paramViewBase, ViewBean paramViewBean)
  {
    if (paramViewBase != null)
    {
      paramViewBase.bindDynamicValue(paramViewBean);
      if ((paramViewBase instanceof Layout))
      {
        paramViewBase = ((Layout)paramViewBase).getSubViews();
        if ((paramViewBase != null) && (paramViewBean.children != null))
        {
          List localList = Arrays.asList(paramViewBean.children);
          int j = paramViewBase.size();
          if (localList.size() == j)
          {
            int i = 0;
            while (i < j)
            {
              a((ViewBase)paramViewBase.get(i), (ViewBean)localList.get(i));
              i += 1;
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d("ProteusSupportUtil", 2, "bindDataImpl: fail to bind data for " + paramViewBean.viewId + "due to ViewBean - ViewBase count mismatch");
          }
        }
      }
      pjo.a("ProteusSupportUtil", "[bindDynamicValue]");
    }
  }
  
  private static void a(pau parampau, VafContext paramVafContext)
  {
    Object localObject = parampau.a();
    if (localObject != null)
    {
      localObject = ((ram)localObject).b(parampau.g() + 1);
      if ((localObject != null) && (((BaseArticleInfo)localObject).mProteusTemplateBean == null))
      {
        QLog.d("ProteusSupportUtil", 2, "next.mProteusTemplateBean == null " + localObject);
        ((BaseArticleInfo)localObject).mProteusTemplateBean = a(paramVafContext, parampau.b(), (BaseArticleInfo)localObject);
      }
    }
  }
  
  public static boolean a(int paramInt)
  {
    if (!oln.a()) {}
    do
    {
      return false;
      switch (paramInt)
      {
      }
    } while (oak.a(paramInt));
    return jdField_a_of_type_JavaUtilMap.containsKey(Integer.valueOf(paramInt));
    return true;
    return true;
    return true;
    return true;
    return true;
    return true;
    return true;
    return true;
  }
  
  public static boolean a(int paramInt1, int paramInt2)
  {
    boolean bool2 = true;
    bfwu.a("configDivider.isDividerNormal");
    if ((paramInt1 == 0) || (paramInt1 == 1) || (paramInt1 == 2) || (paramInt1 == 3) || (paramInt1 == 5) || (paramInt1 == 47) || (paramInt1 == 60) || (paramInt1 == 39) || (paramInt1 == 66) || (paramInt1 == 50) || (paramInt1 == 51) || (paramInt1 == 52) || (paramInt1 == 53) || (paramInt1 == 96) || (paramInt1 == 103) || (paramInt1 == 102) || (paramInt1 == 101) || (paramInt1 == 104) || (paramInt1 == 105) || (paramInt1 == 106) || (paramInt1 == 116) || (paramInt1 == 122) || (paramInt1 == 117) || (paramInt1 >= 135) || (paramInt1 == 121) || (paramInt1 == 126) || (paramInt1 == 115) || (paramInt1 == 124) || (paramInt1 == 125) || (paramInt1 == 127) || (paramInt1 == 129) || (paramInt1 == 130))
    {
      bool1 = bool2;
      if (paramInt2 != 0)
      {
        bool1 = bool2;
        if (paramInt2 != 1)
        {
          bool1 = bool2;
          if (paramInt2 != 2)
          {
            bool1 = bool2;
            if (paramInt2 != 3)
            {
              bool1 = bool2;
              if (paramInt2 != 5)
              {
                bool1 = bool2;
                if (paramInt2 != 6)
                {
                  bool1 = bool2;
                  if (paramInt2 != 47)
                  {
                    bool1 = bool2;
                    if (paramInt2 != 60)
                    {
                      bool1 = bool2;
                      if (paramInt2 != 39)
                      {
                        bool1 = bool2;
                        if (paramInt2 != 66)
                        {
                          bool1 = bool2;
                          if (paramInt2 != 50)
                          {
                            bool1 = bool2;
                            if (paramInt2 != 51)
                            {
                              bool1 = bool2;
                              if (paramInt2 != 52)
                              {
                                bool1 = bool2;
                                if (paramInt2 != 53)
                                {
                                  bool1 = bool2;
                                  if (paramInt2 != 96)
                                  {
                                    bool1 = bool2;
                                    if (paramInt2 != 103)
                                    {
                                      bool1 = bool2;
                                      if (paramInt2 != 102)
                                      {
                                        bool1 = bool2;
                                        if (paramInt2 != 101)
                                        {
                                          bool1 = bool2;
                                          if (paramInt2 != 104)
                                          {
                                            bool1 = bool2;
                                            if (paramInt2 != 105)
                                            {
                                              bool1 = bool2;
                                              if (paramInt2 != 106)
                                              {
                                                bool1 = bool2;
                                                if (paramInt2 != 46)
                                                {
                                                  bool1 = bool2;
                                                  if (paramInt2 != 116)
                                                  {
                                                    bool1 = bool2;
                                                    if (paramInt1 != 122)
                                                    {
                                                      bool1 = bool2;
                                                      if (paramInt2 != 117)
                                                      {
                                                        bool1 = bool2;
                                                        if (paramInt2 < 135)
                                                        {
                                                          bool1 = bool2;
                                                          if (paramInt2 != 121)
                                                          {
                                                            bool1 = bool2;
                                                            if (paramInt2 != 126)
                                                            {
                                                              bool1 = bool2;
                                                              if (paramInt2 != 115)
                                                              {
                                                                bool1 = bool2;
                                                                if (paramInt2 != 124)
                                                                {
                                                                  bool1 = bool2;
                                                                  if (paramInt2 != 125)
                                                                  {
                                                                    bool1 = bool2;
                                                                    if (paramInt2 != 127)
                                                                    {
                                                                      bool1 = bool2;
                                                                      if (paramInt2 != 129)
                                                                      {
                                                                        bool1 = bool2;
                                                                        if (paramInt2 != 130) {
                                                                          if (paramInt2 != 128) {
                                                                            break label480;
                                                                          }
                                                                        }
                                                                      }
                                                                    }
                                                                  }
                                                                }
                                                              }
                                                            }
                                                          }
                                                        }
                                                      }
                                                    }
                                                  }
                                                }
                                              }
                                            }
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    label480:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      bfwu.a();
      return bool1;
    }
  }
  
  /* Error */
  public static boolean a(ArticleInfo paramArticleInfo)
  {
    // Byte code:
    //   0: ldc_w 1215
    //   3: invokestatic 128	bfwu:a	(Ljava/lang/String;)V
    //   6: aload_0
    //   7: ifnull +154 -> 161
    //   10: aload_0
    //   11: getfield 1218	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:proteusItemsData	Ljava/lang/String;
    //   14: invokestatic 703	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   17: ifne +144 -> 161
    //   20: aload_0
    //   21: getfield 1221	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mFeedType	I
    //   24: bipush 29
    //   26: if_icmpeq +8 -> 34
    //   29: invokestatic 142	bfwu:a	()V
    //   32: iconst_0
    //   33: ireturn
    //   34: new 430	org/json/JSONObject
    //   37: dup
    //   38: aload_0
    //   39: getfield 1218	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:proteusItemsData	Ljava/lang/String;
    //   42: invokespecial 1223	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   45: astore_0
    //   46: aload_0
    //   47: invokevirtual 1226	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   50: astore_2
    //   51: aload_2
    //   52: invokeinterface 739 1 0
    //   57: ifeq +104 -> 161
    //   60: aload_2
    //   61: invokeinterface 743 1 0
    //   66: checkcast 173	java/lang/String
    //   69: astore_3
    //   70: aload_0
    //   71: aload_3
    //   72: invokevirtual 1230	org/json/JSONObject:opt	(Ljava/lang/String;)Ljava/lang/Object;
    //   75: astore 4
    //   77: ldc_w 1232
    //   80: aload_3
    //   81: invokevirtual 1233	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   84: ifeq -33 -> 51
    //   87: ldc 206
    //   89: iconst_1
    //   90: iconst_2
    //   91: anewarray 4	java/lang/Object
    //   94: dup
    //   95: iconst_0
    //   96: ldc_w 1235
    //   99: aastore
    //   100: dup
    //   101: iconst_1
    //   102: aload 4
    //   104: aastore
    //   105: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   108: invokestatic 142	bfwu:a	()V
    //   111: ldc_w 1237
    //   114: aload 4
    //   116: invokestatic 1240	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   119: invokevirtual 1233	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   122: ifne +19 -> 141
    //   125: ldc_w 1242
    //   128: aload 4
    //   130: invokestatic 1240	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   133: invokevirtual 1233	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   136: istore_1
    //   137: iload_1
    //   138: ifeq +7 -> 145
    //   141: iconst_1
    //   142: istore_1
    //   143: iload_1
    //   144: ireturn
    //   145: iconst_0
    //   146: istore_1
    //   147: goto -4 -> 143
    //   150: astore_0
    //   151: ldc 206
    //   153: iconst_1
    //   154: ldc_w 1244
    //   157: aload_0
    //   158: invokestatic 1246	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   161: invokestatic 142	bfwu:a	()V
    //   164: iconst_0
    //   165: ireturn
    //   166: astore_0
    //   167: ldc 206
    //   169: iconst_1
    //   170: ldc_w 1248
    //   173: aload_0
    //   174: invokestatic 1246	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   177: goto -16 -> 161
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	180	0	paramArticleInfo	ArticleInfo
    //   136	11	1	bool	boolean
    //   50	11	2	localIterator	Iterator
    //   69	12	3	str	String
    //   75	54	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   34	51	150	org/json/JSONException
    //   51	137	150	org/json/JSONException
    //   34	51	166	java/lang/Exception
    //   51	137	166	java/lang/Exception
  }
  
  private static boolean a(Container paramContainer, int paramInt)
  {
    if (paramContainer != null) {
      try
      {
        int j = paramContainer.getChildCount();
        int i = 0;
        while (i < j)
        {
          Object localObject = paramContainer.getChildAt(i);
          if ((localObject instanceof NativeLayoutImpl))
          {
            NativeLayoutImpl localNativeLayoutImpl = (NativeLayoutImpl)localObject;
            if ((localNativeLayoutImpl.getChildCount() == 0) && (localNativeLayoutImpl.getBackgroundColor() == 0))
            {
              nol.a(onh.a(), "CliOper", "", "", "0X8009AC1", "0X8009AC1", 0, 0, "", "", "", "", false);
              pjp.a(paramContainer.getVirtualView(), "ProteusSupportUtil");
              pjp.a(paramContainer, "ProteusSupportUtil");
              QLog.e("ProteusSupportUtil", 1, "[nativeLayoutImplError] empty native layout " + paramInt);
              return true;
            }
          }
          if ((QLog.isColorLevel()) && ((localObject instanceof ViewGroup)))
          {
            localObject = (ViewGroup)localObject;
            QLog.e("ProteusSupportUtil", 1, "ChildCount " + ((ViewGroup)localObject).getChildCount());
          }
          i += 1;
        }
        return false;
      }
      catch (Exception paramContainer)
      {
        QLog.e("ProteusSupportUtil", 1, "[nativeLayoutImplError] ", paramContainer);
      }
    }
  }
  
  public static boolean a(VafContext paramVafContext, int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    return a(paramVafContext, paramInt, paramBaseArticleInfo) != null;
  }
  
  public static boolean a(VafContext paramVafContext, String paramString)
  {
    paramString = rpr.a(paramString, true);
    if (paramVafContext.getTemplateFactory() == null)
    {
      paramVafContext.setTemplateFactory(paramString);
      return true;
    }
    if ((paramString != null) && (paramString.getTemplateId() != paramVafContext.getTemplateFactory().getTemplateId()))
    {
      paramVafContext.setTemplateFactory(paramString);
      return true;
    }
    return false;
  }
  
  public static boolean a(pau parampau)
  {
    if (parampau != null) {
      try
      {
        int i = parampau.b();
        if ((i == 66) || (i == 39))
        {
          parampau = parampau.b();
          if ((parampau != null) && (AdvertisementInfo.isAdvertisementInfo(parampau)))
          {
            parampau = ((AdvertisementInfo)parampau).mAdExtInfo;
            if (parampau != null)
            {
              i = new JSONObject(parampau).optInt("is_video_new");
              return i == 1;
            }
          }
        }
      }
      catch (Exception parampau)
      {
        QLog.d("ProteusSupportUtil", 1, "isNextCardAdBigImgOrAdVideo JSONException, e = ", parampau);
      }
    }
    return false;
  }
  
  private static int b(TemplateBean paramTemplateBean)
  {
    if ((paramTemplateBean != null) && (paramTemplateBean.getViewBean() != null)) {
      try
      {
        paramTemplateBean = (SizeValue)paramTemplateBean.getViewBean().findViewById("id_separator").valueBean.normalValue.get("height");
        pjo.a("ProteusSupportUtil", "[getSepatatorHeight] getSepatatorHeight");
        int i = paramTemplateBean.getLayoutSize();
        return i;
      }
      catch (Exception paramTemplateBean)
      {
        paramTemplateBean.printStackTrace();
        QLog.d("ProteusSupportUtil", 1, "getProteusSeparatorHeight exception.");
      }
    }
    return 0;
  }
  
  private static void b(ViewBean paramViewBean)
  {
    if (paramViewBean == null) {}
    do
    {
      return;
      paramViewBean = paramViewBean.getDynamicValue("setProteusReportInfo:");
    } while (!(paramViewBean instanceof JSONObject));
    try
    {
      JSONObject localJSONObject = (JSONObject)paramViewBean;
      paramViewBean = localJSONObject.getString("click_T");
      localJSONObject = localJSONObject.getJSONObject("info");
      ono localono = new ono();
      Iterator localIterator = localJSONObject.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localono.b(str, localJSONObject.get(str).toString());
      }
      nol.a(null, "CliOper", "", "", paramViewBean, paramViewBean, 0, 0, "", "", "", localono.a(), false);
    }
    catch (Exception paramViewBean)
    {
      QLog.d("ProteusSupportUtil", 1, paramViewBean, new Object[] { "" });
      return;
    }
  }
  
  private static void b(VafContext paramVafContext, String paramString)
  {
    paramString = rpr.a(paramString, false);
    if ((paramString != null) && (paramVafContext.getTemplateFactory() != paramString)) {
      paramVafContext.setTemplateFactory(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     olo
 * JD-Core Version:    0.7.0.1
 */