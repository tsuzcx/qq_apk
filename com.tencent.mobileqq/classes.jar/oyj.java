import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
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

public class oyj
{
  private static double jdField_a_of_type_Double;
  private static int jdField_a_of_type_Int;
  private static final Map<Integer, pye> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  static
  {
    if (jdField_a_of_type_JavaUtilMap.isEmpty())
    {
      a(3, new pyn());
      a(72, new puq());
      a(73, new puw());
      a(74, new pyi());
      a(90, new pyh());
      a(91, new pyh());
      a(75, new pyi());
      a(21, new pyp());
      a(22, new pyp());
      a(36, new pyp());
      a(23, new pyp());
      a(120, new pyp());
      a(80, new pyp());
      a(34, new pxe());
      a(16, new pxe());
      a(17, new pxe());
      a(19, new pxe());
      a(18, new pxe());
      a(20, new pxe());
      a(65, new pxe());
      a(64, new pxe());
      a(48, new pxe());
      a(25, new pvh());
      a(24, new pvh());
      a(26, new pvh());
      a(107, new pyp());
      a(108, new pvh());
      a(37, new pvh());
      a(81, new pvh());
      a(35, new puz());
      a(12, new puz());
      a(10, new puz());
      a(11, new puz());
      a(28, new puz());
      a(27, new puz());
      a(49, new puz());
      a(62, new puz());
      a(63, new puz());
      a(33, new puz());
      a(31, new pxe());
      a(32, new pxe());
      a(79, new pxb());
      a(76, new pxb());
      a(77, new pxb());
      a(78, new pxb());
      a(83, new pxe());
      a(84, new pxe());
      a(85, new pxe());
      a(86, new pxe());
      a(89, new pup());
      a(92, new pvh());
      a(94, new puz());
      a(95, new puz());
      a(101, new pwh());
      a(102, new pwh());
      a(103, new pwh());
      a(105, new toq());
      a(66, new tog());
      a(115, new tog());
      a(39, new tof());
      a(116, new toi());
      a(117, new top());
      a(106, new too());
      a(140, new tok());
      a(146, new toj());
      a(141, new ton());
      a(143, new ton());
      a(144, new tom());
      a(145, new tol());
      a(109, new pxl());
      a(110, new pxl());
      a(111, new pxl());
      a(132, new pxl());
      a(133, new pxl());
      a(134, new pxl());
      a(112, new puz());
      a(113, new puz());
      a(114, new puz());
      a(126, new puu());
      a(2, new put());
      a(1, new pyl());
      a(121, new pvy());
      a(122, new tof());
      a(124, new pwn());
      a(125, new pwn());
      a(127, new toh());
      a(129, new pwm());
      a(130, new pwl());
      a(131, new pws());
      a(46, new pwa());
      a(123, new pww());
      a(135, new pwj());
      a(137, new pvt());
      a(139, new pvt());
      a(138, new pvt());
      a(142, new pvl());
    }
  }
  
