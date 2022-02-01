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
import com.tencent.mobileqq.app.QQAppInterface;
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

public class pfr
{
  private static double jdField_a_of_type_Double;
  private static int jdField_a_of_type_Int;
  private static final Map<Integer, qft> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  static
  {
    if (jdField_a_of_type_JavaUtilMap.isEmpty())
    {
      a(3, new qgc());
      a(72, new qcf());
      a(73, new qcl());
      a(74, new qfx());
      a(90, new qfw());
      a(91, new qfw());
      a(75, new qfx());
      a(21, new qge());
      a(22, new qge());
      a(36, new qge());
      a(23, new qge());
      a(120, new qge());
      a(80, new qge());
      a(34, new qet());
      a(16, new qet());
      a(17, new qet());
      a(19, new qet());
      a(18, new qet());
      a(20, new qet());
      a(65, new qet());
      a(64, new qet());
      a(48, new qet());
      a(25, new qcw());
      a(24, new qcw());
      a(26, new qcw());
      a(107, new qge());
      a(108, new qcw());
      a(37, new qcw());
      a(81, new qcw());
      a(35, new qco());
      a(12, new qco());
      a(10, new qco());
      a(11, new qco());
      a(28, new qco());
      a(27, new qco());
      a(49, new qco());
      a(62, new qco());
      a(63, new qco());
      a(33, new qco());
      a(31, new qet());
      a(32, new qet());
      a(79, new qeq());
      a(76, new qeq());
      a(77, new qeq());
      a(78, new qeq());
      a(83, new qet());
      a(84, new qet());
      a(85, new qet());
      a(86, new qet());
      a(89, new qce());
      a(92, new qcw());
      a(94, new qco());
      a(95, new qco());
      a(101, new qdw());
      a(102, new qdw());
      a(103, new qdw());
      a(105, new opf());
      a(66, new oov());
      a(115, new oov());
      a(39, new oou());
      a(116, new oox());
      a(117, new ope());
      a(106, new opd());
      a(140, new ooz());
      a(146, new ooy());
      a(141, new opc());
      a(143, new opc());
      a(144, new opb());
      a(145, new opa());
      a(109, new qfa());
      a(110, new qfa());
      a(111, new qfa());
      a(132, new qfa());
      a(133, new qfa());
      a(134, new qfa());
      a(112, new qco());
      a(113, new qco());
      a(114, new qco());
      a(126, new qcj());
      a(2, new qci());
      a(1, new qga());
      a(121, new qdn());
      a(122, new oou());
      a(124, new qec());
      a(125, new qec());
      a(127, new oow());
      a(129, new qeb());
      a(130, new qea());
      a(131, new qeh());
      a(46, new qdp());
      a(123, new qel());
      a(135, new qdy());
      a(137, new qdi());
      a(139, new qdi());
      a(138, new qdi());
      a(142, new qda());
    }
  }
  
