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
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class ozp
{
  private static double jdField_a_of_type_Double;
  private static int jdField_a_of_type_Int;
  private static final ArrayList<Integer> jdField_a_of_type_JavaUtilArrayList;
  private static final Map<Integer, qdy> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    if (jdField_a_of_type_JavaUtilMap.isEmpty())
    {
      a(3, new qeh());
      a(72, new qak());
      a(73, new qaq());
      a(74, new qec());
      a(90, new qeb());
      a(91, new qeb());
      a(75, new qec());
      a(21, new qej());
      a(22, new qej());
      a(36, new qej());
      a(23, new qej());
      a(120, new qej());
      a(80, new qej());
      a(34, new qcy());
      a(16, new qcy());
      a(17, new qcy());
      a(19, new qcy());
      a(18, new qcy());
      a(20, new qcy());
      a(65, new qcy());
      a(64, new qcy());
      a(48, new qcy());
      a(25, new qbb());
      a(24, new qbb());
      a(26, new qbb());
      a(107, new qej());
      a(108, new qbb());
      a(37, new qbb());
      a(81, new qbb());
      a(35, new qat());
      a(12, new qat());
      a(10, new qat());
      a(11, new qat());
      a(28, new qat());
      a(27, new qat());
      a(49, new qat());
      a(62, new qat());
      a(63, new qat());
      a(33, new qat());
      a(31, new qcy());
      a(32, new qcy());
      a(79, new qcv());
      a(76, new qcv());
      a(77, new qcv());
      a(78, new qcv());
      a(83, new qcy());
      a(84, new qcy());
      a(85, new qcy());
      a(86, new qcy());
      a(89, new qaj());
      a(92, new qbb());
      a(94, new qat());
      a(95, new qat());
      a(101, new qcb());
      a(102, new qcb());
      a(103, new qcb());
      a(105, new tun());
      a(66, new tud());
      a(115, new tud());
      a(39, new tuc());
      a(116, new tuf());
      a(117, new tum());
      a(106, new tul());
      a(140, new tuh());
      a(146, new tug());
      a(141, new tuk());
      a(143, new tuk());
      a(144, new tuj());
      a(145, new tui());
      a(109, new qdf());
      a(110, new qdf());
      a(111, new qdf());
      a(132, new qdf());
      a(133, new qdf());
      a(134, new qdf());
      a(112, new qat());
      a(113, new qat());
      a(114, new qat());
      a(126, new qao());
      a(2, new qan());
      a(1, new qef());
      a(121, new qbs());
      a(122, new tuc());
      a(124, new qch());
      a(125, new qch());
      a(127, new tue());
      a(129, new qcg());
      a(130, new qcf());
      a(131, new qcm());
      a(46, new qbu());
      a(123, new qcq());
      a(135, new qcd());
      a(137, new qbn());
      a(139, new qbn());
      a(138, new qbn());
      a(142, new qbf());
    }
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(0));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(1));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(2));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(3));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(5));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(47));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(60));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(39));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(66));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(50));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(51));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(52));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(53));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(96));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(103));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(102));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(101));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(104));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(105));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(106));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(116));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(122));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(117));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(121));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(126));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(115));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(124));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(125));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(127));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(140));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(141));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(129));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(130));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(136));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(46));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(142));
  }
  
  private static double a(TemplateBean paramTemplateBean)
  {
    bjun.a("getProteusSeparatorMarginLeftPx");
    if ((jdField_a_of_type_Double > 0.0D) && (paramTemplateBean != null))
    {
      syz localsyz = syz.a("default_feeds", false);
      if ((localsyz != null) && (!localsyz.a(paramTemplateBean)))
      {
        bjun.a();
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
    bjun.a();
    return jdField_a_of_type_Double;
  }
  
  private static int a(TemplateBean paramTemplateBean)
  {
    bjun.a("getProteusSeparatorHeightPx");
    if ((jdField_a_of_type_Int > 0) && (paramTemplateBean != null))
    {
      localsyz = syz.a("default_feeds", false);
      if ((localsyz != null) && (!localsyz.a(paramTemplateBean)))
      {
        bjun.a();
        qgd.a("ProteusSupportUtil", "[getProteusSeparatorHeightPx] SeparatorHeight : " + jdField_a_of_type_Int);
        return jdField_a_of_type_Int;
      }
    }
    syz localsyz = syz.a("default_feeds", false);
    paramTemplateBean = null;
    if (localsyz != null) {
      paramTemplateBean = localsyz.getTemplate("ReadInjoy_triple_img_cell");
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
        qgd.a("ProteusSupportUtil", "[getProteusSeparatorHeightPx] getSeparatorHeightPx");
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
      bjun.a();
      return jdField_a_of_type_Int;
      jdField_a_of_type_Int = Utils.dp2px(0.5D);
    }
  }
  
  public static ProteusItemView a(VafContext paramVafContext, int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    if (qge.a()) {
      qge.a("ProteusSupportUtil", "[getView] " + paramBaseArticleInfo + " adapterViewType: " + paramInt);
    }
    long l1 = System.currentTimeMillis();
    bjun.a("ProteusSupportUtil.getView");
    bjun.a("ProteusSupportUtil#getView#getTemplateBean");
    TemplateBean localTemplateBean = a(paramVafContext, paramInt, paramBaseArticleInfo);
    bjun.a();
    String str;
    if (localTemplateBean != null)
    {
      str = "[" + localTemplateBean.getStyleName() + "]";
      paramBaseArticleInfo = null;
      if ((!(paramVafContext.getTemplateFactory() instanceof syz)) || (localTemplateBean == null)) {
        break label453;
      }
    }
    label256:
    label436:
    label443:
    label453:
    for (Object localObject = ozm.a.a(((syz)paramVafContext.getTemplateFactory()).b(), localTemplateBean.getStyleName());; localObject = null)
    {
      if (localObject == null)
      {
        bjun.a(str + "#inflate");
        localObject = paramVafContext.getViewFactory().inflate(paramVafContext, localTemplateBean);
        qgd.a("ProteusSupportUtil", "[getView] inflate");
        bjun.a();
      }
      for (;;)
      {
        label240:
        long l2;
        if (localObject != null)
        {
          bjun.a(str + "#setBackgroundDrawable");
          if ((pay.r()) && (bkwm.k()))
          {
            paramInt = 1;
            paramBaseArticleInfo = paramVafContext.getContext().getResources();
            if (paramInt == 0) {
              break label436;
            }
            paramInt = 2130841732;
            ((Container)localObject).setBackgroundDrawable(paramBaseArticleInfo.getDrawable(paramInt));
            paramBaseArticleInfo = new ProteusItemView(paramVafContext.getContext());
            paramBaseArticleInfo.a((Container)localObject);
            bjun.a();
            qgd.a("ProteusSupportUtil", "[getView]  add Container ");
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            qge.a((View)localObject, "ProteusSupportUtil");
          }
          l2 = System.currentTimeMillis();
          if (localTemplateBean == null) {
            break label443;
          }
        }
        for (paramVafContext = localTemplateBean.getStyleName();; paramVafContext = "templateBean is null")
        {
          tpl.a("ProteusSupportUtil", paramVafContext, "ProteusSupportUtil.getView", l2 - l1);
          bjun.a();
          return paramBaseArticleInfo;
          qgd.a("ProteusSupportUtil", "[getView]  new proteusItemView ");
          localObject = new ProteusItemView(paramVafContext.getContext());
          ((ProteusItemView)localObject).setVisibility(8);
          QLog.i("ProteusSupportUtil", 1, "[getView] 未找到样式,请确认是否下发该卡片的样式:" + paramBaseArticleInfo + " adapterViewType: " + paramInt + "  " + paramVafContext.getTemplateFactory());
          paramBaseArticleInfo = (BaseArticleInfo)localObject;
          str = "";
          break;
          paramInt = 0;
          break label240;
          paramInt = 2130841733;
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
    //   4: ldc 173
    //   6: iconst_0
    //   7: invokestatic 178	syz:a	(Ljava/lang/String;Z)Lsyz;
    //   10: astore 4
    //   12: aload 4
    //   14: ifnonnull +506 -> 520
    //   17: aconst_null
    //   18: areturn
    //   19: aload_0
    //   20: invokevirtual 344	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/VafContext:getTemplateFactory	()Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/factory/BaseTemplateFactory;
    //   23: checkcast 175	syz
    //   26: astore 4
    //   28: invokestatic 228	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   31: ifeq +39 -> 70
    //   34: ldc 246
    //   36: iconst_2
    //   37: new 258	java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   44: ldc_w 444
    //   47: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: aload_2
    //   51: invokevirtual 315	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   54: ldc_w 446
    //   57: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: iload_1
    //   61: invokevirtual 268	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   64: invokevirtual 272	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: invokestatic 251	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   70: aload_2
    //   71: getfield 452	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mProteusTemplateBean	Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;
    //   74: ifnull +20 -> 94
    //   77: aload 4
    //   79: aload_2
    //   80: getfield 452	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mProteusTemplateBean	Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;
    //   83: invokevirtual 181	syz:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;)Z
    //   86: ifne +8 -> 94
    //   89: aload_2
    //   90: getfield 452	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mProteusTemplateBean	Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;
    //   93: areturn
    //   94: getstatic 20	ozp:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   97: iload_1
    //   98: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   101: invokeinterface 212 2 0
    //   106: checkcast 454	qdy
    //   109: astore_3
    //   110: aload_3
    //   111: ifnull +152 -> 263
    //   114: aload_3
    //   115: iload_1
    //   116: aload_2
    //   117: invokeinterface 457 3 0
    //   122: astore_0
    //   123: aload_3
    //   124: ifnull +391 -> 515
    //   127: aload_3
    //   128: iload_1
    //   129: aload_0
    //   130: invokeinterface 460 3 0
    //   135: astore_3
    //   136: aload_3
    //   137: ifnonnull +375 -> 512
    //   140: aload 4
    //   142: ifnull +310 -> 452
    //   145: aload 4
    //   147: aload_0
    //   148: invokevirtual 464	syz:getTemplateBean	(Lorg/json/JSONObject;)Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;
    //   151: astore 4
    //   153: aload 4
    //   155: astore_3
    //   156: aload_2
    //   157: aload_3
    //   158: putfield 452	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mProteusTemplateBean	Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;
    //   161: new 258	java/lang/StringBuilder
    //   164: dup
    //   165: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   168: ldc_w 466
    //   171: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: astore 4
    //   176: aload_0
    //   177: ifnull +280 -> 457
    //   180: new 258	java/lang/StringBuilder
    //   183: dup
    //   184: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   187: aload_0
    //   188: ldc_w 468
    //   191: invokevirtual 474	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   194: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: ldc_w 476
    //   200: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: aload_0
    //   204: invokevirtual 477	org/json/JSONObject:toString	()Ljava/lang/String;
    //   207: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: ldc_w 479
    //   213: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: invokevirtual 272	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   219: astore_2
    //   220: ldc 246
    //   222: iconst_2
    //   223: aload 4
    //   225: aload_2
    //   226: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: invokevirtual 272	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   232: invokestatic 251	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   235: ldc 246
    //   237: iconst_1
    //   238: new 258	java/lang/StringBuilder
    //   241: dup
    //   242: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   245: ldc_w 481
    //   248: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: aload_0
    //   252: invokevirtual 315	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   255: invokevirtual 272	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   258: invokestatic 251	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   261: aload_3
    //   262: areturn
    //   263: iload_1
    //   264: lookupswitch	default:+100->364, 1:+116->380, 5:+108->372, 29:+132->396, 34:+156->420, 40:+172->436, 41:+180->444, 42:+164->428, 47:+140->404, 60:+148->412, 96:+148->412, 104:+124->388
    //   365: invokestatic 486	qac:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   368: astore_0
    //   369: goto -246 -> 123
    //   372: aload_2
    //   373: invokestatic 489	pzu:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   376: astore_0
    //   377: goto -254 -> 123
    //   380: aload_2
    //   381: invokestatic 492	pzt:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   384: astore_0
    //   385: goto -262 -> 123
    //   388: aload_2
    //   389: invokestatic 495	pzk:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   392: astore_0
    //   393: goto -270 -> 123
    //   396: aload_2
    //   397: invokestatic 498	pzs:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   400: astore_0
    //   401: goto -278 -> 123
    //   404: aload_2
    //   405: invokestatic 501	pzm:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   408: astore_0
    //   409: goto -286 -> 123
    //   412: aload_2
    //   413: invokestatic 504	qab:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   416: astore_0
    //   417: goto -294 -> 123
    //   420: aload_2
    //   421: invokestatic 507	qad:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   424: astore_0
    //   425: goto -302 -> 123
    //   428: aload_2
    //   429: invokestatic 510	qaf:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   432: astore_0
    //   433: goto -310 -> 123
    //   436: aload_2
    //   437: invokestatic 513	qae:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   440: astore_0
    //   441: goto -318 -> 123
    //   444: aload_2
    //   445: invokestatic 516	qag:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   448: astore_0
    //   449: goto -326 -> 123
    //   452: aconst_null
    //   453: astore_3
    //   454: goto -298 -> 156
    //   457: ldc_w 437
    //   460: astore_2
    //   461: goto -241 -> 220
    //   464: astore_0
    //   465: aconst_null
    //   466: astore_3
    //   467: ldc 246
    //   469: iconst_1
    //   470: ldc_w 518
    //   473: aload_0
    //   474: invokestatic 522	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   477: goto -216 -> 261
    //   480: astore_0
    //   481: aconst_null
    //   482: astore_3
    //   483: ldc 246
    //   485: iconst_1
    //   486: ldc_w 524
    //   489: aload_0
    //   490: invokestatic 522	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
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
    if (!rbt.c(paramBaseArticleInfo))
    {
      QLog.d("ProteusSupportUtil", 1, "UGRuleManager getUGSchema is not ugCard");
      return null;
    }
    int i = rbp.jdField_a_of_type_Int;
    rbp localrbp = rbp.a();
    boolean bool = localrbp.a(paramBaseArticleInfo, true, i);
    if (bool)
    {
      str = localrbp.a(paramBaseArticleInfo, i, null, null);
      QLog.d("ProteusSupportUtil", 1, "UGRuleManager getUGSchema ugUrl is " + str);
    }
    localrbp.a(paramBaseArticleInfo, bool, true, i);
    return str;
  }
  
  private static void a()
  {
    qgd.a("ProteusSupportUtil", "resetProteusSeparatorHeightPx ");
    QLog.d("TemplateFactory", 4, "resetProteusSeparatorHeightPx");
    jdField_a_of_type_Int = 0;
  }
  
  public static void a(int paramInt, ProteusItemView paramProteusItemView, VafContext paramVafContext, FaceDecoder paramFaceDecoder, slt paramslt, pvc parampvc, BaseArticleInfo paramBaseArticleInfo)
  {
    Container localContainer = paramProteusItemView.a();
    ViewFactory.findClickableViewListener(localContainer.getVirtualView(), new ozu(paramInt, localContainer, parampvc, paramBaseArticleInfo, paramVafContext, paramProteusItemView, paramFaceDecoder, paramslt));
  }
  
  private static void a(int paramInt1, Container paramContainer, pvc parampvc, int paramInt2)
  {
    bjun.a("ProteusSupportUtil.bindView");
    if (paramContainer == null)
    {
      bjun.a();
      return;
    }
    qgd.a("ProteusSupportUtil", "[bindView]");
    Object localObject = (qdy)jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt1));
    if (localObject != null)
    {
      ((qdy)localObject).a(paramInt1, paramContainer, parampvc, paramInt2);
      bjun.a();
    }
    for (;;)
    {
      bjun.a();
      return;
      paramContainer = paramContainer.getVirtualView();
      switch (paramInt1)
      {
      default: 
        break;
      case 10: 
        localObject = (qgt)paramContainer.findViewBaseByName("id_info_avator");
        if (localObject != null) {
          ((qgt)localObject).a(parampvc);
        }
        localObject = (qje)paramContainer.findViewBaseByName("id_summary");
        if (localObject != null) {
          ((qje)localObject).a(parampvc);
        }
        localObject = (qgv)paramContainer.findViewBaseByName("id_biu_comment");
        if (localObject != null) {
          ((qgv)localObject).a(parampvc);
        }
        paramContainer = (qgx)paramContainer.findViewBaseByName("id_corner_text_image");
        if (paramContainer != null) {
          paramContainer.a(parampvc);
        }
        break;
      case 34: 
      case 40: 
      case 41: 
      case 42: 
        localObject = (qgt)paramContainer.findViewBaseByName("id_info_avator");
        if (localObject != null) {
          ((qgt)localObject).a(parampvc);
        }
        localObject = (qje)paramContainer.findViewBaseByName("id_summary");
        if (localObject != null) {
          ((qje)localObject).a(parampvc);
        }
        localObject = (qgv)paramContainer.findViewBaseByName("id_biu_comment");
        if (localObject != null) {
          ((qgv)localObject).a(parampvc);
        }
        paramContainer = (qgz)paramContainer.findViewBaseByName("id_multi_image");
        if (paramContainer != null) {
          paramContainer.a(parampvc.a());
        }
        break;
      }
    }
  }
  
  private static void a(int paramInt, qdy paramqdy)
  {
    if (paramqdy == null) {
      throw new NullPointerException();
    }
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), paramqdy);
  }
  
  public static void a(ProteusItemView paramProteusItemView, int paramInt1, BaseArticleInfo paramBaseArticleInfo, VafContext paramVafContext, FaceDecoder paramFaceDecoder, slt paramslt, pvc parampvc, int paramInt2, String paramString)
  {
    if (qge.a()) {
      qge.a("ProteusSupportUtil", "[bindData]  adapterViewType: " + paramInt1 + ", data : " + paramBaseArticleInfo);
    }
    bjun.a("ProteusSupportUtil.bindData");
    long l1 = System.currentTimeMillis();
    if ((paramProteusItemView == null) || (paramProteusItemView.a() == null))
    {
      bjun.a();
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
        break label537;
      }
      i = localTemplateBean.getId();
      if (localObject == null) {
        break label543;
      }
      j = ((TemplateBean)localObject).getId();
      label207:
      QLog.i("ProteusSupportUtil", 1, "[bindData] trigger re-inflation, adapterViewType: " + paramInt1 + " new id: " + i + " old id: " + j);
      qgd.a("ProteusSupportUtil", "[bindData] trigger re-inflation, adapterViewType: " + paramInt1 + " new id: " + i + " old id: " + j);
      paramString = paramVafContext.getViewFactory().inflate(paramVafContext, localTemplateBean);
      if (paramString != null)
      {
        paramString.setBackgroundDrawable(paramVafContext.getContext().getResources().getDrawable(2130841733));
        paramProteusItemView.d();
        paramProteusItemView.a(paramString);
        qge.a(paramString.getVirtualView(), "ProteusSupportUtil");
        qge.a(paramString, "ProteusSupportUtil");
      }
      paramBaseArticleInfo.mProteusTemplateBean = localTemplateBean;
      a();
      paramString = null;
    }
    localObject = paramProteusItemView.a();
    paramProteusItemView.setTemplateBean(localTemplateBean);
    paramProteusItemView.setModel(parampvc, paramslt.a().a());
    bjun.a("ProteusSupportUtil.bindDataImpl");
    label452:
    long l2;
    if (localTemplateBean != null)
    {
      QLog.i("ProteusSupportUtil", 1, "[bindData] bind data for " + localTemplateBean.getStyleName());
      a((Container)localObject, paramString, localTemplateBean);
      bjun.a();
      a(paramInt1, (Container)localObject, parampvc, paramInt2);
      a(paramInt1, paramProteusItemView, paramVafContext, paramFaceDecoder, paramslt, parampvc, paramBaseArticleInfo);
      bjun.a("ProteusSupportUtil.configDivider");
      a(parampvc, paramVafContext);
      a((Container)localObject, parampvc, localTemplateBean);
      bjun.a();
      l2 = System.currentTimeMillis();
      if (localTemplateBean == null) {
        break label561;
      }
    }
    label537:
    label543:
    label561:
    for (paramProteusItemView = localTemplateBean.getStyleName();; paramProteusItemView = "")
    {
      tpl.a("ProteusSupportUtil", paramProteusItemView, " ProteusSupportUtil.bindData", l2 - l1);
      bjun.a();
      return;
      i = -1;
      break;
      j = -1;
      break label207;
      QLog.d("ProteusSupportUtil", 2, "[bindData] newTemplateBean is null");
      break label452;
    }
  }
  
  public static void a(ArticleInfo paramArticleInfo)
  {
    a(null, pgb.a(paramArticleInfo), paramArticleInfo);
  }
  
  public static void a(BaseArticleInfo paramBaseArticleInfo, TemplateBean paramTemplateBean, ViewBase paramViewBase)
  {
    if ((!(paramBaseArticleInfo instanceof ArticleInfo)) || (paramTemplateBean == null)) {
      return;
    }
    String str = uhv.b(paramBaseArticleInfo.mChannelID);
    HashMap localHashMap = new HashMap();
    Map localMap = paramTemplateBean.getDataAttribute(null);
    paramTemplateBean = paramTemplateBean.getDataAttribute(paramViewBase.getViewId());
    if (localMap != null) {
      localHashMap.putAll(localMap);
    }
    if (paramTemplateBean != null) {
      localHashMap.putAll(paramTemplateBean);
    }
    ues.a((ArticleInfo)paramBaseArticleInfo, str, str, (int)paramBaseArticleInfo.mChannelID, localHashMap);
    ues.a(paramTemplateBean);
    bkwm.a(paramBaseArticleInfo);
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
    pbg localpbg = new pbg();
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
          localpbg.b(paramViewBase, localObject.toString());
        }
      }
    }
    odq.a(null, "CliOper", "", "", str, str, 0, 0, "", "", "", localpbg.a(), false);
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
      pbg localpbg = new pbg();
      Iterator localIterator = localJSONObject.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localpbg.b(str, localJSONObject.get(str).toString());
      }
      odq.a(null, "CliOper", "", "", paramViewBean, paramViewBean, 0, 0, "", "", "", localpbg.a(), false);
    }
    catch (Exception paramViewBean)
    {
      QLog.d("ProteusSupportUtil", 1, paramViewBean, new Object[] { "" });
      return;
    }
  }
  
  public static void a(Container paramContainer, TemplateBean paramTemplateBean1, TemplateBean paramTemplateBean2)
  {
    bjun.a("ProteusSupportUtil.bindDynamicValueWithoutRecursion");
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
          bjun.a("bindDynamicValueWithoutRecursion.bindDynamicVal.check");
          if ((str == null) || (localViewBase == null) || (localViewBean == null) || ((paramTemplateBean1 != null) && (localViewBean.valueBean.dynamicValue.equals(paramTemplateBean1.valueBean.dynamicValue)))) {
            break label312;
          }
          i = 1;
          label223:
          bjun.a();
          if (i == 0) {
            break label317;
          }
          localViewBean.setVisible(true);
          localViewBase.bindDynamicValue(localViewBean);
          bjun.a();
          localStringBuilder.append("[bindNewValue] bind dynamicValue: ").append(localViewBean.valueBean.dynamicValue).append(" viewId = ").append(str).append("\n");
        }
        for (;;)
        {
          if (localViewBase != null) {
            localViewBase.setVisibility(0);
          }
          bjun.a();
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
      bjun.a();
      return;
    }
  }
  
  public static void a(Container paramContainer, VafContext paramVafContext, TemplateBean paramTemplateBean)
  {
    ViewFactory.findClickableViewListener(paramContainer.getVirtualView(), new ozq(paramVafContext, paramTemplateBean));
  }
  
  public static void a(Container paramContainer, pvc parampvc, TemplateBean paramTemplateBean)
  {
    if (oza.a(paramContainer, parampvc)) {
      return;
    }
    ViewBase localViewBase1 = paramContainer.getVirtualView();
    ViewBase localViewBase2 = localViewBase1.findViewBaseByName("id_separator");
    ArticleInfo localArticleInfo = parampvc.a();
    if ((localArticleInfo == null) || (localViewBase2 == null))
    {
      QLog.d("ProteusSupportUtil", 1, "configDivider failed, articleInfo is null or divider is null.");
      return;
    }
    Layout.Params localParams = localViewBase2.getComLayoutParams();
    int m = localParams.mLayoutHeight;
    int j = Utils.dp2px(5.0D);
    double d = Utils.dp2px(6.0D);
    int i = parampvc.a();
    int k = parampvc.b();
    if (localArticleInfo.mChannelID == 70L)
    {
      bjun.a("configDivider.FollowFeeds");
      localParams.mLayoutMarginLeft = 0;
      localParams.mLayoutMarginRight = 0;
      localParams.mLayoutWidth = -1;
      i = Utils.dp2px(5.0D);
      bjun.a();
    }
    for (;;)
    {
      localParams.mLayoutHeight = i;
      localViewBase2.setComLayoutParams(localParams);
      parampvc = localViewBase1.getComLayoutParams();
      if (parampvc.mLayoutHeight >= 0) {
        parampvc.mLayoutHeight = (i - m + parampvc.mLayoutHeight);
      }
      parampvc = localViewBase1.getComLayoutParams();
      paramContainer.setLayoutParams(new RelativeLayout.LayoutParams(parampvc.mLayoutWidth, parampvc.mLayoutHeight));
      return;
      if (pcl.c((int)localArticleInfo.mChannelID))
      {
        bjun.a("configDivider.DailyFeeds");
        parampvc = parampvc.b();
        j = 0;
        k = 0;
        i = k;
        if (parampvc != null)
        {
          i = k;
          if (parampvc.mProteusTemplateBean != null)
          {
            if (parampvc.mProteusTemplateBean.getDataAttribute(null, "position_jump") == null) {
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
          bjun.a();
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
      else if ((a(parampvc.b())) || (a(parampvc)))
      {
        i = 0;
        localParams.mLayoutMarginLeft = 0;
        localParams.mLayoutMarginRight = 0;
        localParams.mLayoutWidth = -1;
      }
      else if (a(i, k, parampvc.b()))
      {
        bjun.a("configDivider.normal");
        bjun.a("configDivider.normal.getProteusSeparatorHeightPx");
        i = a(paramTemplateBean);
        bjun.a();
        bjun.a("configDivider.normal.getProteusSeparatorMarginLeftPx");
        d = a(paramTemplateBean);
        bjun.a();
        j = Utils.dp2px(d);
        localParams.mLayoutMarginRight = j;
        localParams.mLayoutMarginLeft = j;
        localParams.mLayoutWidth = -1;
        bjun.a();
      }
      else
      {
        localParams.mLayoutMarginLeft = 0;
        localParams.mLayoutMarginRight = 0;
        localParams.mLayoutWidth = -1;
        i = j;
        if (!b(k))
        {
          a(parampvc, localViewBase2);
          i = j;
        }
      }
    }
  }
  
  public static void a(VafContext paramVafContext, String paramString)
  {
    paramVafContext.setTemplateFactory(syz.a(paramString, true));
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyLikeButton", new qhv());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyAvatarView", new qgu());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyVariableImageContentView", new qha());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoySummaryView", new qjf());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyCommentView", new qgs());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyBiuCommentView", new qgw());
    paramVafContext.getViewFactory().registerViewBuilder("CornerTextImageView", new qgy());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyMiddleBodyView", new qia());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyUsersCommentView", new qjh());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyFriendsBiu", new qhp());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyQARichView", new NativeText.Builder());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyBiuButton", new qhk());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyCoordinateView", new qhn());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoySocializeRecommendFollowView", new qim());
    paramVafContext.getViewFactory().registerViewBuilder("UILabel", new qjd());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInjoyAsynImageView", new qiw());
    paramVafContext.getViewFactory().registerViewBuilder("UIImageView", new qiw());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInjoyAsynImageIcon", new qiu());
    paramVafContext.getViewFactory().registerViewBuilder("ProteusCollectionView", new qkq());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyAdVideoGuide", new qhh());
    paramVafContext.getViewFactory().registerViewBuilder("PTSAvatarView", new oxu());
    paramVafContext.getViewFactory().registerViewBuilder("QQAvatarView", new oxu());
    paramVafContext.getViewFactory().registerViewBuilder("RIJCommentRichTextView", new oyf());
    paramVafContext.getViewFactory().registerViewBuilder("QQRIJRichTextView", new oxw());
    paramVafContext.getViewFactory().registerViewBuilder("QQRIJCommentLikeButton", new oxy());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyExposeReplyCommentView", new oyh());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyAwesomeCommentView", new qhj());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyAdDownloadView", new tzb());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyAdLocationView", new qhf());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyIconText", new tzt());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInjoyDoubleImageView", new uac());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyBlurImageView", new tzr());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInjoyTripleImageInteractView", new uae());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyAdInnerOperateView", new tzd());
    paramVafContext.getViewFactory().registerViewBuilder("ProteusTickerView", new qhc());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInjoyShareView", new qic());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInjoyApngImageView", new qis());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyAdBrandOptimizationView", new tyw());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInjoyProgressView", new qiz());
    paramVafContext.getViewFactory().registerViewBuilder("RIJCommentLinksView", new oym());
    a();
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyArticleBottomVideoView", new tzo());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyVideoView", new qiq());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyGifView", new qhr());
    paramVafContext.getViewFactory().registerViewBuilder("ProteusMarqueeLabel", new NativeText.Builder());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyLinkClickableLabel", new qjd());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyLottieView", new qhy());
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
      qgd.a("ProteusSupportUtil", "[bindDynamicValue]");
    }
  }
  
  private static void a(pvc parampvc, VafContext paramVafContext)
  {
    Object localObject = parampvc.a();
    if (localObject != null)
    {
      localObject = ((slt)localObject).b(parampvc.g() + 1);
      if ((localObject != null) && (((BaseArticleInfo)localObject).mProteusTemplateBean == null))
      {
        QLog.d("ProteusSupportUtil", 2, "next.mProteusTemplateBean == null " + localObject);
        ((BaseArticleInfo)localObject).mProteusTemplateBean = a(paramVafContext, parampvc.b(), (BaseArticleInfo)localObject);
      }
    }
  }
  
  private static void a(pvc parampvc, ViewBase paramViewBase)
  {
    if ((parampvc != null) && (paramViewBase != null) && (paramViewBase.getNativeView() != null))
    {
      parampvc = parampvc.b();
      if ((parampvc != null) && (parampvc.mProteusTemplateBean != null))
      {
        parampvc = (ViewBean)parampvc.mProteusTemplateBean.getViewDataBinding().get("id_separator");
        if ((parampvc != null) && (parampvc.valueBean != null) && (parampvc.valueBean.normalValue != null))
        {
          parampvc = parampvc.valueBean.normalValue.get("setBackgroundColorString:");
          if (!(parampvc instanceof String)) {}
        }
      }
    }
    try
    {
      paramViewBase.getNativeView().setBackgroundColor(Color.parseColor((String)parampvc));
      return;
    }
    catch (Exception parampvc)
    {
      QLog.d("ProteusSupportUtil", 1, parampvc.getMessage());
    }
  }
  
  public static boolean a(int paramInt)
  {
    if (!ozo.a()) {}
    do
    {
      return false;
      switch (paramInt)
      {
      }
    } while (twj.a(paramInt));
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
    bjun.a("configDivider.isDividerNormal");
    if ((b(paramInt1)) && ((b(paramInt2)) || (qnw.a.a(paramArticleInfo, paramInt2) == 0))) {}
    for (boolean bool = true;; bool = false)
    {
      bjun.a();
      return bool;
    }
  }
  
  /* Error */
  public static boolean a(ArticleInfo paramArticleInfo)
  {
    // Byte code:
    //   0: ldc_w 1297
    //   3: invokestatic 169	bjun:a	(Ljava/lang/String;)V
    //   6: aload_0
    //   7: ifnull +154 -> 161
    //   10: aload_0
    //   11: getfield 1300	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:proteusItemsData	Ljava/lang/String;
    //   14: invokestatic 746	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   17: ifne +144 -> 161
    //   20: aload_0
    //   21: getfield 1303	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mFeedType	I
    //   24: bipush 29
    //   26: if_icmpeq +8 -> 34
    //   29: invokestatic 183	bjun:a	()V
    //   32: iconst_0
    //   33: ireturn
    //   34: new 470	org/json/JSONObject
    //   37: dup
    //   38: aload_0
    //   39: getfield 1300	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:proteusItemsData	Ljava/lang/String;
    //   42: invokespecial 1304	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   45: astore_0
    //   46: aload_0
    //   47: invokevirtual 826	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   50: astore_2
    //   51: aload_2
    //   52: invokeinterface 782 1 0
    //   57: ifeq +104 -> 161
    //   60: aload_2
    //   61: invokeinterface 786 1 0
    //   66: checkcast 214	java/lang/String
    //   69: astore_3
    //   70: aload_0
    //   71: aload_3
    //   72: invokevirtual 1307	org/json/JSONObject:opt	(Ljava/lang/String;)Ljava/lang/Object;
    //   75: astore 4
    //   77: ldc_w 1309
    //   80: aload_3
    //   81: invokevirtual 648	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   84: ifeq -33 -> 51
    //   87: ldc 246
    //   89: iconst_1
    //   90: iconst_2
    //   91: anewarray 4	java/lang/Object
    //   94: dup
    //   95: iconst_0
    //   96: ldc_w 1311
    //   99: aastore
    //   100: dup
    //   101: iconst_1
    //   102: aload 4
    //   104: aastore
    //   105: invokestatic 241	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   108: invokestatic 183	bjun:a	()V
    //   111: ldc_w 1313
    //   114: aload 4
    //   116: invokestatic 1316	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   119: invokevirtual 648	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   122: ifne +19 -> 141
    //   125: ldc_w 1318
    //   128: aload 4
    //   130: invokestatic 1316	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   133: invokevirtual 648	java/lang/String:equals	(Ljava/lang/Object;)Z
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
    //   151: ldc 246
    //   153: iconst_1
    //   154: ldc_w 1320
    //   157: aload_0
    //   158: invokestatic 1322	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   161: invokestatic 183	bjun:a	()V
    //   164: iconst_0
    //   165: ireturn
    //   166: astore_0
    //   167: ldc 246
    //   169: iconst_1
    //   170: ldc_w 1324
    //   173: aload_0
    //   174: invokestatic 1322	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
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
              QQAppInterface localQQAppInterface = pay.a();
              if (((NativeLayoutImpl)localObject).getContentDescription() == null) {
                continue;
              }
              localObject = ((NativeLayoutImpl)localObject).getContentDescription().toString();
              odq.a(localQQAppInterface, "CliOper", "", "", "0X8009AC1", "0X8009AC1", 0, 0, "", "", "", (String)localObject, false);
              if (QLog.isColorLevel())
              {
                qge.a(paramContainer.getVirtualView(), "ProteusSupportUtil");
                qge.a(paramContainer, "ProteusSupportUtil");
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
    paramString = syz.a(paramString, true);
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
  
  public static boolean a(pvc parampvc)
  {
    if (parampvc != null) {
      try
      {
        int i = parampvc.b();
        if ((i == 66) || (i == 39))
        {
          parampvc = parampvc.b();
          if ((parampvc != null) && (AdvertisementInfo.isAdvertisementInfo(parampvc)))
          {
            parampvc = ((AdvertisementInfo)parampvc).mAdExtInfo;
            if (parampvc != null)
            {
              i = new JSONObject(parampvc).optInt("is_video_new");
              return i == 1;
            }
          }
        }
      }
      catch (Exception parampvc)
      {
        QLog.d("ProteusSupportUtil", 1, "isNextCardAdBigImgOrAdVideo JSONException, e = ", parampvc);
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
        qgd.a("ProteusSupportUtil", "[getSepatatorHeight] getSepatatorHeight");
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
    paramString = syz.a(paramString, false);
    if ((paramString != null) && (paramVafContext.getTemplateFactory() != paramString)) {
      paramVafContext.setTemplateFactory(paramString);
    }
  }
  
  public static boolean b(int paramInt)
  {
    if (jdField_a_of_type_JavaUtilArrayList.contains(Integer.valueOf(paramInt))) {}
    while (paramInt >= 147) {
      return true;
    }
    return false;
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
      if ((pay.c((ArticleInfo)paramBaseArticleInfo)) || (pay.d((ArticleInfo)paramBaseArticleInfo))) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    case 1035: 
    case 1170: 
    case 1171: 
      return false;
    case 1044: 
      return uhs.a((ArticleInfo)paramBaseArticleInfo);
    }
    return a(paramBaseArticleInfo, paramViewBase, paramVafContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ozp
 * JD-Core Version:    0.7.0.1
 */