  private static double a(TemplateBean paramTemplateBean)
  {
    blqm.a("getProteusSeparatorMarginLeftPx");
    if ((jdField_a_of_type_Double > 0.0D) && (paramTemplateBean != null))
    {
      suz localsuz = suz.a("default_feeds", false);
      if ((localsuz != null) && (!localsuz.a(paramTemplateBean)))
      {
        blqm.a();
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
    blqm.a();
    return jdField_a_of_type_Double;
  }
  
  private static int a(TemplateBean paramTemplateBean)
  {
    blqm.a("getProteusSeparatorHeightPx");
    if ((jdField_a_of_type_Int > 0) && (paramTemplateBean != null))
    {
      localsuz = suz.a("default_feeds", false);
      if ((localsuz != null) && (!localsuz.a(paramTemplateBean)))
      {
        blqm.a();
        qaj.a("ProteusSupportUtil", "[getProteusSeparatorHeightPx] SeparatorHeight : " + jdField_a_of_type_Int);
        return jdField_a_of_type_Int;
      }
    }
    suz localsuz = suz.a("default_feeds", false);
    paramTemplateBean = null;
    if (localsuz != null) {
      paramTemplateBean = localsuz.getTemplate("ReadInjoy_triple_img_cell");
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
        qaj.a("ProteusSupportUtil", "[getProteusSeparatorHeightPx] getSeparatorHeightPx");
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
      blqm.a();
      return jdField_a_of_type_Int;
      jdField_a_of_type_Int = Utils.dp2px(0.5D);
    }
  }
  
  public static ProteusItemView a(VafContext paramVafContext, int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    if (qak.a()) {
      qak.a("ProteusSupportUtil", "[getView] " + paramBaseArticleInfo + " adapterViewType: " + paramInt);
    }
    long l1 = System.currentTimeMillis();
    blqm.a("ProteusSupportUtil.getView");
    blqm.a("ProteusSupportUtil#getView#getTemplateBean");
    TemplateBean localTemplateBean = a(paramVafContext, paramInt, paramBaseArticleInfo);
    blqm.a();
    String str;
    if (localTemplateBean != null)
    {
      str = "[" + localTemplateBean.getStyleName() + "]";
      paramBaseArticleInfo = null;
      if ((!(paramVafContext.getTemplateFactory() instanceof suz)) || (localTemplateBean == null)) {
        break label453;
      }
    }
    label256:
    label436:
    label443:
    label453:
    for (Object localObject = oyh.a.a(((suz)paramVafContext.getTemplateFactory()).b(), localTemplateBean.getStyleName());; localObject = null)
    {
      if (localObject == null)
      {
        blqm.a(str + "#inflate");
        localObject = paramVafContext.getViewFactory().inflate(paramVafContext, localTemplateBean);
        qaj.a("ProteusSupportUtil", "[getView] inflate");
        blqm.a();
      }
      for (;;)
      {
        label240:
        long l2;
        if (localObject != null)
        {
          blqm.a(str + "#setBackgroundDrawable");
          if ((ozs.r()) && (bnrf.j()))
          {
            paramInt = 1;
            paramBaseArticleInfo = paramVafContext.getContext().getResources();
            if (paramInt == 0) {
              break label436;
            }
            paramInt = 2130841692;
            ((Container)localObject).setBackgroundDrawable(paramBaseArticleInfo.getDrawable(paramInt));
            paramBaseArticleInfo = new ProteusItemView(paramVafContext.getContext());
            paramBaseArticleInfo.a((Container)localObject);
            blqm.a();
            qaj.a("ProteusSupportUtil", "[getView]  add Container ");
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            qak.a((View)localObject, "ProteusSupportUtil");
          }
          l2 = System.currentTimeMillis();
          if (localTemplateBean == null) {
            break label443;
          }
        }
        for (paramVafContext = localTemplateBean.getStyleName();; paramVafContext = "templateBean is null")
        {
          tkb.a("ProteusSupportUtil", paramVafContext, "ProteusSupportUtil.getView", l2 - l1);
          blqm.a();
          return paramBaseArticleInfo;
          qaj.a("ProteusSupportUtil", "[getView]  new proteusItemView ");
          localObject = new ProteusItemView(paramVafContext.getContext());
          ((ProteusItemView)localObject).setVisibility(8);
          QLog.i("ProteusSupportUtil", 1, "[getView] 未找到样式,请确认是否下发该卡片的样式:" + paramBaseArticleInfo + " adapterViewType: " + paramInt + "  " + paramVafContext.getTemplateFactory());
          paramBaseArticleInfo = (BaseArticleInfo)localObject;
          str = "";
          break;
          paramInt = 0;
          break label240;
          paramInt = 2130841693;
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
    //   1: ifnonnull +18 -> 19
    //   4: ldc 156
    //   6: iconst_0
    //   7: invokestatic 161	suz:a	(Ljava/lang/String;Z)Lsuz;
    //   10: astore 4
    //   12: aload 4
    //   14: ifnonnull +506 -> 520
    //   17: aconst_null
    //   18: areturn
    //   19: aload_0
    //   20: invokevirtual 333	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/VafContext:getTemplateFactory	()Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/factory/BaseTemplateFactory;
    //   23: checkcast 158	suz
    //   26: astore 4
    //   28: invokestatic 212	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   31: ifeq +39 -> 70
    //   34: ldc 230
    //   36: iconst_2
    //   37: new 242	java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   44: ldc_w 433
    //   47: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: aload_2
    //   51: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   54: ldc_w 435
    //   57: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: iload_1
    //   61: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   64: invokevirtual 256	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: invokestatic 235	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   70: aload_2
    //   71: getfield 441	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mProteusTemplateBean	Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;
    //   74: ifnull +20 -> 94
    //   77: aload 4
    //   79: aload_2
    //   80: getfield 441	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mProteusTemplateBean	Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;
    //   83: invokevirtual 164	suz:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;)Z
    //   86: ifne +8 -> 94
    //   89: aload_2
    //   90: getfield 441	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mProteusTemplateBean	Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;
    //   93: areturn
    //   94: getstatic 18	oyj:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   97: iload_1
    //   98: invokestatic 284	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   101: invokeinterface 195 2 0
    //   106: checkcast 443	pye
    //   109: astore_3
    //   110: aload_3
    //   111: ifnull +152 -> 263
    //   114: aload_3
    //   115: iload_1
    //   116: aload_2
    //   117: invokeinterface 446 3 0
    //   122: astore_0
    //   123: aload_3
    //   124: ifnull +391 -> 515
    //   127: aload_3
    //   128: iload_1
    //   129: aload_0
    //   130: invokeinterface 449 3 0
    //   135: astore_3
    //   136: aload_3
    //   137: ifnonnull +375 -> 512
    //   140: aload 4
    //   142: ifnull +310 -> 452
    //   145: aload 4
    //   147: aload_0
    //   148: invokevirtual 453	suz:getTemplateBean	(Lorg/json/JSONObject;)Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;
    //   151: astore 4
    //   153: aload 4
    //   155: astore_3
    //   156: aload_2
    //   157: aload_3
    //   158: putfield 441	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mProteusTemplateBean	Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;
    //   161: new 242	java/lang/StringBuilder
    //   164: dup
    //   165: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   168: ldc_w 455
    //   171: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: astore 4
    //   176: aload_0
    //   177: ifnull +280 -> 457
    //   180: new 242	java/lang/StringBuilder
    //   183: dup
    //   184: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   187: aload_0
    //   188: ldc_w 457
    //   191: invokevirtual 463	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   194: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: ldc_w 465
    //   200: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: aload_0
    //   204: invokevirtual 466	org/json/JSONObject:toString	()Ljava/lang/String;
    //   207: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: ldc_w 468
    //   213: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: invokevirtual 256	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   219: astore_2
    //   220: ldc 230
    //   222: iconst_2
    //   223: aload 4
    //   225: aload_2
    //   226: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: invokevirtual 256	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   232: invokestatic 235	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   235: ldc 230
    //   237: iconst_1
    //   238: new 242	java/lang/StringBuilder
    //   241: dup
    //   242: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   245: ldc_w 470
    //   248: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: aload_0
    //   252: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   255: invokevirtual 256	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   258: invokestatic 235	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   261: aload_3
    //   262: areturn
    //   263: iload_1
    //   264: lookupswitch	default:+100->364, 1:+116->380, 5:+108->372, 29:+132->396, 34:+156->420, 40:+172->436, 41:+180->444, 42:+164->428, 47:+140->404, 60:+148->412, 96:+148->412, 104:+124->388
    //   365: invokestatic 475	pui:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   368: astore_0
    //   369: goto -246 -> 123
    //   372: aload_2
    //   373: invokestatic 478	pua:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   376: astore_0
    //   377: goto -254 -> 123
    //   380: aload_2
    //   381: invokestatic 481	ptz:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   384: astore_0
    //   385: goto -262 -> 123
    //   388: aload_2
    //   389: invokestatic 484	ptq:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   392: astore_0
    //   393: goto -270 -> 123
    //   396: aload_2
    //   397: invokestatic 487	pty:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   400: astore_0
    //   401: goto -278 -> 123
    //   404: aload_2
    //   405: invokestatic 490	pts:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   408: astore_0
    //   409: goto -286 -> 123
    //   412: aload_2
    //   413: invokestatic 493	puh:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   416: astore_0
    //   417: goto -294 -> 123
    //   420: aload_2
    //   421: invokestatic 496	puj:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   424: astore_0
    //   425: goto -302 -> 123
    //   428: aload_2
    //   429: invokestatic 499	pul:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   432: astore_0
    //   433: goto -310 -> 123
    //   436: aload_2
    //   437: invokestatic 502	puk:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   440: astore_0
    //   441: goto -318 -> 123
    //   444: aload_2
    //   445: invokestatic 505	pum:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   448: astore_0
    //   449: goto -326 -> 123
    //   452: aconst_null
    //   453: astore_3
    //   454: goto -298 -> 156
    //   457: ldc_w 426
    //   460: astore_2
    //   461: goto -241 -> 220
    //   464: astore_0
    //   465: aconst_null
    //   466: astore_3
    //   467: ldc 230
    //   469: iconst_1
    //   470: ldc_w 507
    //   473: aload_0
    //   474: invokestatic 511	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   477: goto -216 -> 261
    //   480: astore_0
    //   481: aconst_null
    //   482: astore_3
    //   483: ldc 230
    //   485: iconst_1
    //   486: ldc_w 513
    //   489: aload_0
    //   490: invokestatic 511	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   493: goto -232 -> 261
    //   496: astore_0
    //   497: goto -14 -> 483
    //   500: astore_0
    //   501: goto -18 -> 483
    //   504: astore_0
    //   505: goto -38 -> 467
    //   508: astore_0
    //   509: goto -42 -> 467
    //   512: goto -356 -> 156
    //   515: aconst_null
    //   516: astore_3
    //   517: goto -381 -> 136
    //   520: goto -492 -> 28
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	523	0	paramVafContext	VafContext
    //   0	523	1	paramInt	int
    //   0	523	2	paramBaseArticleInfo	BaseArticleInfo
    //   109	408	3	localObject1	Object
    //   10	214	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   70	94	464	org/json/JSONException
    //   94	110	464	org/json/JSONException
    //   114	123	464	org/json/JSONException
    //   127	136	464	org/json/JSONException
    //   364	369	464	org/json/JSONException
    //   372	377	464	org/json/JSONException
    //   380	385	464	org/json/JSONException
    //   388	393	464	org/json/JSONException
    //   396	401	464	org/json/JSONException
    //   404	409	464	org/json/JSONException
    //   412	417	464	org/json/JSONException
    //   420	425	464	org/json/JSONException
    //   428	433	464	org/json/JSONException
    //   436	441	464	org/json/JSONException
    //   444	449	464	org/json/JSONException
    //   70	94	480	java/lang/Exception
    //   94	110	480	java/lang/Exception
    //   114	123	480	java/lang/Exception
    //   127	136	480	java/lang/Exception
    //   364	369	480	java/lang/Exception
    //   372	377	480	java/lang/Exception
    //   380	385	480	java/lang/Exception
    //   388	393	480	java/lang/Exception
    //   396	401	480	java/lang/Exception
    //   404	409	480	java/lang/Exception
    //   412	417	480	java/lang/Exception
    //   420	425	480	java/lang/Exception
    //   428	433	480	java/lang/Exception
    //   436	441	480	java/lang/Exception
    //   444	449	480	java/lang/Exception
    //   145	153	496	java/lang/Exception
    //   156	176	500	java/lang/Exception
    //   180	220	500	java/lang/Exception
    //   220	261	500	java/lang/Exception
    //   145	153	504	org/json/JSONException
    //   156	176	508	org/json/JSONException
    //   180	220	508	org/json/JSONException
    //   220	261	508	org/json/JSONException
  }
  
  public static String a(BaseArticleInfo paramBaseArticleInfo)
  {
    String str = null;
    if (!quv.c(paramBaseArticleInfo))
    {
      QLog.d("ProteusSupportUtil", 1, "UGRuleManager getUGSchema is not ugCard");
      return null;
    }
    int i = qur.jdField_a_of_type_Int;
    qur localqur = qur.a();
    boolean bool = localqur.a(paramBaseArticleInfo, true, i);
    if (bool)
    {
      str = localqur.a(paramBaseArticleInfo, i, null, null);
      QLog.d("ProteusSupportUtil", 1, "UGRuleManager getUGSchema ugUrl is " + str);
    }
    localqur.a(paramBaseArticleInfo, bool, true, i);
    return str;
  }
  
  private static void a()
  {
    qaj.a("ProteusSupportUtil", "resetProteusSeparatorHeightPx ");
    QLog.d("TemplateFactory", 4, "resetProteusSeparatorHeightPx");
    jdField_a_of_type_Int = 0;
  }
  
  public static void a(int paramInt, ProteusItemView paramProteusItemView, VafContext paramVafContext, aoof paramaoof, sel paramsel, ppu paramppu, BaseArticleInfo paramBaseArticleInfo)
  {
    Container localContainer = paramProteusItemView.a();
    ViewFactory.findClickableViewListener(localContainer.getVirtualView(), new oyo(paramInt, localContainer, paramppu, paramBaseArticleInfo, paramVafContext, paramProteusItemView, paramaoof, paramsel));
  }
  
  private static void a(int paramInt1, Container paramContainer, ppu paramppu, int paramInt2)
  {
    blqm.a("ProteusSupportUtil.bindView");
    if (paramContainer == null)
    {
      blqm.a();
      return;
    }
    qaj.a("ProteusSupportUtil", "[bindView]");
    Object localObject = (pye)jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt1));
    if (localObject != null)
    {
      ((pye)localObject).a(paramInt1, paramContainer, paramppu, paramInt2);
      blqm.a();
    }
    for (;;)
    {
      blqm.a();
      return;
      paramContainer = paramContainer.getVirtualView();
      switch (paramInt1)
      {
      default: 
        break;
      case 10: 
        localObject = (qav)paramContainer.findViewBaseByName("id_info_avator");
        if (localObject != null) {
          ((qav)localObject).a(paramppu);
        }
        localObject = (qdg)paramContainer.findViewBaseByName("id_summary");
        if (localObject != null) {
          ((qdg)localObject).a(paramppu);
        }
        localObject = (qax)paramContainer.findViewBaseByName("id_biu_comment");
        if (localObject != null) {
          ((qax)localObject).a(paramppu);
        }
        paramContainer = (qaz)paramContainer.findViewBaseByName("id_corner_text_image");
        if (paramContainer != null) {
          paramContainer.a(paramppu);
        }
        break;
      case 34: 
      case 40: 
      case 41: 
      case 42: 
        localObject = (qav)paramContainer.findViewBaseByName("id_info_avator");
        if (localObject != null) {
          ((qav)localObject).a(paramppu);
        }
        localObject = (qdg)paramContainer.findViewBaseByName("id_summary");
        if (localObject != null) {
          ((qdg)localObject).a(paramppu);
        }
        localObject = (qax)paramContainer.findViewBaseByName("id_biu_comment");
        if (localObject != null) {
          ((qax)localObject).a(paramppu);
        }
        paramContainer = (qbb)paramContainer.findViewBaseByName("id_multi_image");
        if (paramContainer != null) {
          paramContainer.a(paramppu.a());
        }
        break;
      }
    }
  }
  
  private static void a(int paramInt, pye parampye)
  {
    if (parampye == null) {
      throw new NullPointerException();
    }
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), parampye);
  }
  
  public static void a(ProteusItemView paramProteusItemView, int paramInt1, BaseArticleInfo paramBaseArticleInfo, VafContext paramVafContext, aoof paramaoof, sel paramsel, ppu paramppu, int paramInt2, String paramString)
  {
    if (qak.a()) {
      qak.a("ProteusSupportUtil", "[bindData]  adapterViewType: " + paramInt1 + ", data : " + paramBaseArticleInfo);
    }
    blqm.a("ProteusSupportUtil.bindData");
    long l1 = System.currentTimeMillis();
    if ((paramProteusItemView == null) || (paramProteusItemView.a() == null))
    {
      blqm.a();
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
        break label542;
      }
      i = localTemplateBean.getId();
      if (localObject == null) {
        break label548;
      }
      j = ((TemplateBean)localObject).getId();
      label207:
      QLog.i("ProteusSupportUtil", 1, "[bindData] trigger re-inflation, adapterViewType: " + paramInt1 + " new id: " + i + " old id: " + j);
      qaj.a("ProteusSupportUtil", "[bindData] trigger re-inflation, adapterViewType: " + paramInt1 + " new id: " + i + " old id: " + j);
      paramString = paramVafContext.getViewFactory().inflate(paramVafContext, localTemplateBean);
      if (paramString != null)
      {
        paramString.setBackgroundDrawable(paramVafContext.getContext().getResources().getDrawable(2130841693));
        paramProteusItemView.d();
        paramProteusItemView.a(paramString);
        qak.a(paramString.getVirtualView(), "ProteusSupportUtil");
        qak.a(paramString, "ProteusSupportUtil");
      }
      paramBaseArticleInfo.mProteusTemplateBean = localTemplateBean;
      a();
      paramString = null;
    }
    tqg.a(paramBaseArticleInfo, localTemplateBean, paramInt2);
    localObject = paramProteusItemView.a();
    paramProteusItemView.setTemplateBean(localTemplateBean);
    paramProteusItemView.setModel(paramppu, paramsel.a());
    blqm.a("ProteusSupportUtil.bindDataImpl");
    label457:
    long l2;
    if (localTemplateBean != null)
    {
      QLog.i("ProteusSupportUtil", 1, "[bindData] bind data for " + localTemplateBean.getStyleName());
      a((Container)localObject, paramString, localTemplateBean);
      blqm.a();
      a(paramInt1, (Container)localObject, paramppu, paramInt2);
      a(paramInt1, paramProteusItemView, paramVafContext, paramaoof, paramsel, paramppu, paramBaseArticleInfo);
      blqm.a("ProteusSupportUtil.configDivider");
      a(paramppu, paramVafContext);
      a((Container)localObject, paramppu, localTemplateBean);
      blqm.a();
      l2 = System.currentTimeMillis();
      if (localTemplateBean == null) {
        break label566;
      }
    }
    label542:
    label548:
    label566:
    for (paramProteusItemView = localTemplateBean.getStyleName();; paramProteusItemView = "")
    {
      tkb.a("ProteusSupportUtil", paramProteusItemView, " ProteusSupportUtil.bindData", l2 - l1);
      blqm.a();
      return;
      i = -1;
      break;
      j = -1;
      break label207;
      QLog.d("ProteusSupportUtil", 2, "[bindData] newTemplateBean is null");
      break label457;
    }
  }
  