  private static double a(TemplateBean paramTemplateBean)
  {
    bkpj.a("getProteusSeparatorMarginLeftPx");
    if ((jdField_a_of_type_Double > 0.0D) && (paramTemplateBean != null))
    {
      teh localteh = teh.a("default_feeds", false);
      if ((localteh != null) && (!localteh.a(paramTemplateBean)))
      {
        bkpj.a();
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
    bkpj.a();
    return jdField_a_of_type_Double;
  }
  
  private static int a(TemplateBean paramTemplateBean)
  {
    bkpj.a("getProteusSeparatorHeightPx");
    if ((jdField_a_of_type_Int > 0) && (paramTemplateBean != null))
    {
      localteh = teh.a("default_feeds", false);
      if ((localteh != null) && (!localteh.a(paramTemplateBean)))
      {
        bkpj.a();
        qhy.a("ProteusSupportUtil", "[getProteusSeparatorHeightPx] SeparatorHeight : " + jdField_a_of_type_Int);
        return jdField_a_of_type_Int;
      }
    }
    teh localteh = teh.a("default_feeds", false);
    paramTemplateBean = null;
    if (localteh != null) {
      paramTemplateBean = localteh.getTemplate("ReadInjoy_triple_img_cell");
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
        qhy.a("ProteusSupportUtil", "[getProteusSeparatorHeightPx] getSeparatorHeightPx");
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
      bkpj.a();
      return jdField_a_of_type_Int;
      jdField_a_of_type_Int = Utils.dp2px(0.5D);
    }
  }
  
  public static ProteusItemView a(VafContext paramVafContext, int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    if (qhz.a()) {
      qhz.a("ProteusSupportUtil", "[getView] " + paramBaseArticleInfo + " adapterViewType: " + paramInt);
    }
    long l1 = System.currentTimeMillis();
    bkpj.a("ProteusSupportUtil.getView");
    bkpj.a("ProteusSupportUtil#getView#getTemplateBean");
    TemplateBean localTemplateBean = a(paramVafContext, paramInt, paramBaseArticleInfo);
    bkpj.a();
    String str;
    if (localTemplateBean != null)
    {
      str = "[" + localTemplateBean.getStyleName() + "]";
      paramBaseArticleInfo = null;
      if ((!(paramVafContext.getTemplateFactory() instanceof teh)) || (localTemplateBean == null)) {
        break label453;
      }
    }
    label256:
    label436:
    label443:
    label453:
    for (Object localObject = pfp.a.a(((teh)paramVafContext.getTemplateFactory()).b(), localTemplateBean.getStyleName());; localObject = null)
    {
      if (localObject == null)
      {
        bkpj.a(str + "#inflate");
        localObject = paramVafContext.getViewFactory().inflate(paramVafContext, localTemplateBean);
        qhy.a("ProteusSupportUtil", "[getView] inflate");
        bkpj.a();
      }
      for (;;)
      {
        label240:
        long l2;
        if (localObject != null)
        {
          bkpj.a(str + "#setBackgroundDrawable");
          if ((pha.r()) && (bmqa.j()))
          {
            paramInt = 1;
            paramBaseArticleInfo = paramVafContext.getContext().getResources();
            if (paramInt == 0) {
              break label436;
            }
            paramInt = 2130841682;
            ((Container)localObject).setBackgroundDrawable(paramBaseArticleInfo.getDrawable(paramInt));
            paramBaseArticleInfo = new ProteusItemView(paramVafContext.getContext());
            paramBaseArticleInfo.a((Container)localObject);
            bkpj.a();
            qhy.a("ProteusSupportUtil", "[getView]  add Container ");
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            qhz.a((View)localObject, "ProteusSupportUtil");
          }
          l2 = System.currentTimeMillis();
          if (localTemplateBean == null) {
            break label443;
          }
        }
        for (paramVafContext = localTemplateBean.getStyleName();; paramVafContext = "templateBean is null")
        {
          ttf.a("ProteusSupportUtil", paramVafContext, "ProteusSupportUtil.getView", l2 - l1);
          bkpj.a();
          return paramBaseArticleInfo;
          qhy.a("ProteusSupportUtil", "[getView]  new proteusItemView ");
          localObject = new ProteusItemView(paramVafContext.getContext());
          ((ProteusItemView)localObject).setVisibility(8);
          QLog.i("ProteusSupportUtil", 1, "[getView] 未找到样式,请确认是否下发该卡片的样式:" + paramBaseArticleInfo + " adapterViewType: " + paramInt + "  " + paramVafContext.getTemplateFactory());
          paramBaseArticleInfo = (BaseArticleInfo)localObject;
          str = "";
          break;
          paramInt = 0;
          break label240;
          paramInt = 2130841683;
          break label256;
        }
      }
    }
  }
  
  /* Error */
  public static TemplateBean a(VafContext paramVafContext, int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +16 -> 17
    //   4: ldc 156
    //   6: iconst_0
    //   7: invokestatic 161	teh:a	(Ljava/lang/String;Z)Lteh;
    //   10: astore_3
    //   11: aload_3
    //   12: ifnonnull +516 -> 528
    //   15: aconst_null
    //   16: areturn
    //   17: aload_0
    //   18: invokevirtual 333	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/VafContext:getTemplateFactory	()Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/factory/BaseTemplateFactory;
    //   21: checkcast 158	teh
    //   24: astore_3
    //   25: invokestatic 212	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   28: ifeq +39 -> 67
    //   31: ldc 230
    //   33: iconst_2
    //   34: new 242	java/lang/StringBuilder
    //   37: dup
    //   38: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   41: ldc_w 433
    //   44: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: aload_2
    //   48: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   51: ldc_w 435
    //   54: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: iload_1
    //   58: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   61: invokevirtual 256	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: invokestatic 235	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   67: aload_2
    //   68: getfield 441	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mProteusTemplateBean	Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;
    //   71: ifnull +19 -> 90
    //   74: aload_3
    //   75: aload_2
    //   76: getfield 441	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mProteusTemplateBean	Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;
    //   79: invokevirtual 164	teh:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;)Z
    //   82: ifne +8 -> 90
    //   85: aload_2
    //   86: getfield 441	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mProteusTemplateBean	Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;
    //   89: areturn
    //   90: getstatic 18	pfr:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   93: iload_1
    //   94: invokestatic 284	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   97: invokeinterface 195 2 0
    //   102: checkcast 443	qft
    //   105: astore 4
    //   107: aload 4
    //   109: ifnull +165 -> 274
    //   112: aload 4
    //   114: iload_1
    //   115: aload_2
    //   116: invokeinterface 446 3 0
    //   121: astore_0
    //   122: invokestatic 451	com/tencent/biz/pubaccount/readinjoy/redpacket/RIJRedPacketManager:a	()Lcom/tencent/biz/pubaccount/readinjoy/redpacket/RIJRedPacketManager;
    //   125: aload_0
    //   126: aload_2
    //   127: invokevirtual 454	com/tencent/biz/pubaccount/readinjoy/redpacket/RIJRedPacketManager:a	(Lorg/json/JSONObject;Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   130: astore 5
    //   132: aload 4
    //   134: ifnull +389 -> 523
    //   137: aload 4
    //   139: iload_1
    //   140: aload 5
    //   142: invokeinterface 457 3 0
    //   147: astore_0
    //   148: aload_0
    //   149: ifnonnull +371 -> 520
    //   152: aload_3
    //   153: ifnull +307 -> 460
    //   156: aload_3
    //   157: aload 5
    //   159: invokevirtual 461	teh:getTemplateBean	(Lorg/json/JSONObject;)Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;
    //   162: astore_3
    //   163: aload_3
    //   164: astore_0
    //   165: aload_2
    //   166: aload_0
    //   167: putfield 441	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mProteusTemplateBean	Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;
    //   170: new 242	java/lang/StringBuilder
    //   173: dup
    //   174: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   177: ldc_w 463
    //   180: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: astore_3
    //   184: aload 5
    //   186: ifnull +279 -> 465
    //   189: new 242	java/lang/StringBuilder
    //   192: dup
    //   193: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   196: aload 5
    //   198: ldc_w 465
    //   201: invokevirtual 471	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   204: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: ldc_w 473
    //   210: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: aload 5
    //   215: invokevirtual 474	org/json/JSONObject:toString	()Ljava/lang/String;
    //   218: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: ldc_w 476
    //   224: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: invokevirtual 256	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   230: astore_2
    //   231: ldc 230
    //   233: iconst_2
    //   234: aload_3
    //   235: aload_2
    //   236: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: invokevirtual 256	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   242: invokestatic 235	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   245: ldc 230
    //   247: iconst_1
    //   248: new 242	java/lang/StringBuilder
    //   251: dup
    //   252: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   255: ldc_w 478
    //   258: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: aload 5
    //   263: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   266: invokevirtual 256	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   269: invokestatic 235	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   272: aload_0
    //   273: areturn
    //   274: iload_1
    //   275: lookupswitch	default:+97->372, 1:+113->388, 5:+105->380, 29:+129->404, 34:+153->428, 40:+169->444, 41:+177->452, 42:+161->436, 47:+137->412, 60:+145->420, 96:+145->420, 104:+121->396
    //   373: invokestatic 483	qbx:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   376: astore_0
    //   377: goto -255 -> 122
    //   380: aload_2
    //   381: invokestatic 486	qbp:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   384: astore_0
    //   385: goto -263 -> 122
    //   388: aload_2
    //   389: invokestatic 489	qbo:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   392: astore_0
    //   393: goto -271 -> 122
    //   396: aload_2
    //   397: invokestatic 492	qbf:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   400: astore_0
    //   401: goto -279 -> 122
    //   404: aload_2
    //   405: invokestatic 495	qbn:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   408: astore_0
    //   409: goto -287 -> 122
    //   412: aload_2
    //   413: invokestatic 498	qbh:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   416: astore_0
    //   417: goto -295 -> 122
    //   420: aload_2
    //   421: invokestatic 501	qbw:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   424: astore_0
    //   425: goto -303 -> 122
    //   428: aload_2
    //   429: invokestatic 504	qby:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   432: astore_0
    //   433: goto -311 -> 122
    //   436: aload_2
    //   437: invokestatic 507	qca:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   440: astore_0
    //   441: goto -319 -> 122
    //   444: aload_2
    //   445: invokestatic 510	qbz:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   448: astore_0
    //   449: goto -327 -> 122
    //   452: aload_2
    //   453: invokestatic 513	qcb:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   456: astore_0
    //   457: goto -335 -> 122
    //   460: aconst_null
    //   461: astore_0
    //   462: goto -297 -> 165
    //   465: ldc_w 426
    //   468: astore_2
    //   469: goto -238 -> 231
    //   472: astore_2
    //   473: aconst_null
    //   474: astore_0
    //   475: ldc 230
    //   477: iconst_1
    //   478: ldc_w 515
    //   481: aload_2
    //   482: invokestatic 519	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   485: goto -213 -> 272
    //   488: astore_2
    //   489: aconst_null
    //   490: astore_0
    //   491: ldc 230
    //   493: iconst_1
    //   494: ldc_w 521
    //   497: aload_2
    //   498: invokestatic 519	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
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
    //   105	33	4	localqft	qft
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
    if (!rec.c(paramBaseArticleInfo))
    {
      QLog.d("ProteusSupportUtil", 1, "UGRuleManager getUGSchema is not ugCard");
      return null;
    }
    int i = rdy.jdField_a_of_type_Int;
    rdy localrdy = rdy.a();
    boolean bool = localrdy.a(paramBaseArticleInfo, true, i);
    if (bool)
    {
      str = localrdy.a(paramBaseArticleInfo, i, null, null);
      QLog.d("ProteusSupportUtil", 1, "UGRuleManager getUGSchema ugUrl is " + str);
    }
    localrdy.a(paramBaseArticleInfo, bool, true, i);
    return str;
  }
  
  private static void a()
  {
    qhy.a("ProteusSupportUtil", "resetProteusSeparatorHeightPx ");
    QLog.d("TemplateFactory", 4, "resetProteusSeparatorHeightPx");
    jdField_a_of_type_Int = 0;
  }
  
  public static void a(int paramInt, ProteusItemView paramProteusItemView, VafContext paramVafContext, aobu paramaobu, snh paramsnh, pxk parampxk, BaseArticleInfo paramBaseArticleInfo)
  {
    Container localContainer = paramProteusItemView.a();
    ViewFactory.findClickableViewListener(localContainer.getVirtualView(), new pfw(paramInt, localContainer, parampxk, paramBaseArticleInfo, paramVafContext, paramProteusItemView, paramaobu, paramsnh));
  }
  
  private static void a(int paramInt1, Container paramContainer, pxk parampxk, int paramInt2)
  {
    bkpj.a("ProteusSupportUtil.bindView");
    if (paramContainer == null)
    {
      bkpj.a();
      return;
    }
    qhy.a("ProteusSupportUtil", "[bindView]");
    Object localObject = (qft)jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt1));
    if (localObject != null)
    {
      ((qft)localObject).a(paramInt1, paramContainer, parampxk, paramInt2);
      bkpj.a();
    }
    for (;;)
    {
      bkpj.a();
      return;
      paramContainer = paramContainer.getVirtualView();
      switch (paramInt1)
      {
      default: 
        break;
      case 10: 
        localObject = (qij)paramContainer.findViewBaseByName("id_info_avator");
        if (localObject != null) {
          ((qij)localObject).a(parampxk);
        }
        localObject = (qku)paramContainer.findViewBaseByName("id_summary");
        if (localObject != null) {
          ((qku)localObject).a(parampxk);
        }
        localObject = (qil)paramContainer.findViewBaseByName("id_biu_comment");
        if (localObject != null) {
          ((qil)localObject).a(parampxk);
        }
        paramContainer = (qin)paramContainer.findViewBaseByName("id_corner_text_image");
        if (paramContainer != null) {
          paramContainer.a(parampxk);
        }
        break;
      case 34: 
      case 40: 
      case 41: 
      case 42: 
        localObject = (qij)paramContainer.findViewBaseByName("id_info_avator");
        if (localObject != null) {
          ((qij)localObject).a(parampxk);
        }
        localObject = (qku)paramContainer.findViewBaseByName("id_summary");
        if (localObject != null) {
          ((qku)localObject).a(parampxk);
        }
        localObject = (qil)paramContainer.findViewBaseByName("id_biu_comment");
        if (localObject != null) {
          ((qil)localObject).a(parampxk);
        }
        paramContainer = (qip)paramContainer.findViewBaseByName("id_multi_image");
        if (paramContainer != null) {
          paramContainer.a(parampxk.a());
        }
        break;
      }
    }
  }
  
