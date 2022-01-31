import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
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

public class opy
{
  private static double jdField_a_of_type_Double;
  private static int jdField_a_of_type_Int;
  private static final Map<Integer, poa> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  static
  {
    if (jdField_a_of_type_JavaUtilMap.isEmpty())
    {
      a(3, new poj());
      a(72, new pkv());
      a(73, new plb());
      a(74, new poe());
      a(90, new pod());
      a(91, new pod());
      a(75, new poe());
      a(21, new pol());
      a(22, new pol());
      a(36, new pol());
      a(23, new pol());
      a(120, new pol());
      a(80, new pol());
      a(34, new pna());
      a(16, new pna());
      a(17, new pna());
      a(19, new pna());
      a(18, new pna());
      a(20, new pna());
      a(65, new pna());
      a(64, new pna());
      a(48, new pna());
      a(25, new plm());
      a(24, new plm());
      a(26, new plm());
      a(107, new pol());
      a(108, new plm());
      a(37, new plm());
      a(81, new plm());
      a(35, new ple());
      a(12, new ple());
      a(10, new ple());
      a(11, new ple());
      a(28, new ple());
      a(27, new ple());
      a(49, new ple());
      a(62, new ple());
      a(63, new ple());
      a(33, new ple());
      a(31, new pna());
      a(32, new pna());
      a(79, new pmx());
      a(76, new pmx());
      a(77, new pmx());
      a(78, new pmx());
      a(83, new pna());
      a(84, new pna());
      a(85, new pna());
      a(86, new pna());
      a(89, new pkn());
      a(92, new plm());
      a(94, new ple());
      a(95, new ple());
      a(101, new pmd());
      a(102, new pmd());
      a(103, new pmd());
      a(105, new pku());
      a(66, new pkp());
      a(115, new pkp());
      a(39, new pko());
      a(116, new pkr());
      a(117, new pkt());
      a(106, new pks());
      a(109, new pnh());
      a(110, new pnh());
      a(111, new pnh());
      a(132, new pnh());
      a(133, new pnh());
      a(134, new pnh());
      a(112, new ple());
      a(113, new ple());
      a(114, new ple());
      a(126, new pkz());
      a(2, new pky());
      a(1, new poh());
      a(121, new plv());
      a(122, new pko());
      a(124, new pmj());
      a(125, new pmj());
      a(127, new pkq());
      a(129, new pmi());
      a(130, new pmh());
      a(131, new pmo());
      a(46, new plx());
      a(123, new pms());
      a(135, new pmf());
      a(137, new plq());
      a(139, new plq());
      a(138, new plq());
    }
  }
  