  public static void a(ArticleInfo paramArticleInfo)
  {
    a(null, sel.c(paramArticleInfo), paramArticleInfo);
  }
  
  public static void a(BaseArticleInfo paramBaseArticleInfo, TemplateBean paramTemplateBean, ViewBase paramViewBase)
  {
    if ((!(paramBaseArticleInfo instanceof ArticleInfo)) || (paramTemplateBean == null)) {
      return;
    }
    String str = ubg.b(paramBaseArticleInfo.mChannelID);
    HashMap localHashMap = new HashMap();
    Map localMap = paramTemplateBean.getDataAttribute(null);
    paramTemplateBean = paramTemplateBean.getDataAttribute(paramViewBase.getViewId());
    if (localMap != null) {
      localHashMap.putAll(localMap);
    }
    if (paramTemplateBean != null) {
      localHashMap.putAll(paramTemplateBean);
    }
    tyd.a((ArticleInfo)paramBaseArticleInfo, str, str, (int)paramBaseArticleInfo.mChannelID, localHashMap);
    tyd.a(paramTemplateBean);
    bnrf.a(paramBaseArticleInfo);
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
    paa localpaa = new paa();
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
          localpaa.b(paramViewBase, localObject.toString());
        }
      }
    }
    ocd.a(null, "CliOper", "", "", str, str, 0, 0, "", "", "", localpaa.a(), false);
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
      paa localpaa = new paa();
      Iterator localIterator = localJSONObject.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localpaa.b(str, localJSONObject.get(str).toString());
      }
      ocd.a(null, "CliOper", "", "", paramViewBean, paramViewBean, 0, 0, "", "", "", localpaa.a(), false);
    }
    catch (Exception paramViewBean)
    {
      QLog.d("ProteusSupportUtil", 1, paramViewBean, new Object[] { "" });
      return;
    }
  }
  
  public static void a(Container paramContainer, TemplateBean paramTemplateBean1, TemplateBean paramTemplateBean2)
  {
    blqm.a("ProteusSupportUtil.bindDynamicValueWithoutRecursion");
    long l = System.currentTimeMillis();
    Map localMap1 = paramContainer.getViewIdMapping();
    Map localMap2 = paramTemplateBean2.getViewDataBinding();
    HashSet localHashSet = new HashSet();
    if (paramTemplateBean1 != null) {}
    for (paramContainer = paramTemplateBean1.getViewDataBinding();; paramContainer = null)
    {
      if (localMap1 != null) {
        localHashSet.addAll(localMap1.keySet());
      }
      localHashSet.removeAll(localMap2.keySet());
      StringBuilder localStringBuilder = new StringBuilder("bindDynamicValueWithoutRecursion: ");
      Iterator localIterator = localMap2.keySet().iterator();
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        ViewBean localViewBean = (ViewBean)localMap2.get(str);
        label154:
        ViewBase localViewBase;
        label173:
        int i;
        if (paramContainer != null)
        {
          paramTemplateBean1 = (ViewBean)paramContainer.get(str);
          if (localMap1 == null) {
            break label306;
          }
          localViewBase = (ViewBase)localMap1.get(str);
          blqm.a("bindDynamicValueWithoutRecursion.bindDynamicVal.check");
          if ((str == null) || (localViewBase == null) || (localViewBean == null) || ((paramTemplateBean1 != null) && (localViewBean.valueBean.dynamicValue.equals(paramTemplateBean1.valueBean.dynamicValue)))) {
            break label312;
          }
          i = 1;
          label223:
          blqm.a();
          if (i == 0) {
            break label317;
          }
          localViewBean.setVisible(true);
          localViewBase.bindDynamicValue(localViewBean);
          blqm.a();
          localStringBuilder.append("[bindNewValue] bind dynamicValue: ").append(localViewBean.valueBean.dynamicValue).append(" viewId = ").append(str).append("\n");
        }
        for (;;)
        {
          if (localViewBase != null) {
            localViewBase.setVisibility(0);
          }
          blqm.a();
          break;
          paramTemplateBean1 = null;
          break label154;
          label306:
          localViewBase = null;
          break label173;
          label312:
          i = 0;
          break label223;
          label317:
          if ((QLog.isColorLevel()) && (localViewBean != null)) {
            localStringBuilder.append("skip: ").append(localViewBean.valueBean.dynamicValue).append(" viewId = ").append(str).append("\n");
          }
        }
      }
      QLog.i("ProteusSupportUtil", 1, localStringBuilder.toString());
      paramContainer = localHashSet.iterator();
      while (paramContainer.hasNext())
      {
        paramTemplateBean1 = (ViewBase)localMap1.get((String)paramContainer.next());
        if (paramTemplateBean1 != null) {
          paramTemplateBean1.setVisibility(8);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("ProteusSupportUtil", 2, "bindDynamicValueWithoutRecursion_____ " + paramTemplateBean2.getStyleName() + " cost " + (System.currentTimeMillis() - l) + "ms");
      }
      blqm.a();
      return;
    }
  }
  
  public static void a(Container paramContainer, VafContext paramVafContext, TemplateBean paramTemplateBean)
  {
    ViewFactory.findClickableViewListener(paramContainer.getVirtualView(), new oyk(paramVafContext, paramTemplateBean));
  }
  
  public static void a(Container paramContainer, ppu paramppu, TemplateBean paramTemplateBean)
  {
    if (oxv.a(paramContainer, paramppu)) {
      return;
    }
    ViewBase localViewBase1 = paramContainer.getVirtualView();
    ViewBase localViewBase2 = localViewBase1.findViewBaseByName("id_separator");
    ArticleInfo localArticleInfo = paramppu.a();
    if ((localArticleInfo == null) || (localViewBase2 == null))
    {
      QLog.d("ProteusSupportUtil", 1, "configDivider failed, articleInfo is null or divider is null.");
      return;
    }
    Layout.Params localParams = localViewBase2.getComLayoutParams();
    int m = localParams.mLayoutHeight;
    int j = Utils.dp2px(5.0D);
    double d = Utils.dp2px(6.0D);
    int i = paramppu.a();
    int k = paramppu.b();
    if (localArticleInfo.mChannelID == 70L)
    {
      blqm.a("configDivider.FollowFeeds");
      localParams.mLayoutMarginLeft = 0;
      localParams.mLayoutMarginRight = 0;
      localParams.mLayoutWidth = -1;
      i = Utils.dp2px(5.0D);
      blqm.a();
    }
    for (;;)
    {
      localParams.mLayoutHeight = i;
      localViewBase2.setComLayoutParams(localParams);
      paramppu = localViewBase1.getComLayoutParams();
      if (paramppu.mLayoutHeight >= 0) {
        paramppu.mLayoutHeight = (i - m + paramppu.mLayoutHeight);
      }
      paramppu = localViewBase1.getComLayoutParams();
      paramContainer.setLayoutParams(new RelativeLayout.LayoutParams(paramppu.mLayoutWidth, paramppu.mLayoutHeight));
      return;
      if (pbd.c((int)localArticleInfo.mChannelID))
      {
        blqm.a("configDivider.DailyFeeds");
        paramppu = paramppu.b();
        j = 0;
        k = 0;
        i = k;
        if (paramppu != null)
        {
          i = k;
          if (paramppu.mProteusTemplateBean != null)
          {
            if (paramppu.mProteusTemplateBean.getDataAttribute(null, "position_jump") == null) {
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
          blqm.a();
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
      else if ((a(paramppu.b())) || (a(paramppu)))
      {
        i = 0;
        localParams.mLayoutMarginLeft = 0;
        localParams.mLayoutMarginRight = 0;
        localParams.mLayoutWidth = -1;
      }
      else if (a(i, k, paramppu.b()))
      {
        blqm.a("configDivider.normal");
        blqm.a("configDivider.normal.getProteusSeparatorHeightPx");
        i = a(paramTemplateBean);
        blqm.a();
        blqm.a("configDivider.normal.getProteusSeparatorMarginLeftPx");
        d = a(paramTemplateBean);
        blqm.a();
        j = Utils.dp2px(d);
        localParams.mLayoutMarginRight = j;
        localParams.mLayoutMarginLeft = j;
        localParams.mLayoutWidth = -1;
        blqm.a();
      }
      else
      {
        localParams.mLayoutMarginLeft = 0;
        localParams.mLayoutMarginRight = 0;
        localParams.mLayoutWidth = -1;
        i = j;
        if (!b(k))
        {
          a(paramppu, localViewBase2);
          i = j;
        }
      }
    }
  }
  
  public static void a(VafContext paramVafContext, String paramString)
  {
    paramVafContext.setTemplateFactory(suz.a(paramString, true));
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyLikeButton", new qbx());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyAvatarView", new qaw());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyVariableImageContentView", new qbc());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoySummaryView", new qdh());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyCommentView", new qau());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyBiuCommentView", new qay());
    paramVafContext.getViewFactory().registerViewBuilder("CornerTextImageView", new qba());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyMiddleBodyView", new qcc());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyUsersCommentView", new qdj());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyFriendsBiu", new qbr());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyQARichView", new NativeText.Builder());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyBiuButton", new qbm());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyCoordinateView", new qbp());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoySocializeRecommendFollowView", new qco());
    paramVafContext.getViewFactory().registerViewBuilder("UILabel", new qdf());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInjoyAsynImageView", new qcy());
    paramVafContext.getViewFactory().registerViewBuilder("UIImageView", new qcy());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInjoyAsynImageIcon", new qcw());
    paramVafContext.getViewFactory().registerViewBuilder("ProteusCollectionView", new qes());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyAdVideoGuide", new qbj());
    paramVafContext.getViewFactory().registerViewBuilder("PTSAvatarView", new owu());
    paramVafContext.getViewFactory().registerViewBuilder("QQAvatarView", new owu());
    paramVafContext.getViewFactory().registerViewBuilder("RIJCommentRichTextView", new oxc());
    paramVafContext.getViewFactory().registerViewBuilder("QQRIJRichTextView", new oww());
    paramVafContext.getViewFactory().registerViewBuilder("QQRIJCommentLikeButton", new owy());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyExposeReplyCommentView", new oxe());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyAwesomeCommentView", new qbl());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyAdDownloadView", new tsi());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyAdLocationView", new qbh());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyIconText", new ttd());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInjoyDoubleImageView", new ttm());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyBlurImageView", new ttb());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInjoyTripleImageInteractView", new tto());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyAdInnerOperateView", new tsk());
    paramVafContext.getViewFactory().registerViewBuilder("ProteusTickerView", new qbe());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInjoyShareView", new qce());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInjoyApngImageView", new qcu());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyAdBrandOptimizationView", new tsd());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInjoyProgressView", new qdb());
    a();
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyArticleBottomVideoView", new tsv());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyVideoView", new qcs());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyGifView", new qbt());
    paramVafContext.getViewFactory().registerViewBuilder("ProteusMarqueeLabel", new NativeText.Builder());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyLinkClickableLabel", new qdf());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyLottieView", new qca());
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
      qaj.a("ProteusSupportUtil", "[bindDynamicValue]");
    }
  }
  
  private static void a(ppu paramppu, VafContext paramVafContext)
  {
    Object localObject = paramppu.a();
    if (localObject != null)
    {
      localObject = ((sel)localObject).b(paramppu.h() + 1);
      if ((localObject != null) && (((BaseArticleInfo)localObject).mProteusTemplateBean == null))
      {
        QLog.d("ProteusSupportUtil", 2, "next.mProteusTemplateBean == null " + localObject);
        ((BaseArticleInfo)localObject).mProteusTemplateBean = a(paramVafContext, paramppu.b(), (BaseArticleInfo)localObject);
      }
    }
  }
  
  private static void a(ppu paramppu, ViewBase paramViewBase)
  {
    if ((paramppu != null) && (paramViewBase != null) && (paramViewBase.getNativeView() != null))
    {
      paramppu = paramppu.b();
      if ((paramppu != null) && (paramppu.mProteusTemplateBean != null))
      {
        paramppu = (ViewBean)paramppu.mProteusTemplateBean.getViewDataBinding().get("id_separator");
        if ((paramppu != null) && (paramppu.valueBean != null) && (paramppu.valueBean.normalValue != null))
        {
          paramppu = paramppu.valueBean.normalValue.get("setBackgroundColorString:");
          if (!(paramppu instanceof String)) {}
        }
      }
    }
    try
    {
      paramViewBase.getNativeView().setBackgroundColor(Color.parseColor((String)paramppu));
      return;
    }
    catch (Exception paramppu)
    {
      QLog.d("ProteusSupportUtil", 1, paramppu.getMessage());
    }
  }
  
  public static boolean a(int paramInt)
  {
    if (!oyi.a()) {}
    do
    {
      return false;
      switch (paramInt)
      {
      }
    } while (tpr.a(paramInt));
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
    blqm.a("configDivider.isDividerNormal");
    if ((b(paramInt1)) && ((b(paramInt2)) || (qht.a.a(paramArticleInfo, paramInt2) == 0))) {}
    for (boolean bool = true;; bool = false)
    {
      blqm.a();
      return bool;
    }
  }
  
  /* Error */
  public static boolean a(ArticleInfo paramArticleInfo)
  {
    // Byte code:
    //   0: ldc_w 1279
    //   3: invokestatic 152	blqm:a	(Ljava/lang/String;)V
    //   6: aload_0
    //   7: ifnull +154 -> 161
    //   10: aload_0
    //   11: getfield 1282	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:proteusItemsData	Ljava/lang/String;
    //   14: invokestatic 733	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   17: ifne +144 -> 161
    //   20: aload_0
    //   21: getfield 1285	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mFeedType	I
    //   24: bipush 29
    //   26: if_icmpeq +8 -> 34
    //   29: invokestatic 166	blqm:a	()V
    //   32: iconst_0
    //   33: ireturn
    //   34: new 459	org/json/JSONObject
    //   37: dup
    //   38: aload_0
    //   39: getfield 1282	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:proteusItemsData	Ljava/lang/String;
    //   42: invokespecial 1286	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   45: astore_0
    //   46: aload_0
    //   47: invokevirtual 813	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   50: astore_2
    //   51: aload_2
    //   52: invokeinterface 769 1 0
    //   57: ifeq +104 -> 161
    //   60: aload_2
    //   61: invokeinterface 773 1 0
    //   66: checkcast 197	java/lang/String
    //   69: astore_3
    //   70: aload_0
    //   71: aload_3
    //   72: invokevirtual 1289	org/json/JSONObject:opt	(Ljava/lang/String;)Ljava/lang/Object;
    //   75: astore 4
    //   77: ldc_w 1291
    //   80: aload_3
    //   81: invokevirtual 637	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   84: ifeq -33 -> 51
    //   87: ldc 230
    //   89: iconst_1
    //   90: iconst_2
    //   91: anewarray 4	java/lang/Object
    //   94: dup
    //   95: iconst_0
    //   96: ldc_w 1293
    //   99: aastore
    //   100: dup
    //   101: iconst_1
    //   102: aload 4
    //   104: aastore
    //   105: invokestatic 225	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   108: invokestatic 166	blqm:a	()V
    //   111: ldc_w 1295
    //   114: aload 4
    //   116: invokestatic 1298	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   119: invokevirtual 637	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   122: ifne +19 -> 141
    //   125: ldc_w 1300
    //   128: aload 4
    //   130: invokestatic 1298	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   133: invokevirtual 637	java/lang/String:equals	(Ljava/lang/Object;)Z
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
    //   154: ldc_w 1302
    //   157: aload_0
    //   158: invokestatic 1304	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   161: invokestatic 166	blqm:a	()V
    //   164: iconst_0
    //   165: ireturn
    //   166: astore_0
    //   167: ldc 230
    //   169: iconst_1
    //   170: ldc_w 1306
    //   173: aload_0
    //   174: invokestatic 1304	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
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
    if (Aladdin.getConfig(330).getIntegerFromString("isAllowLayoutErrorCheck", 0) != 1) {
      return false;
    }
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
              QQAppInterface localQQAppInterface = ozs.a();
              if (((NativeLayoutImpl)localObject).getContentDescription() == null) {
                continue;
              }
              localObject = ((NativeLayoutImpl)localObject).getContentDescription().toString();
              ocd.a(localQQAppInterface, "CliOper", "", "", "0X8009AC1", "0X8009AC1", 0, 0, "", "", "", (String)localObject, false);
              if (QLog.isColorLevel())
              {
                qak.a(paramContainer.getVirtualView(), "ProteusSupportUtil");
                qak.a(paramContainer, "ProteusSupportUtil");
              }
              QLog.e("ProteusSupportUtil", 1, "[nativeLayoutImplError] empty native layout " + paramInt);
            }
          }
          if ((QLog.isColorLevel()) && ((localView instanceof ViewGroup)))
          {
            localObject = (ViewGroup)localView;
            QLog.e("ProteusSupportUtil", 1, "ChildCount " + ((ViewGroup)localObject).getChildCount());
            break label254;
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
      label254:
      i += 1;
    }
  }
  
  public static boolean a(VafContext paramVafContext, int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    return a(paramVafContext, paramInt, paramBaseArticleInfo) != null;
  }
  
  public static boolean a(VafContext paramVafContext, String paramString)
  {
    paramString = suz.a(paramString, true);
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
  
  public static boolean a(ppu paramppu)
  {
    if (paramppu != null) {
      try
      {
        int i = paramppu.b();
        if ((i == 66) || (i == 39))
        {
          paramppu = paramppu.b();
          if ((paramppu != null) && (AdvertisementInfo.isAdvertisementInfo(paramppu)))
          {
            paramppu = ((AdvertisementInfo)paramppu).mAdExtInfo;
            if (paramppu != null)
            {
              i = new JSONObject(paramppu).optInt("is_video_new");
              return i == 1;
            }
          }
        }
      }
      catch (Exception paramppu)
      {
        QLog.d("ProteusSupportUtil", 1, "isNextCardAdBigImgOrAdVideo JSONException, e = ", paramppu);
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
        qaj.a("ProteusSupportUtil", "[getSepatatorHeight] getSepatatorHeight");
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
    paramString = suz.a(paramString, false);
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
      if ((ozs.b((ArticleInfo)paramBaseArticleInfo)) || (ozs.c((ArticleInfo)paramBaseArticleInfo))) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    case 1035: 
    case 1170: 
    case 1171: 
      return false;
    case 1044: 
      return ubd.a((ArticleInfo)paramBaseArticleInfo);
    }
    return a(paramBaseArticleInfo, paramViewBase, paramVafContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oyj
 * JD-Core Version:    0.7.0.1
 */