  private static void a(int paramInt, qft paramqft)
  {
    if (paramqft == null) {
      throw new NullPointerException();
    }
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), paramqft);
  }
  
  public static void a(ProteusItemView paramProteusItemView, int paramInt1, BaseArticleInfo paramBaseArticleInfo, VafContext paramVafContext, aobu paramaobu, snh paramsnh, pxk parampxk, int paramInt2, String paramString)
  {
    if (qhz.a())
    {
      qhz.a("ProteusSupportUtil", "[bindData]  adapterViewType: " + paramInt1);
      if (paramBaseArticleInfo != null) {
        qhz.a("ProteusSupportUtil", " reportViewType: " + pha.a(paramBaseArticleInfo));
      }
      qhz.a("ProteusSupportUtil", "[bindData] " + paramBaseArticleInfo);
    }
    qhy.a("ProteusSupportUtil", "[bindData] adapterViewType: " + paramInt1);
    bkpj.a("ProteusSupportUtil.bindData");
    long l1 = System.currentTimeMillis();
    if ((paramProteusItemView == null) || (paramProteusItemView.a() == null))
    {
      bkpj.a();
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
        break label614;
      }
      i = localTemplateBean.getId();
      if (localObject == null) {
        break label620;
      }
      j = ((TemplateBean)localObject).getId();
      label279:
      QLog.i("ProteusSupportUtil", 1, "[bindData] trigger re-inflation, adapterViewType: " + paramInt1 + " new id: " + i + " old id: " + j);
      qhy.a("ProteusSupportUtil", "[bindData] trigger re-inflation, adapterViewType: " + paramInt1 + " new id: " + i + " old id: " + j);
      paramString = paramVafContext.getViewFactory().inflate(paramVafContext, localTemplateBean);
      if (paramString != null)
      {
        paramString.setBackgroundDrawable(paramVafContext.getContext().getResources().getDrawable(2130841683));
        paramProteusItemView.d();
        paramProteusItemView.a(paramString);
        qhz.a(paramString.getVirtualView(), "ProteusSupportUtil");
        qhz.a(paramString, "ProteusSupportUtil");
      }
      paramBaseArticleInfo.mProteusTemplateBean = localTemplateBean;
      a();
      paramString = null;
    }
    oqp.a(paramBaseArticleInfo, localTemplateBean, paramInt2);
    localObject = paramProteusItemView.a();
    paramProteusItemView.setTemplateBean(localTemplateBean);
    paramProteusItemView.setModel(parampxk, paramsnh.a());
    bkpj.a("ProteusSupportUtil.bindDataImpl");
    label529:
    long l2;
    if (localTemplateBean != null)
    {
      QLog.i("ProteusSupportUtil", 1, "[bindData] bind data for " + localTemplateBean.getStyleName());
      a((Container)localObject, paramString, localTemplateBean);
      bkpj.a();
      a(paramInt1, (Container)localObject, parampxk, paramInt2);
      a(paramInt1, paramProteusItemView, paramVafContext, paramaobu, paramsnh, parampxk, paramBaseArticleInfo);
      bkpj.a("ProteusSupportUtil.configDivider");
      a(parampxk, paramVafContext);
      a((Container)localObject, parampxk, localTemplateBean);
      bkpj.a();
      l2 = System.currentTimeMillis();
      if (localTemplateBean == null) {
        break label638;
      }
    }
    label614:
    label620:
    label638:
    for (paramProteusItemView = localTemplateBean.getStyleName();; paramProteusItemView = "")
    {
      ttf.a("ProteusSupportUtil", paramProteusItemView, " ProteusSupportUtil.bindData", l2 - l1);
      bkpj.a();
      return;
      i = -1;
      break;
      j = -1;
      break label279;
      QLog.d("ProteusSupportUtil", 2, "[bindData] newTemplateBean is null");
      break label529;
    }
  }
  
  public static void a(ArticleInfo paramArticleInfo)
  {
    a(null, snh.c(paramArticleInfo), paramArticleInfo);
  }
  
  public static void a(BaseArticleInfo paramBaseArticleInfo, TemplateBean paramTemplateBean, ViewBase paramViewBase)
  {
    if ((!(paramBaseArticleInfo instanceof ArticleInfo)) || (paramTemplateBean == null)) {
      return;
    }
    String str = ube.b(paramBaseArticleInfo.mChannelID);
    HashMap localHashMap = new HashMap();
    Map localMap = paramTemplateBean.getDataAttribute(null);
    paramTemplateBean = paramTemplateBean.getDataAttribute(paramViewBase.getViewId());
    if (localMap != null) {
      localHashMap.putAll(localMap);
    }
    if (paramTemplateBean != null) {
      localHashMap.putAll(paramTemplateBean);
    }
    tyb.a((ArticleInfo)paramBaseArticleInfo, str, str, (int)paramBaseArticleInfo.mChannelID, localHashMap);
    tyb.a(paramTemplateBean);
    bmqa.a(paramBaseArticleInfo);
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
    phi localphi = new phi();
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
          localphi.b(paramViewBase, localObject.toString());
        }
      }
    }
    oat.a(null, "CliOper", "", "", str, str, 0, 0, "", "", "", localphi.a(), false);
  }
  
  protected static void a(ViewBean paramViewBean)
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
      phi localphi = new phi();
      Iterator localIterator = localJSONObject.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localphi.b(str, localJSONObject.get(str).toString());
      }
      oat.a(null, "CliOper", "", "", paramViewBean, paramViewBean, 0, 0, "", "", "", localphi.a(), false);
    }
    catch (Exception paramViewBean)
    {
      QLog.d("ProteusSupportUtil", 1, paramViewBean, new Object[] { "" });
      return;
    }
  }
  
  public static void a(Container paramContainer, TemplateBean paramTemplateBean1, TemplateBean paramTemplateBean2)
  {
    bkpj.a("ProteusSupportUtil.bindDynamicValueWithoutRecursion");
    long l1 = System.currentTimeMillis();
    Map localMap1 = paramContainer.getViewIdMapping();
    Map localMap2 = paramTemplateBean2.getViewDataBinding();
    HashSet localHashSet = new HashSet();
    if (paramTemplateBean1 != null) {}
    for (paramContainer = paramTemplateBean1.getViewDataBinding();; paramContainer = null)
    {
      qhy.a("ProteusSupportUtil", "[bindDynamicValueWithoutRecursion] map");
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
          bkpj.a(paramTemplateBean1);
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
          bkpj.a("bindDynamicValueWithoutRecursion.bindDynamicVal.check");
          if ((str == null) || (paramTemplateBean1 == null) || (localViewBean == null) || ((localObject != null) && (localViewBean.valueBean.dynamicValue.equals(((ViewBean)localObject).valueBean.dynamicValue)))) {
            break label485;
          }
          i = 1;
          label262:
          bkpj.a();
          if (i == 0) {
            break label498;
          }
          if ("[ " + paramTemplateBean2 == null) {
            break label490;
          }
          localObject = paramTemplateBean2.getStyleName();
          label298:
          bkpj.a((String)localObject);
          localViewBean.setVisible(true);
          paramTemplateBean1.bindDynamicValue(localViewBean);
          QLog.d("ProteusSupportUtil", 1, "bindDynamicValueWithoutRecursion | [ viewId = " + str + " value changed ] newValue: " + localViewBean.valueBean.dynamicValue + "; cost " + (System.currentTimeMillis() - l2) + "ms");
          bkpj.a();
          if (QLog.isColorLevel()) {
            QLog.i("ProteusSupportUtil", 2, "[bindDynamicValueWithoutRecursion] bind dynamicValue: " + localViewBean.valueBean.dynamicValue + " viewId = " + str);
          }
        }
        for (;;)
        {
          if (paramTemplateBean1 != null) {
            paramTemplateBean1.setVisibility(0);
          }
          bkpj.a();
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
      qhy.a("ProteusSupportUtil", "[bindDynamicValueWithoutRecursion] recur");
      if (localHashSet != null)
      {
        paramContainer = localHashSet.iterator();
        while (paramContainer.hasNext())
        {
          paramTemplateBean1 = (ViewBase)localMap1.get((String)paramContainer.next());
          if (paramTemplateBean1 != null) {
            paramTemplateBean1.setVisibility(8);
          }
        }
      }
      if (paramTemplateBean2 != null)
      {
        paramContainer = paramTemplateBean2.getStyleName();
        ttf.a("ProteusSupportUtil", paramContainer, "bindDynamicValueWithoutRecursion", System.currentTimeMillis() - l1);
        if ("bindDynamicValueWithoutRecursion_____ " + paramTemplateBean2 == null) {
          break label738;
        }
      }
      label738:
      for (paramContainer = paramTemplateBean2.getStyleName();; paramContainer = " cost " + (System.currentTimeMillis() - l1) + "ms")
      {
        QLog.d("ProteusSupportUtil", 2, paramContainer);
        bkpj.a();
        return;
        paramContainer = "";
        break;
      }
    }
  }
  
  public static void a(Container paramContainer, VafContext paramVafContext, TemplateBean paramTemplateBean)
  {
    ViewFactory.findClickableViewListener(paramContainer.getVirtualView(), new pfs(paramVafContext, paramTemplateBean));
  }
  
  public static void a(Container paramContainer, pxk parampxk, TemplateBean paramTemplateBean)
  {
    if (pfd.a(paramContainer, parampxk)) {
      return;
    }
    ViewBase localViewBase1 = paramContainer.getVirtualView();
    ViewBase localViewBase2 = localViewBase1.findViewBaseByName("id_separator");
    ArticleInfo localArticleInfo = parampxk.a();
    if ((localArticleInfo == null) || (localViewBase2 == null))
    {
      QLog.d("ProteusSupportUtil", 1, "configDivider failed, articleInfo is null or divider is null.");
      return;
    }
    Layout.Params localParams = localViewBase2.getComLayoutParams();
    int m = localParams.mLayoutHeight;
    int j = Utils.dp2px(5.0D);
    double d = Utils.dp2px(6.0D);
    int i = parampxk.a();
    int k = parampxk.b();
    if (localArticleInfo.mChannelID == 70L)
    {
      bkpj.a("configDivider.FollowFeeds");
      localParams.mLayoutMarginLeft = 0;
      localParams.mLayoutMarginRight = 0;
      localParams.mLayoutWidth = -1;
      i = Utils.dp2px(5.0D);
      bkpj.a();
    }
    for (;;)
    {
      localParams.mLayoutHeight = i;
      localViewBase2.setComLayoutParams(localParams);
      parampxk = localViewBase1.getComLayoutParams();
      if (parampxk.mLayoutHeight >= 0) {
        parampxk.mLayoutHeight = (i - m + parampxk.mLayoutHeight);
      }
      parampxk = localViewBase1.getComLayoutParams();
      paramContainer.setLayoutParams(new RelativeLayout.LayoutParams(parampxk.mLayoutWidth, parampxk.mLayoutHeight));
      return;
      if (pil.c((int)localArticleInfo.mChannelID))
      {
        bkpj.a("configDivider.DailyFeeds");
        parampxk = parampxk.b();
        j = 0;
        k = 0;
        i = k;
        if (parampxk != null)
        {
          i = k;
          if (parampxk.mProteusTemplateBean != null)
          {
            if (parampxk.mProteusTemplateBean.getDataAttribute(null, "position_jump") == null) {
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
          bkpj.a();
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
      else if ((a(parampxk.b())) || (a(parampxk)))
      {
        i = 0;
        localParams.mLayoutMarginLeft = 0;
        localParams.mLayoutMarginRight = 0;
        localParams.mLayoutWidth = -1;
      }
      else if (a(i, k, parampxk.b()))
      {
        bkpj.a("configDivider.normal");
        bkpj.a("configDivider.normal.getProteusSeparatorHeightPx");
        i = a(paramTemplateBean);
        bkpj.a();
        bkpj.a("configDivider.normal.getProteusSeparatorMarginLeftPx");
        d = a(paramTemplateBean);
        bkpj.a();
        j = Utils.dp2px(d);
        localParams.mLayoutMarginRight = j;
        localParams.mLayoutMarginLeft = j;
        localParams.mLayoutWidth = -1;
        bkpj.a();
      }
      else
      {
        localParams.mLayoutMarginLeft = 0;
        localParams.mLayoutMarginRight = 0;
        localParams.mLayoutWidth = -1;
        i = j;
        if (!b(k))
        {
          a(parampxk, localViewBase2);
          i = j;
        }
      }
    }
  }
  
  public static void a(VafContext paramVafContext, String paramString)
  {
    paramVafContext.setTemplateFactory(teh.a(paramString, true));
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyLikeButton", new qjl());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyAvatarView", new qik());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyVariableImageContentView", new qiq());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoySummaryView", new qkv());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyCommentView", new qii());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyBiuCommentView", new qim());
    paramVafContext.getViewFactory().registerViewBuilder("CornerTextImageView", new qio());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyMiddleBodyView", new qjq());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyUsersCommentView", new qkx());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyFriendsBiu", new qjf());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyQARichView", new NativeText.Builder());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyBiuButton", new qja());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyCoordinateView", new qjd());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoySocializeRecommendFollowView", new qkc());
    paramVafContext.getViewFactory().registerViewBuilder("UILabel", new qkt());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInjoyAsynImageView", new qkm());
    paramVafContext.getViewFactory().registerViewBuilder("UIImageView", new qkm());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInjoyAsynImageIcon", new qkk());
    paramVafContext.getViewFactory().registerViewBuilder("ProteusCollectionView", new qmg());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyAdVideoGuide", new qix());
    paramVafContext.getViewFactory().registerViewBuilder("PTSAvatarView", new pec());
    paramVafContext.getViewFactory().registerViewBuilder("QQAvatarView", new pec());
    paramVafContext.getViewFactory().registerViewBuilder("RIJCommentRichTextView", new pek());
    paramVafContext.getViewFactory().registerViewBuilder("QQRIJRichTextView", new pee());
    paramVafContext.getViewFactory().registerViewBuilder("QQRIJCommentLikeButton", new peg());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyExposeReplyCommentView", new pem());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyAwesomeCommentView", new qiz());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyAdDownloadView", new osq());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyAdLocationView", new qiv());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyIconText", new oti());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInjoyDoubleImageView", new otr());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInjoyTripleImageInteractView", new ott());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyAdInnerOperateView", new oss());
    paramVafContext.getViewFactory().registerViewBuilder("ProteusTickerView", new qis());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInjoyShareView", new qjs());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInjoyApngImageView", new qki());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyAdBrandOptimizationView", new osl());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInjoyProgressView", new qkp());
    a();
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyArticleBottomVideoView", new otd());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyVideoView", new qkg());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyGifView", new qjh());
    paramVafContext.getViewFactory().registerViewBuilder("ProteusMarqueeLabel", new NativeText.Builder());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyLinkClickableLabel", new qkt());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyLottieView", new qjo());
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
      qhy.a("ProteusSupportUtil", "[bindDynamicValue]");
    }
  }
  
  private static void a(pxk parampxk, VafContext paramVafContext)
  {
    Object localObject = parampxk.a();
    if (localObject != null)
    {
      localObject = ((snh)localObject).b(parampxk.h() + 1);
      if ((localObject != null) && (((BaseArticleInfo)localObject).mProteusTemplateBean == null))
      {
        QLog.d("ProteusSupportUtil", 2, "next.mProteusTemplateBean == null " + localObject);
        ((BaseArticleInfo)localObject).mProteusTemplateBean = a(paramVafContext, parampxk.b(), (BaseArticleInfo)localObject);
      }
    }
  }
  
  private static void a(pxk parampxk, ViewBase paramViewBase)
  {
    if ((parampxk != null) && (paramViewBase != null) && (paramViewBase.getNativeView() != null))
    {
      parampxk = parampxk.b();
      if ((parampxk != null) && (parampxk.mProteusTemplateBean != null))
      {
        parampxk = (ViewBean)parampxk.mProteusTemplateBean.getViewDataBinding().get("id_separator");
        if ((parampxk != null) && (parampxk.valueBean != null) && (parampxk.valueBean.normalValue != null))
        {
          parampxk = parampxk.valueBean.normalValue.get("setBackgroundColorString:");
          if (!(parampxk instanceof String)) {}
        }
      }
    }
    try
    {
      paramViewBase.getNativeView().setBackgroundColor(Color.parseColor((String)parampxk));
      return;
    }
    catch (Exception parampxk)
    {
      QLog.d("ProteusSupportUtil", 1, parampxk.getMessage());
    }
  }
  
  public static boolean a(int paramInt)
  {
    if (!pfq.a()) {}
    do
    {
      return false;
      switch (paramInt)
      {
      }
    } while (oqb.a(paramInt));
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
  
  public static boolean a(int paramInt1, int paramInt2, ArticleInfo paramArticleInfo)
  {
    bkpj.a("configDivider.isDividerNormal");
    if ((b(paramInt1)) && ((b(paramInt2)) || (qpf.a.a(paramArticleInfo, paramInt2) == 0))) {}
    for (boolean bool = true;; bool = false)
    {
      bkpj.a();
      return bool;
    }
  }
  
  /* Error */
  public static boolean a(ArticleInfo paramArticleInfo)
  {
    // Byte code:
    //   0: ldc_w 1304
    //   3: invokestatic 152	bkpj:a	(Ljava/lang/String;)V
    //   6: aload_0
    //   7: ifnull +154 -> 161
    //   10: aload_0
    //   11: getfield 1307	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:proteusItemsData	Ljava/lang/String;
    //   14: invokestatic 749	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   17: ifne +144 -> 161
    //   20: aload_0
    //   21: getfield 1310	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mFeedType	I
    //   24: bipush 29
    //   26: if_icmpeq +8 -> 34
    //   29: invokestatic 166	bkpj:a	()V
    //   32: iconst_0
    //   33: ireturn
    //   34: new 467	org/json/JSONObject
    //   37: dup
    //   38: aload_0
    //   39: getfield 1307	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:proteusItemsData	Ljava/lang/String;
    //   42: invokespecial 1312	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   45: astore_0
    //   46: aload_0
    //   47: invokevirtual 829	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   50: astore_2
    //   51: aload_2
    //   52: invokeinterface 785 1 0
    //   57: ifeq +104 -> 161
    //   60: aload_2
    //   61: invokeinterface 789 1 0
    //   66: checkcast 197	java/lang/String
    //   69: astore_3
    //   70: aload_0
    //   71: aload_3
    //   72: invokevirtual 1315	org/json/JSONObject:opt	(Ljava/lang/String;)Ljava/lang/Object;
    //   75: astore 4
    //   77: ldc_w 1317
    //   80: aload_3
    //   81: invokevirtual 653	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   84: ifeq -33 -> 51
    //   87: ldc 230
    //   89: iconst_1
    //   90: iconst_2
    //   91: anewarray 4	java/lang/Object
    //   94: dup
    //   95: iconst_0
    //   96: ldc_w 1319
    //   99: aastore
    //   100: dup
    //   101: iconst_1
    //   102: aload 4
    //   104: aastore
    //   105: invokestatic 225	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   108: invokestatic 166	bkpj:a	()V
    //   111: ldc_w 1321
    //   114: aload 4
    //   116: invokestatic 1324	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   119: invokevirtual 653	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   122: ifne +19 -> 141
    //   125: ldc_w 1326
    //   128: aload 4
    //   130: invokestatic 1324	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   133: invokevirtual 653	java/lang/String:equals	(Ljava/lang/Object;)Z
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
    //   151: ldc 230
    //   153: iconst_1
    //   154: ldc_w 1328
    //   157: aload_0
    //   158: invokestatic 1330	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   161: invokestatic 166	bkpj:a	()V
    //   164: iconst_0
    //   165: ireturn
    //   166: astore_0
    //   167: ldc 230
    //   169: iconst_1
    //   170: ldc_w 1332
    //   173: aload_0
    //   174: invokestatic 1330	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
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
  
  private static boolean a(BaseArticleInfo paramBaseArticleInfo, ViewBase paramViewBase, VafContext paramVafContext)
  {
    boolean bool = paramBaseArticleInfo instanceof AdvertisementInfo;
    if ((paramViewBase == null) || (paramVafContext == null) || (paramVafContext.getContext() == null) || (paramBaseArticleInfo == null)) {
      bool = false;
    }
    return bool;
  }
  
  private static boolean a(Container paramContainer, int paramInt)
  {
    if (paramContainer != null) {}
    for (;;)
    {
      int i;
      try
      {
        int j = paramContainer.getChildCount();
        i = 0;
        if (i < j)
        {
          View localView = paramContainer.getChildAt(i);
          Object localObject;
          if ((localView instanceof NativeLayoutImpl))
          {
            localObject = (NativeLayoutImpl)localView;
            if ((((NativeLayoutImpl)localObject).getChildCount() == 0) && (((NativeLayoutImpl)localObject).getBackgroundColor() == 0))
            {
              QQAppInterface localQQAppInterface = pha.a();
              if (((NativeLayoutImpl)localObject).getContentDescription() == null) {
                continue;
              }
              localObject = ((NativeLayoutImpl)localObject).getContentDescription().toString();
              oat.a(localQQAppInterface, "CliOper", "", "", "0X8009AC1", "0X8009AC1", 0, 0, "", "", "", (String)localObject, false);
              if (QLog.isColorLevel())
              {
                qhz.a(paramContainer.getVirtualView(), "ProteusSupportUtil");
                qhz.a(paramContainer, "ProteusSupportUtil");
              }
              QLog.e("ProteusSupportUtil", 1, "[nativeLayoutImplError] empty native layout " + paramInt);
            }
          }
          if ((QLog.isColorLevel()) && ((localView instanceof ViewGroup)))
          {
            localObject = (ViewGroup)localView;
            QLog.e("ProteusSupportUtil", 1, "ChildCount " + ((ViewGroup)localObject).getChildCount());
            break label235;
            localObject = "";
            continue;
          }
        }
        else
        {
          return false;
        }
      }
      catch (Exception paramContainer)
      {
        QLog.e("ProteusSupportUtil", 1, "[nativeLayoutImplError] ", paramContainer);
      }
      label235:
      i += 1;
    }
  }
  
  public static boolean a(VafContext paramVafContext, int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    return a(paramVafContext, paramInt, paramBaseArticleInfo) != null;
  }
  
  public static boolean a(VafContext paramVafContext, String paramString)
  {
    paramString = teh.a(paramString, true);
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
  
  public static boolean a(pxk parampxk)
  {
    if (parampxk != null) {
      try
      {
        int i = parampxk.b();
        if ((i == 66) || (i == 39))
        {
          parampxk = parampxk.b();
          if ((parampxk != null) && (AdvertisementInfo.isAdvertisementInfo(parampxk)))
          {
            parampxk = ((AdvertisementInfo)parampxk).mAdExtInfo;
            if (parampxk != null)
            {
              i = new JSONObject(parampxk).optInt("is_video_new");
              return i == 1;
            }
          }
        }
      }
      catch (Exception parampxk)
      {
        QLog.d("ProteusSupportUtil", 1, "isNextCardAdBigImgOrAdVideo JSONException, e = ", parampxk);
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
        qhy.a("ProteusSupportUtil", "[getSepatatorHeight] getSepatatorHeight");
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
  
  private static void b(VafContext paramVafContext, String paramString)
  {
    paramString = teh.a(paramString, false);
    if ((paramString != null) && (paramVafContext.getTemplateFactory() != paramString)) {
      paramVafContext.setTemplateFactory(paramString);
    }
  }
  
  public static boolean b(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 1) || (paramInt == 2) || (paramInt == 3) || (paramInt == 5) || (paramInt == 47) || (paramInt == 60) || (paramInt == 39) || (paramInt == 66) || (paramInt == 50) || (paramInt == 51) || (paramInt == 52) || (paramInt == 53) || (paramInt == 96) || (paramInt == 103) || (paramInt == 102) || (paramInt == 101) || (paramInt == 104) || (paramInt == 105) || (paramInt == 106) || (paramInt == 116) || (paramInt == 122) || (paramInt == 117) || (paramInt >= 147) || (paramInt == 121) || (paramInt == 126) || (paramInt == 115) || (paramInt == 124) || (paramInt == 125) || (paramInt == 127) || (paramInt == 140) || (paramInt == 141) || (paramInt == 129) || (paramInt == 130) || (paramInt == 136) || (paramInt == 46) || (paramInt == 142);
  }
  
  @Deprecated
  private static boolean b(BaseArticleInfo paramBaseArticleInfo, int paramInt, ViewBase paramViewBase, VafContext paramVafContext)
  {
    if (paramBaseArticleInfo != null) {}
    switch (paramInt)
    {
    default: 
      return true;
    case 1070: 
      return AdvertisementInfo.isAdvertisementInfo(paramBaseArticleInfo);
    case 1007: 
      if ((pha.b((ArticleInfo)paramBaseArticleInfo)) || (pha.c((ArticleInfo)paramBaseArticleInfo))) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    case 1035: 
    case 1171: 
    case 1172: 
      return false;
    case 1044: 
      return ubb.a((ArticleInfo)paramBaseArticleInfo);
    }
    return a(paramBaseArticleInfo, paramViewBase, paramVafContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pfr
 * JD-Core Version:    0.7.0.1
 */