  private static double a(TemplateBean paramTemplateBean)
  {
    bhxr.a("getProteusSeparatorMarginLeftPx");
    if ((jdField_a_of_type_Double > 0.0D) && (paramTemplateBean != null))
    {
      sfq localsfq = sfq.a("default_feeds", false);
      if ((localsfq != null) && (!localsfq.a(paramTemplateBean)))
      {
        bhxr.a();
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
    bhxr.a();
    return jdField_a_of_type_Double;
  }
  
  private static int a(TemplateBean paramTemplateBean)
  {
    bhxr.a("getProteusSeparatorHeightPx");
    if ((jdField_a_of_type_Int > 0) && (paramTemplateBean != null))
    {
      localsfq = sfq.a("default_feeds", false);
      if ((localsfq != null) && (!localsfq.a(paramTemplateBean)))
      {
        bhxr.a();
        pqa.a("ProteusSupportUtil", "[getProteusSeparatorHeightPx] SeparatorHeight : " + jdField_a_of_type_Int);
        return jdField_a_of_type_Int;
      }
    }
    sfq localsfq = sfq.a("default_feeds", false);
    paramTemplateBean = null;
    if (localsfq != null) {
      paramTemplateBean = localsfq.getTemplate("ReadInjoy_triple_img_cell");
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
        pqa.a("ProteusSupportUtil", "[getProteusSeparatorHeightPx] getSeparatorHeightPx");
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
      bhxr.a();
      return jdField_a_of_type_Int;
      jdField_a_of_type_Int = Utils.dp2px(0.5D);
    }
  }
  
  public static ProteusItemView a(VafContext paramVafContext, int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    if (pqb.a()) {
      pqb.a("ProteusSupportUtil", "[getView] " + paramBaseArticleInfo + " adapterViewType: " + paramInt);
    }
    long l1 = System.currentTimeMillis();
    bhxr.a("ProteusSupportUtil.getView");
    Object localObject1 = null;
    bhxr.a("ProteusSupportUtil#getView#getTemplateBean");
    TemplateBean localTemplateBean = a(paramVafContext, paramInt, paramBaseArticleInfo);
    bhxr.a();
    Object localObject2 = "";
    label210:
    label226:
    long l2;
    if (localTemplateBean != null)
    {
      localObject2 = "[" + localTemplateBean.getStyleName() + "]";
      paramBaseArticleInfo = localObject1;
      localObject1 = localObject2;
      bhxr.a(localObject1 + "#inflate");
      localObject2 = paramVafContext.getViewFactory().inflate(paramVafContext, localTemplateBean);
      pqa.a("ProteusSupportUtil", "[getView] inflate");
      bhxr.a();
      if (localObject2 != null)
      {
        bhxr.a(localObject1 + "#setBackgroundDrawable");
        if ((!ors.p()) || (!bjxj.k())) {
          break label400;
        }
        paramInt = 1;
        paramBaseArticleInfo = paramVafContext.getContext().getResources();
        if (paramInt == 0) {
          break label405;
        }
        paramInt = 2130841379;
        ((Container)localObject2).setBackgroundDrawable(paramBaseArticleInfo.getDrawable(paramInt));
        paramBaseArticleInfo = new ProteusItemView(paramVafContext.getContext());
        paramBaseArticleInfo.a((Container)localObject2);
        bhxr.a();
        pqa.a("ProteusSupportUtil", "[getView]  add Container ");
      }
      if (QLog.isColorLevel()) {
        pqb.a((View)localObject2, "ProteusSupportUtil");
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
      srq.a("ProteusSupportUtil", paramVafContext, "ProteusSupportUtil.getView", l2 - l1);
      bhxr.a();
      return paramBaseArticleInfo;
      pqa.a("ProteusSupportUtil", "[getView]  new proteusItemView ");
      ProteusItemView localProteusItemView = new ProteusItemView(paramVafContext.getContext());
      localProteusItemView.setVisibility(8);
      QLog.i("ProteusSupportUtil", 1, "[getView] 未找到样式,请确认是否下发该卡片的样式:" + paramBaseArticleInfo + " adapterViewType: " + paramInt + "  " + paramVafContext.getTemplateFactory());
      localObject1 = localObject2;
      paramBaseArticleInfo = localProteusItemView;
      break;
      paramInt = 0;
      break label210;
      paramInt = 2130841380;
      break label226;
    }
  }
  
  /* Error */
  public static TemplateBean a(VafContext paramVafContext, int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +16 -> 17
    //   4: ldc 138
    //   6: iconst_0
    //   7: invokestatic 143	sfq:a	(Ljava/lang/String;Z)Lsfq;
    //   10: astore_3
    //   11: aload_3
    //   12: ifnonnull +516 -> 528
    //   15: aconst_null
    //   16: areturn
    //   17: aload_0
    //   18: invokevirtual 394	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/VafContext:getTemplateFactory	()Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/factory/BaseTemplateFactory;
    //   21: checkcast 140	sfq
    //   24: astore_3
    //   25: invokestatic 194	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   28: ifeq +39 -> 67
    //   31: ldc 212
    //   33: iconst_2
    //   34: new 224	java/lang/StringBuilder
    //   37: dup
    //   38: invokespecial 225	java/lang/StringBuilder:<init>	()V
    //   41: ldc_w 404
    //   44: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: aload_2
    //   48: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   51: ldc_w 406
    //   54: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: iload_1
    //   58: invokevirtual 234	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   61: invokevirtual 238	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: invokestatic 217	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   67: aload_2
    //   68: getfield 412	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mProteusTemplateBean	Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;
    //   71: ifnull +19 -> 90
    //   74: aload_3
    //   75: aload_2
    //   76: getfield 412	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mProteusTemplateBean	Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;
    //   79: invokevirtual 146	sfq:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;)Z
    //   82: ifne +8 -> 90
    //   85: aload_2
    //   86: getfield 412	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mProteusTemplateBean	Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;
    //   89: areturn
    //   90: getstatic 18	opy:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   93: iload_1
    //   94: invokestatic 266	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   97: invokeinterface 177 2 0
    //   102: checkcast 414	poa
    //   105: astore 4
    //   107: aload 4
    //   109: ifnull +165 -> 274
    //   112: aload 4
    //   114: iload_1
    //   115: aload_2
    //   116: invokeinterface 417 3 0
    //   121: astore_0
    //   122: invokestatic 422	com/tencent/biz/pubaccount/readinjoy/redpacket/RIJRedPacketManager:a	()Lcom/tencent/biz/pubaccount/readinjoy/redpacket/RIJRedPacketManager;
    //   125: aload_0
    //   126: aload_2
    //   127: invokevirtual 425	com/tencent/biz/pubaccount/readinjoy/redpacket/RIJRedPacketManager:a	(Lorg/json/JSONObject;Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   130: astore 5
    //   132: aload 4
    //   134: ifnull +389 -> 523
    //   137: aload 4
    //   139: iload_1
    //   140: aload 5
    //   142: invokeinterface 428 3 0
    //   147: astore_0
    //   148: aload_0
    //   149: ifnonnull +371 -> 520
    //   152: aload_3
    //   153: ifnull +307 -> 460
    //   156: aload_3
    //   157: aload 5
    //   159: invokevirtual 432	sfq:getTemplateBean	(Lorg/json/JSONObject;)Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;
    //   162: astore_3
    //   163: aload_3
    //   164: astore_0
    //   165: aload_2
    //   166: aload_0
    //   167: putfield 412	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mProteusTemplateBean	Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;
    //   170: new 224	java/lang/StringBuilder
    //   173: dup
    //   174: invokespecial 225	java/lang/StringBuilder:<init>	()V
    //   177: ldc_w 434
    //   180: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: astore_3
    //   184: aload 5
    //   186: ifnull +279 -> 465
    //   189: new 224	java/lang/StringBuilder
    //   192: dup
    //   193: invokespecial 225	java/lang/StringBuilder:<init>	()V
    //   196: aload 5
    //   198: ldc_w 436
    //   201: invokevirtual 442	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   204: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: ldc_w 444
    //   210: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: aload 5
    //   215: invokevirtual 445	org/json/JSONObject:toString	()Ljava/lang/String;
    //   218: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: ldc_w 447
    //   224: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: invokevirtual 238	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   230: astore_2
    //   231: ldc 212
    //   233: iconst_2
    //   234: aload_3
    //   235: aload_2
    //   236: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: invokevirtual 238	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   242: invokestatic 217	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   245: ldc 212
    //   247: iconst_1
    //   248: new 224	java/lang/StringBuilder
    //   251: dup
    //   252: invokespecial 225	java/lang/StringBuilder:<init>	()V
    //   255: ldc_w 449
    //   258: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: aload 5
    //   263: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   266: invokevirtual 238	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   269: invokestatic 217	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   272: aload_0
    //   273: areturn
    //   274: iload_1
    //   275: lookupswitch	default:+97->372, 1:+113->388, 5:+105->380, 29:+129->404, 34:+153->428, 40:+169->444, 41:+177->452, 42:+161->436, 47:+137->412, 60:+145->420, 96:+145->420, 104:+121->396
    //   373: invokestatic 454	pkd:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   376: astore_0
    //   377: goto -255 -> 122
    //   380: aload_2
    //   381: invokestatic 457	pkh:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   384: astore_0
    //   385: goto -263 -> 122
    //   388: aload_2
    //   389: invokestatic 460	pkg:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   392: astore_0
    //   393: goto -271 -> 122
    //   396: aload_2
    //   397: invokestatic 463	pju:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   400: astore_0
    //   401: goto -279 -> 122
    //   404: aload_2
    //   405: invokestatic 466	pkf:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   408: astore_0
    //   409: goto -287 -> 122
    //   412: aload_2
    //   413: invokestatic 469	pjp:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   416: astore_0
    //   417: goto -295 -> 122
    //   420: aload_2
    //   421: invokestatic 472	pka:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   424: astore_0
    //   425: goto -303 -> 122
    //   428: aload_2
    //   429: invokestatic 475	pke:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   432: astore_0
    //   433: goto -311 -> 122
    //   436: aload_2
    //   437: invokestatic 478	pkj:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   440: astore_0
    //   441: goto -319 -> 122
    //   444: aload_2
    //   445: invokestatic 481	pki:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   448: astore_0
    //   449: goto -327 -> 122
    //   452: aload_2
    //   453: invokestatic 484	pkk:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   456: astore_0
    //   457: goto -335 -> 122
    //   460: aconst_null
    //   461: astore_0
    //   462: goto -297 -> 165
    //   465: ldc_w 304
    //   468: astore_2
    //   469: goto -238 -> 231
    //   472: astore_2
    //   473: aconst_null
    //   474: astore_0
    //   475: ldc 212
    //   477: iconst_1
    //   478: ldc_w 486
    //   481: aload_2
    //   482: invokestatic 490	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   485: goto -213 -> 272
    //   488: astore_2
    //   489: aconst_null
    //   490: astore_0
    //   491: ldc 212
    //   493: iconst_1
    //   494: ldc_w 492
    //   497: aload_2
    //   498: invokestatic 490	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   501: goto -229 -> 272
    //   504: astore_2
    //   505: goto -14 -> 491
    //   508: astore_2
    //   509: goto -18 -> 491
    //   512: astore_2
    //   513: goto -38 -> 475
    //   516: astore_2
    //   517: goto -42 -> 475
    //   520: goto -355 -> 165
    //   523: aconst_null
    //   524: astore_0
    //   525: goto -377 -> 148
    //   528: goto -503 -> 25
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	531	0	paramVafContext	VafContext
    //   0	531	1	paramInt	int
    //   0	531	2	paramBaseArticleInfo	BaseArticleInfo
    //   10	225	3	localObject	Object
    //   105	33	4	localpoa	poa
    //   130	132	5	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   67	90	472	org/json/JSONException
    //   90	107	472	org/json/JSONException
    //   112	122	472	org/json/JSONException
    //   122	132	472	org/json/JSONException
    //   137	148	472	org/json/JSONException
    //   372	377	472	org/json/JSONException
    //   380	385	472	org/json/JSONException
    //   388	393	472	org/json/JSONException
    //   396	401	472	org/json/JSONException
    //   404	409	472	org/json/JSONException
    //   412	417	472	org/json/JSONException
    //   420	425	472	org/json/JSONException
    //   428	433	472	org/json/JSONException
    //   436	441	472	org/json/JSONException
    //   444	449	472	org/json/JSONException
    //   452	457	472	org/json/JSONException
    //   67	90	488	java/lang/Exception
    //   90	107	488	java/lang/Exception
    //   112	122	488	java/lang/Exception
    //   122	132	488	java/lang/Exception
    //   137	148	488	java/lang/Exception
    //   372	377	488	java/lang/Exception
    //   380	385	488	java/lang/Exception
    //   388	393	488	java/lang/Exception
    //   396	401	488	java/lang/Exception
    //   404	409	488	java/lang/Exception
    //   412	417	488	java/lang/Exception
    //   420	425	488	java/lang/Exception
    //   428	433	488	java/lang/Exception
    //   436	441	488	java/lang/Exception
    //   444	449	488	java/lang/Exception
    //   452	457	488	java/lang/Exception
    //   156	163	504	java/lang/Exception
    //   165	184	508	java/lang/Exception
    //   189	231	508	java/lang/Exception
    //   231	272	508	java/lang/Exception
    //   156	163	512	org/json/JSONException
    //   165	184	516	org/json/JSONException
    //   189	231	516	org/json/JSONException
    //   231	272	516	org/json/JSONException
  }
  
  public static String a(BaseArticleInfo paramBaseArticleInfo)
  {
    String str = null;
    if (!qjz.a(paramBaseArticleInfo))
    {
      QLog.d("ProteusSupportUtil", 1, "UGRuleManager getUGSchema is not ugCard");
      return null;
    }
    int i = qjv.jdField_a_of_type_Int;
    qjv localqjv = qjv.a();
    boolean bool = localqjv.a(paramBaseArticleInfo, true, i);
    if (bool)
    {
      str = localqjv.a(paramBaseArticleInfo, i, null, null);
      QLog.d("ProteusSupportUtil", 1, "UGRuleManager getUGSchema ugUrl is " + str);
    }
    localqjv.a(paramBaseArticleInfo, bool, true, i);
    return str;
  }
  
  private static void a()
  {
    pqa.a("ProteusSupportUtil", "resetProteusSeparatorHeightPx ");
    QLog.d("TemplateFactory", 4, "resetProteusSeparatorHeightPx");
    jdField_a_of_type_Int = 0;
  }
  
  public static void a(int paramInt, Container paramContainer, VafContext paramVafContext, bcws parambcws, rqj paramrqj, pgd parampgd, BaseArticleInfo paramBaseArticleInfo)
  {
    ViewFactory.findClickableViewListener(paramContainer.getVirtualView(), new oqd(paramInt, paramContainer, parampgd, paramVafContext, parambcws, paramrqj, paramBaseArticleInfo));
  }
  
  private static void a(int paramInt1, Container paramContainer, pgd parampgd, int paramInt2)
  {
    bhxr.a("ProteusSupportUtil.bindView");
    if (paramContainer == null)
    {
      bhxr.a();
      return;
    }
    pqa.a("ProteusSupportUtil", "[bindView]");
    Object localObject = (poa)jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt1));
    if (localObject != null)
    {
      ((poa)localObject).a(paramInt1, paramContainer, parampgd, paramInt2);
      bhxr.a();
    }
    for (;;)
    {
      bhxr.a();
      return;
      paramContainer = paramContainer.getVirtualView();
      switch (paramInt1)
      {
      default: 
        break;
      case 10: 
        localObject = (pqg)paramContainer.findViewBaseByName("id_info_avator");
        if (localObject != null) {
          ((pqg)localObject).a(parampgd);
        }
        localObject = (pss)paramContainer.findViewBaseByName("id_summary");
        if (localObject != null) {
          ((pss)localObject).a(parampgd);
        }
        localObject = (pqi)paramContainer.findViewBaseByName("id_biu_comment");
        if (localObject != null) {
          ((pqi)localObject).a(parampgd);
        }
        paramContainer = (pqk)paramContainer.findViewBaseByName("id_corner_text_image");
        if (paramContainer != null) {
          paramContainer.a(parampgd);
        }
        break;
      case 34: 
      case 40: 
      case 41: 
      case 42: 
        localObject = (pqg)paramContainer.findViewBaseByName("id_info_avator");
        if (localObject != null) {
          ((pqg)localObject).a(parampgd);
        }
        localObject = (pss)paramContainer.findViewBaseByName("id_summary");
        if (localObject != null) {
          ((pss)localObject).a(parampgd);
        }
        localObject = (pqi)paramContainer.findViewBaseByName("id_biu_comment");
        if (localObject != null) {
          ((pqi)localObject).a(parampgd);
        }
        paramContainer = (pqm)paramContainer.findViewBaseByName("id_multi_image");
        if (paramContainer != null) {
          paramContainer.a(parampgd.a());
        }
        break;
      }
    }
  }
  
  private static void a(int paramInt, poa parampoa)
  {
    if (parampoa == null) {
      throw new NullPointerException();
    }
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), parampoa);
  }
  
  public static void a(ProteusItemView paramProteusItemView, int paramInt1, BaseArticleInfo paramBaseArticleInfo, VafContext paramVafContext, bcws parambcws, rqj paramrqj, pgd parampgd, int paramInt2, String paramString)
  {
    if (pqb.a())
    {
      pqb.a("ProteusSupportUtil", "[bindData]  adapterViewType: " + paramInt1);
      if (paramBaseArticleInfo != null) {
        pqb.a("ProteusSupportUtil", " reportViewType: " + ors.a(paramBaseArticleInfo));
      }
      pqb.a("ProteusSupportUtil", "[bindData] " + paramBaseArticleInfo);
    }
    pqa.a("ProteusSupportUtil", "[bindData] adapterViewType: " + paramInt1);
    bhxr.a("ProteusSupportUtil.bindData");
    long l1 = System.currentTimeMillis();
    if ((paramProteusItemView == null) || (paramProteusItemView.a() == null))
    {
      bhxr.a();
      return;
    }
    b(paramVafContext, paramString);
    Object localObject = paramProteusItemView.a();
    TemplateBean localTemplateBean = a(paramVafContext, paramInt1, paramBaseArticleInfo);
    int i;
    int j;
    if ((!a(paramProteusItemView.a(), paramInt1)) && ((localObject == null) || (localTemplateBean == null) || (localTemplateBean.getId() == ((TemplateBean)localObject).getId())))
    {
      paramString = (String)localObject;
      if (localObject != null)
      {
        paramString = (String)localObject;
        if (localTemplateBean != null)
        {
          paramString = (String)localObject;
          if (((TemplateBean)localObject).getStyleName() != null)
          {
            paramString = (String)localObject;
            if (localTemplateBean.getStyleName() != null)
            {
              paramString = (String)localObject;
              if (localTemplateBean.getStyleName().equals(((TemplateBean)localObject).getStyleName())) {}
            }
          }
        }
      }
    }
    else
    {
      if (localTemplateBean == null) {
        break label607;
      }
      i = localTemplateBean.getId();
      if (localObject == null) {
        break label613;
      }
      j = ((TemplateBean)localObject).getId();
      label279:
      QLog.i("ProteusSupportUtil", 1, "[bindData] trigger re-inflation, adapterViewType: " + paramInt1 + " new id: " + i + " old id: " + j);
      pqa.a("ProteusSupportUtil", "[bindData] trigger re-inflation, adapterViewType: " + paramInt1 + " new id: " + i + " old id: " + j);
      paramString = paramVafContext.getViewFactory().inflate(paramVafContext, localTemplateBean);
      if (paramString != null)
      {
        paramString.setBackgroundDrawable(paramVafContext.getContext().getResources().getDrawable(2130841380));
        paramProteusItemView.d();
        paramProteusItemView.a(paramString);
        pqb.a(paramString.getVirtualView(), "ProteusSupportUtil");
        pqb.a(paramString, "ProteusSupportUtil");
      }
      paramBaseArticleInfo.mProteusTemplateBean = localTemplateBean;
      a();
      paramString = null;
    }
    localObject = paramProteusItemView.a();
    paramProteusItemView.setTemplateBean(localTemplateBean);
    paramProteusItemView.setModel(parampgd, paramrqj.a());
    bhxr.a("ProteusSupportUtil.bindDataImpl");
    label521:
    long l2;
    if (localTemplateBean != null)
    {
      QLog.i("ProteusSupportUtil", 1, "[bindData] bind data for " + localTemplateBean.getStyleName());
      a((Container)localObject, paramString, localTemplateBean);
      bhxr.a();
      a(paramInt1, (Container)localObject, parampgd, paramInt2);
      a(paramInt1, (Container)localObject, paramVafContext, parambcws, paramrqj, parampgd, paramBaseArticleInfo);
      bhxr.a("ProteusSupportUtil.configDivider");
      a(parampgd, paramVafContext);
      a((Container)localObject, parampgd, localTemplateBean);
      bhxr.a();
      l2 = System.currentTimeMillis();
      if (localTemplateBean == null) {
        break label631;
      }
    }
    label607:
    label613:
    label631:
    for (paramProteusItemView = localTemplateBean.getStyleName();; paramProteusItemView = "")
    {
      srq.a("ProteusSupportUtil", paramProteusItemView, " ProteusSupportUtil.bindData", l2 - l1);
      bhxr.a();
      return;
      i = -1;
      break;
      j = -1;
      break label279;
      QLog.d("ProteusSupportUtil", 2, "[bindData] newTemplateBean is null");
      break label521;
    }
  }
  
  public static void a(ArticleInfo paramArticleInfo)
  {
    a(null, rqj.c(paramArticleInfo), paramArticleInfo);
  }
  
  public static void a(BaseArticleInfo paramBaseArticleInfo, TemplateBean paramTemplateBean, ViewBase paramViewBase)
  {
    if ((!(paramBaseArticleInfo instanceof ArticleInfo)) || (paramTemplateBean == null)) {
      return;
    }
    String str = szp.b(paramBaseArticleInfo.mChannelID);
    HashMap localHashMap = new HashMap();
    Map localMap = paramTemplateBean.getDataAttribute(null);
    paramTemplateBean = paramTemplateBean.getDataAttribute(paramViewBase.getViewId());
    if (localMap != null) {
      localHashMap.putAll(localMap);
    }
    if (paramTemplateBean != null) {
      localHashMap.putAll(paramTemplateBean);
    }
    swt.a((ArticleInfo)paramBaseArticleInfo, str, str, (int)paramBaseArticleInfo.mChannelID, localHashMap);
    swt.a(paramTemplateBean);
    bjxj.a(paramBaseArticleInfo);
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
    orz localorz = new orz();
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
          localorz.b(paramViewBase, localObject.toString());
        }
      }
    }
    nrt.a(null, "CliOper", "", "", str, str, 0, 0, "", "", "", localorz.a(), false);
  }
  
  public static void a(Container paramContainer, TemplateBean paramTemplateBean1, TemplateBean paramTemplateBean2)
  {
    bhxr.a("ProteusSupportUtil.bindDynamicValueWithoutRecursion");
    long l1 = System.currentTimeMillis();
    Map localMap1 = paramContainer.getViewIdMapping();
    Map localMap2 = paramTemplateBean2.getViewDataBinding();
    HashSet localHashSet = new HashSet();
    if (paramTemplateBean1 != null) {}
    for (paramContainer = paramTemplateBean1.getViewDataBinding();; paramContainer = null)
    {
      pqa.a("ProteusSupportUtil", "[bindDynamicValueWithoutRecursion] map");
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
          bhxr.a(paramTemplateBean1);
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
          bhxr.a("bindDynamicValueWithoutRecursion.bindDynamicVal.check");
          if ((str == null) || (paramTemplateBean1 == null) || (localViewBean == null) || ((localObject != null) && (localViewBean.valueBean.dynamicValue.equals(((ViewBean)localObject).valueBean.dynamicValue)))) {
            break label485;
          }
          i = 1;
          label262:
          bhxr.a();
          if (i == 0) {
            break label498;
          }
          if ("[ " + paramTemplateBean2 == null) {
            break label490;
          }
          localObject = paramTemplateBean2.getStyleName();
          label298:
          bhxr.a((String)localObject);
          localViewBean.setVisible(true);
          paramTemplateBean1.bindDynamicValue(localViewBean);
          QLog.d("ProteusSupportUtil", 1, "bindDynamicValueWithoutRecursion | [ viewId = " + str + " value changed ] newValue: " + localViewBean.valueBean.dynamicValue + "; cost " + (System.currentTimeMillis() - l2) + "ms");
          bhxr.a();
          if (QLog.isColorLevel()) {
            QLog.i("ProteusSupportUtil", 2, "[bindDynamicValueWithoutRecursion] bind dynamicValue: " + localViewBean.valueBean.dynamicValue + " viewId = " + str);
          }
        }
        for (;;)
        {
          if (paramTemplateBean1 != null) {
            paramTemplateBean1.setVisibility(0);
          }
          bhxr.a();
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
      pqa.a("ProteusSupportUtil", "[bindDynamicValueWithoutRecursion] recur");
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
        srq.a("ProteusSupportUtil", paramContainer, "bindDynamicValueWithoutRecursion", System.currentTimeMillis() - l1);
        if ("bindDynamicValueWithoutRecursion_____ " + paramTemplateBean2 == null) {
          break label732;
        }
      }
      label732:
      for (paramContainer = paramTemplateBean2.getStyleName();; paramContainer = " cost " + (System.currentTimeMillis() - l1) + "ms")
      {
        QLog.d("ProteusSupportUtil", 2, paramContainer);
        bhxr.a();
        return;
        paramContainer = "";
        break;
      }
    }
  }
  
  public static void a(Container paramContainer, VafContext paramVafContext, TemplateBean paramTemplateBean)
  {
    ViewFactory.findClickableViewListener(paramContainer.getVirtualView(), new opz(paramVafContext, paramTemplateBean));
  }
  
  public static void a(Container paramContainer, pgd parampgd, TemplateBean paramTemplateBean)
  {
    if (opm.a(paramContainer, parampgd)) {
      return;
    }
    ViewBase localViewBase1 = paramContainer.getVirtualView();
    ViewBase localViewBase2 = localViewBase1.findViewBaseByName("id_separator");
    ArticleInfo localArticleInfo = parampgd.a();
    if ((localArticleInfo == null) || (localViewBase2 == null))
    {
      QLog.d("ProteusSupportUtil", 1, "configDivider failed, articleInfo is null or divider is null.");
      return;
    }
    Layout.Params localParams = localViewBase2.getComLayoutParams();
    int m = localParams.mLayoutHeight;
    int j = Utils.dp2px(5.0D);
    double d = Utils.dp2px(6.0D);
    int i = parampgd.a();
    int k = parampgd.b();
    if (localArticleInfo.mChannelID == 70L)
    {
      bhxr.a("configDivider.FollowFeeds");
      localParams.mLayoutMarginLeft = 0;
      localParams.mLayoutMarginRight = 0;
      localParams.mLayoutWidth = -1;
      i = Utils.dp2px(5.0D);
      bhxr.a();
    }
    for (;;)
    {
      localParams.mLayoutHeight = i;
      localViewBase2.setComLayoutParams(localParams);
      parampgd = localViewBase1.getComLayoutParams();
      if (parampgd.mLayoutHeight >= 0) {
        parampgd.mLayoutHeight = (i - m + parampgd.mLayoutHeight);
      }
      parampgd = localViewBase1.getComLayoutParams();
      paramContainer.setLayoutParams(new RelativeLayout.LayoutParams(parampgd.mLayoutWidth, parampgd.mLayoutHeight));
      return;
      if (otf.c((int)localArticleInfo.mChannelID))
      {
        bhxr.a("configDivider.DailyFeeds");
        parampgd = parampgd.b();
        j = 0;
        k = 0;
        i = k;
        if (parampgd != null)
        {
          i = k;
          if (parampgd.mProteusTemplateBean != null)
          {
            if (parampgd.mProteusTemplateBean.getDataAttribute(null, "position_jump") == null) {
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
          bhxr.a();
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
      if ((i == 29) || (i == 30) || (k == 29) || (k == 30))
      {
        i = a(paramTemplateBean);
        localParams.mLayoutMarginLeft = 0;
        localParams.mLayoutMarginRight = 0;
        localParams.mLayoutWidth = -1;
      }
      else if ((a(parampgd.b())) || (a(parampgd)))
      {
        i = 0;
        localParams.mLayoutMarginLeft = 0;
        localParams.mLayoutMarginRight = 0;
        localParams.mLayoutWidth = -1;
      }
      else if (a(i, k))
      {
        bhxr.a("configDivider.normal");
        bhxr.a("configDivider.normal.getProteusSeparatorHeightPx");
        i = a(paramTemplateBean);
        bhxr.a();
        bhxr.a("configDivider.normal.getProteusSeparatorMarginLeftPx");
        d = a(paramTemplateBean);
        bhxr.a();
        j = Utils.dp2px(d);
        localParams.mLayoutMarginRight = j;
        localParams.mLayoutMarginLeft = j;
        localParams.mLayoutWidth = -1;
        bhxr.a();
      }
      else
      {
        localParams.mLayoutMarginLeft = 0;
        localParams.mLayoutMarginRight = 0;
        localParams.mLayoutWidth = -1;
        i = j;
        if (!b(k))
        {
          a(parampgd, localViewBase2);
          i = j;
        }
      }
    }
  }
  
  public static void a(VafContext paramVafContext, String paramString)
  {
    paramVafContext.setTemplateFactory(sfq.a(paramString, true));
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyLikeButton", new pri());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyAvatarView", new pqh());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyVariableImageContentView", new pqn());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoySummaryView", new pst());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyCommentView", new pqf());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyBiuCommentView", new pqj());
    paramVafContext.getViewFactory().registerViewBuilder("CornerTextImageView", new pql());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyMiddleBodyView", new pro());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyUsersCommentView", new psv());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyFriendsBiu", new prc());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyQARichView", new NativeText.Builder());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyBiuButton", new pqx());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyCoordinateView", new pra());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoySocializeRecommendFollowView", new psa());
    paramVafContext.getViewFactory().registerViewBuilder("UILabel", new psr());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInjoyAsynImageView", new psk());
    paramVafContext.getViewFactory().registerViewBuilder("UIImageView", new psk());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInjoyAsynImageIcon", new psi());
    paramVafContext.getViewFactory().registerViewBuilder("ProteusCollectionView", new pue());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyAdVideoGuide", new pqu());
    paramVafContext.getViewFactory().registerViewBuilder("PTSAvatarView", new oov());
    paramVafContext.getViewFactory().registerViewBuilder("QQAvatarView", new oov());
    paramVafContext.getViewFactory().registerViewBuilder("QQRIJCommentEmotioinLabel", new oox());
    paramVafContext.getViewFactory().registerViewBuilder("QQRIJRichTextView", new oox());
    paramVafContext.getViewFactory().registerViewBuilder("QQRIJCommentLikeButton", new ooz());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyExposeReplyCommentView", new opb());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyAwesomeCommentView", new pqw());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyAdDownloadView", new ofu());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyAdLocationView", new pqs());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyIconText", new ogm());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInjoyDoubleImageView", new ogv());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInjoyTripleImageInteractView", new ogx());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyAdInnerOperateView", new ofw());
    paramVafContext.getViewFactory().registerViewBuilder("ReadinjoyNativeArticleAdDownloadView", new ohc());
    paramVafContext.getViewFactory().registerViewBuilder("ProteusTickerView", new pqp());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInjoyShareView", new prq());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInjoyApngImageView", new psg());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyAdBrandOptimizationView", new ofs());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInjoyProgressView", new psn());
    a();
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyArticleBottomVideoView", new ogh());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyVideoView", new pse());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyGifView", new pre());
    paramVafContext.getViewFactory().registerViewBuilder("ProteusMarqueeLabel", new NativeText.Builder());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyLinkClickableLabel", new psr());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyLottieView", new prl());
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
      pqa.a("ProteusSupportUtil", "[bindDynamicValue]");
    }
  }
  
  private static void a(pgd parampgd, VafContext paramVafContext)
  {
    Object localObject = parampgd.a();
    if (localObject != null)
    {
      localObject = ((rqj)localObject).b(parampgd.g() + 1);
      if ((localObject != null) && (((BaseArticleInfo)localObject).mProteusTemplateBean == null))
      {
        QLog.d("ProteusSupportUtil", 2, "next.mProteusTemplateBean == null " + localObject);
        ((BaseArticleInfo)localObject).mProteusTemplateBean = a(paramVafContext, parampgd.b(), (BaseArticleInfo)localObject);
      }
    }
  }
  
  private static void a(pgd parampgd, ViewBase paramViewBase)
  {
    if ((parampgd != null) && (paramViewBase != null) && (paramViewBase.getNativeView() != null))
    {
      parampgd = parampgd.b();
      if ((parampgd != null) && (parampgd.mProteusTemplateBean != null))
      {
        parampgd = (ViewBean)parampgd.mProteusTemplateBean.getViewDataBinding().get("id_separator");
        if ((parampgd != null) && (parampgd.valueBean != null) && (parampgd.valueBean.normalValue != null))
        {
          parampgd = parampgd.valueBean.normalValue.get("setBackgroundColorString:");
          if (!(parampgd instanceof String)) {}
        }
      }
    }
    try
    {
      paramViewBase.getNativeView().setBackgroundColor(Color.parseColor((String)parampgd));
      return;
    }
    catch (Exception parampgd)
    {
      QLog.d("ProteusSupportUtil", 1, parampgd.getMessage());
    }
  }
  
  public static boolean a(int paramInt)
  {
    if (!opx.a()) {}
    do
    {
      return false;
      switch (paramInt)
      {
      }
    } while (odx.a(paramInt));
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
    bhxr.a("configDivider.isDividerNormal");
    if ((b(paramInt1)) && (b(paramInt2))) {}
    for (boolean bool = true;; bool = false)
    {
      bhxr.a();
      return bool;
    }
  }
  
  /* Error */
  public static boolean a(ArticleInfo paramArticleInfo)
  {
    // Byte code:
    //   0: ldc_w 1245
    //   3: invokestatic 134	bhxr:a	(Ljava/lang/String;)V
    //   6: aload_0
    //   7: ifnull +154 -> 161
    //   10: aload_0
    //   11: getfield 1248	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:proteusItemsData	Ljava/lang/String;
    //   14: invokestatic 716	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   17: ifne +144 -> 161
    //   20: aload_0
    //   21: getfield 1251	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mFeedType	I
    //   24: bipush 29
    //   26: if_icmpeq +8 -> 34
    //   29: invokestatic 148	bhxr:a	()V
    //   32: iconst_0
    //   33: ireturn
    //   34: new 438	org/json/JSONObject
    //   37: dup
    //   38: aload_0
    //   39: getfield 1248	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:proteusItemsData	Ljava/lang/String;
    //   42: invokespecial 1253	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   45: astore_0
    //   46: aload_0
    //   47: invokevirtual 1256	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   50: astore_2
    //   51: aload_2
    //   52: invokeinterface 752 1 0
    //   57: ifeq +104 -> 161
    //   60: aload_2
    //   61: invokeinterface 756 1 0
    //   66: checkcast 179	java/lang/String
    //   69: astore_3
    //   70: aload_0
    //   71: aload_3
    //   72: invokevirtual 1260	org/json/JSONObject:opt	(Ljava/lang/String;)Ljava/lang/Object;
    //   75: astore 4
    //   77: ldc_w 1262
    //   80: aload_3
    //   81: invokevirtual 624	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   84: ifeq -33 -> 51
    //   87: ldc 212
    //   89: iconst_1
    //   90: iconst_2
    //   91: anewarray 4	java/lang/Object
    //   94: dup
    //   95: iconst_0
    //   96: ldc_w 1264
    //   99: aastore
    //   100: dup
    //   101: iconst_1
    //   102: aload 4
    //   104: aastore
    //   105: invokestatic 207	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   108: invokestatic 148	bhxr:a	()V
    //   111: ldc_w 1266
    //   114: aload 4
    //   116: invokestatic 1269	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   119: invokevirtual 624	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   122: ifne +19 -> 141
    //   125: ldc_w 1271
    //   128: aload 4
    //   130: invokestatic 1269	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   133: invokevirtual 624	java/lang/String:equals	(Ljava/lang/Object;)Z
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
    //   151: ldc 212
    //   153: iconst_1
    //   154: ldc_w 1273
    //   157: aload_0
    //   158: invokestatic 1275	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   161: invokestatic 148	bhxr:a	()V
    //   164: iconst_0
    //   165: ireturn
    //   166: astore_0
    //   167: ldc 212
    //   169: iconst_1
    //   170: ldc_w 1277
    //   173: aload_0
    //   174: invokestatic 1275	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
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
              nrt.a(ors.a(), "CliOper", "", "", "0X8009AC1", "0X8009AC1", 0, 0, "", "", "", "", false);
              pqb.a(paramContainer.getVirtualView(), "ProteusSupportUtil");
              pqb.a(paramContainer, "ProteusSupportUtil");
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
    paramString = sfq.a(paramString, true);
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
  
  public static boolean a(pgd parampgd)
  {
    if (parampgd != null) {
      try
      {
        int i = parampgd.b();
        if ((i == 66) || (i == 39))
        {
          parampgd = parampgd.b();
          if ((parampgd != null) && (AdvertisementInfo.isAdvertisementInfo(parampgd)))
          {
            parampgd = ((AdvertisementInfo)parampgd).mAdExtInfo;
            if (parampgd != null)
            {
              i = new JSONObject(parampgd).optInt("is_video_new");
              return i == 1;
            }
          }
        }
      }
      catch (Exception parampgd)
      {
        QLog.d("ProteusSupportUtil", 1, "isNextCardAdBigImgOrAdVideo JSONException, e = ", parampgd);
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
        pqa.a("ProteusSupportUtil", "[getSepatatorHeight] getSepatatorHeight");
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
      orz localorz = new orz();
      Iterator localIterator = localJSONObject.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localorz.b(str, localJSONObject.get(str).toString());
      }
      nrt.a(null, "CliOper", "", "", paramViewBean, paramViewBean, 0, 0, "", "", "", localorz.a(), false);
    }
    catch (Exception paramViewBean)
    {
      QLog.d("ProteusSupportUtil", 1, paramViewBean, new Object[] { "" });
      return;
    }
  }
  
  private static void b(VafContext paramVafContext, String paramString)
  {
    paramString = sfq.a(paramString, false);
    if ((paramString != null) && (paramVafContext.getTemplateFactory() != paramString)) {
      paramVafContext.setTemplateFactory(paramString);
    }
  }
  
  private static boolean b(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 1) || (paramInt == 2) || (paramInt == 3) || (paramInt == 5) || (paramInt == 47) || (paramInt == 60) || (paramInt == 39) || (paramInt == 66) || (paramInt == 50) || (paramInt == 51) || (paramInt == 52) || (paramInt == 53) || (paramInt == 96) || (paramInt == 103) || (paramInt == 102) || (paramInt == 101) || (paramInt == 104) || (paramInt == 105) || (paramInt == 106) || (paramInt == 116) || (paramInt == 122) || (paramInt == 117) || (paramInt >= 140) || (paramInt == 121) || (paramInt == 126) || (paramInt == 115) || (paramInt == 124) || (paramInt == 125) || (paramInt == 127) || (paramInt == 129) || (paramInt == 130) || (paramInt == 136) || (paramInt == 46);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     opy
 * JD-Core Version:    0.7.0.1
 */