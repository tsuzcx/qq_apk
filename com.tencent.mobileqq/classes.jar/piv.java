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

public class piv
{
  private static double jdField_a_of_type_Double;
  private static int jdField_a_of_type_Int;
  private static final ArrayList<Integer> jdField_a_of_type_JavaUtilArrayList;
  private static final Map<Integer, qqa> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    if (jdField_a_of_type_JavaUtilMap.isEmpty())
    {
      a(3, new qqj());
      a(72, new qmo());
      a(73, new qmu());
      a(74, new qqe());
      a(90, new qqd());
      a(91, new qqd());
      a(75, new qqe());
      a(21, new qql());
      a(22, new qql());
      a(36, new qql());
      a(23, new qql());
      a(120, new qql());
      a(80, new qql());
      a(34, new qpa());
      a(16, new qpa());
      a(17, new qpa());
      a(19, new qpa());
      a(18, new qpa());
      a(20, new qpa());
      a(65, new qpa());
      a(64, new qpa());
      a(48, new qpa());
      a(25, new qnf());
      a(24, new qnf());
      a(26, new qnf());
      a(107, new qql());
      a(108, new qnf());
      a(37, new qnf());
      a(81, new qnf());
      a(35, new qmx());
      a(12, new qmx());
      a(10, new qmx());
      a(11, new qmx());
      a(28, new qmx());
      a(27, new qmx());
      a(49, new qmx());
      a(62, new qmx());
      a(63, new qmx());
      a(33, new qmx());
      a(31, new qpa());
      a(32, new qpa());
      a(79, new qox());
      a(76, new qox());
      a(77, new qox());
      a(78, new qox());
      a(83, new qpa());
      a(84, new qpa());
      a(85, new qpa());
      a(86, new qpa());
      a(89, new qmn());
      a(92, new qnf());
      a(94, new qmx());
      a(95, new qmx());
      a(101, new qod());
      a(102, new qod());
      a(103, new qod());
      a(105, new uit());
      a(66, new uik());
      a(115, new uik());
      a(39, new uij());
      a(116, new uim());
      a(106, new uis());
      a(140, new uio());
      a(146, new uin());
      a(141, new uir());
      a(143, new uir());
      a(144, new uiq());
      a(145, new uip());
      a(109, new qph());
      a(110, new qph());
      a(111, new qph());
      a(132, new qph());
      a(133, new qph());
      a(134, new qph());
      a(112, new qmx());
      a(113, new qmx());
      a(114, new qmx());
      a(126, new qms());
      a(2, new qmr());
      a(1, new qqh());
      a(121, new qnu());
      a(124, new qoj());
      a(125, new qoj());
      a(127, new uil());
      a(129, new qoi());
      a(130, new qoh());
      a(131, new qoo());
      a(46, new qnw());
      a(123, new qos());
      a(135, new qof());
      a(137, new qnp());
      a(139, new qnp());
      a(138, new qnp());
      a(142, new qnj());
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
    blfz.a("getProteusSeparatorMarginLeftPx");
    if ((jdField_a_of_type_Double > 0.0D) && (paramTemplateBean != null))
    {
      tmh localtmh = tmh.a("default_feeds", false);
      if ((localtmh != null) && (!localtmh.a(paramTemplateBean)))
      {
        blfz.a();
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
    blfz.a();
    return jdField_a_of_type_Double;
  }
  
  private static int a(TemplateBean paramTemplateBean)
  {
    blfz.a("getProteusSeparatorHeightPx");
    if ((jdField_a_of_type_Int > 0) && (paramTemplateBean != null))
    {
      localtmh = tmh.a("default_feeds", false);
      if ((localtmh != null) && (!localtmh.a(paramTemplateBean)))
      {
        blfz.a();
        qsg.a("ProteusSupportUtil", "[getProteusSeparatorHeightPx] SeparatorHeight : " + jdField_a_of_type_Int);
        return jdField_a_of_type_Int;
      }
    }
    tmh localtmh = tmh.a("default_feeds", false);
    paramTemplateBean = null;
    if (localtmh != null) {
      paramTemplateBean = localtmh.getTemplate("ReadInjoy_triple_img_cell");
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
        qsg.a("ProteusSupportUtil", "[getProteusSeparatorHeightPx] getSeparatorHeightPx");
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
      blfz.a();
      return jdField_a_of_type_Int;
      jdField_a_of_type_Int = Utils.dp2px(0.5D);
    }
  }
  
  public static ProteusItemView a(VafContext paramVafContext, int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    if (qsh.a()) {
      qsh.a("ProteusSupportUtil", "[getView] " + paramBaseArticleInfo + " adapterViewType: " + paramInt);
    }
    long l1 = System.currentTimeMillis();
    blfz.a("ProteusSupportUtil.getView");
    blfz.a("ProteusSupportUtil#getView#getTemplateBean");
    TemplateBean localTemplateBean = a(paramVafContext, paramInt, paramBaseArticleInfo);
    blfz.a();
    String str;
    if (localTemplateBean != null)
    {
      str = "[" + localTemplateBean.getStyleName() + "]";
      paramBaseArticleInfo = null;
      if ((!(paramVafContext.getTemplateFactory() instanceof tmh)) || (localTemplateBean == null)) {
        break label458;
      }
    }
    label256:
    label441:
    label448:
    label458:
    for (Object localObject = pis.a.a(((tmh)paramVafContext.getTemplateFactory()).b(), localTemplateBean.getStyleName());; localObject = null)
    {
      if (localObject == null)
      {
        blfz.a(str + "#inflate");
        localObject = paramVafContext.getViewFactory().inflate(paramVafContext, localTemplateBean);
        qsg.a("ProteusSupportUtil", "[getView] inflate");
        blfz.a();
      }
      for (;;)
      {
        label240:
        long l2;
        if (localObject != null)
        {
          blfz.a(str + "#setBackgroundDrawable");
          if ((pqt.d()) && (bmhv.n()))
          {
            paramInt = 1;
            paramBaseArticleInfo = paramVafContext.getContext().getResources();
            if (paramInt == 0) {
              break label441;
            }
            paramInt = 2130841742;
            ((Container)localObject).setBackgroundDrawable(paramBaseArticleInfo.getDrawable(paramInt));
            paramBaseArticleInfo = new ProteusItemView(paramVafContext.getContext());
            paramBaseArticleInfo.a((Container)localObject);
            blfz.a();
            qsg.a("ProteusSupportUtil", "[getView]  add Container ");
          }
        }
        else
        {
          if ((QLog.isColorLevel()) && (localObject != null)) {
            qsh.a((View)localObject, "ProteusSupportUtil");
          }
          l2 = System.currentTimeMillis();
          if (localTemplateBean == null) {
            break label448;
          }
        }
        for (paramVafContext = localTemplateBean.getStyleName();; paramVafContext = "templateBean is null")
        {
          uda.a("ProteusSupportUtil", paramVafContext, "ProteusSupportUtil.getView", l2 - l1);
          blfz.a();
          return paramBaseArticleInfo;
          qsg.a("ProteusSupportUtil", "[getView]  new proteusItemView ");
          localObject = new ProteusItemView(paramVafContext.getContext());
          ((ProteusItemView)localObject).setVisibility(8);
          QLog.i("ProteusSupportUtil", 1, "[getView] 未找到样式,请确认是否下发该卡片的样式:" + paramBaseArticleInfo + " adapterViewType: " + paramInt + "  " + paramVafContext.getTemplateFactory());
          paramBaseArticleInfo = (BaseArticleInfo)localObject;
          str = "";
          break;
          paramInt = 0;
          break label240;
          paramInt = 2130841743;
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
    //   4: ldc 170
    //   6: iconst_0
    //   7: invokestatic 175	tmh:a	(Ljava/lang/String;Z)Ltmh;
    //   10: astore 4
    //   12: aload 4
    //   14: ifnonnull +506 -> 520
    //   17: aconst_null
    //   18: areturn
    //   19: aload_0
    //   20: invokevirtual 341	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/VafContext:getTemplateFactory	()Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/factory/BaseTemplateFactory;
    //   23: checkcast 172	tmh
    //   26: astore 4
    //   28: invokestatic 225	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   31: ifeq +39 -> 70
    //   34: ldc 243
    //   36: iconst_2
    //   37: new 255	java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial 256	java/lang/StringBuilder:<init>	()V
    //   44: ldc_w 440
    //   47: invokevirtual 262	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: aload_2
    //   51: invokevirtual 312	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   54: ldc_w 442
    //   57: invokevirtual 262	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: iload_1
    //   61: invokevirtual 265	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   64: invokevirtual 269	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: invokestatic 248	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   70: aload_2
    //   71: getfield 448	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mProteusTemplateBean	Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;
    //   74: ifnull +20 -> 94
    //   77: aload 4
    //   79: aload_2
    //   80: getfield 448	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mProteusTemplateBean	Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;
    //   83: invokevirtual 178	tmh:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;)Z
    //   86: ifne +8 -> 94
    //   89: aload_2
    //   90: getfield 448	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mProteusTemplateBean	Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;
    //   93: areturn
    //   94: getstatic 20	piv:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   97: iload_1
    //   98: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   101: invokeinterface 209 2 0
    //   106: checkcast 450	qqa
    //   109: astore_3
    //   110: aload_3
    //   111: ifnull +152 -> 263
    //   114: aload_3
    //   115: iload_1
    //   116: aload_2
    //   117: invokeinterface 453 3 0
    //   122: astore_0
    //   123: aload_3
    //   124: ifnull +391 -> 515
    //   127: aload_3
    //   128: iload_1
    //   129: aload_0
    //   130: invokeinterface 456 3 0
    //   135: astore_3
    //   136: aload_3
    //   137: ifnonnull +375 -> 512
    //   140: aload 4
    //   142: ifnull +310 -> 452
    //   145: aload 4
    //   147: aload_0
    //   148: invokevirtual 460	tmh:getTemplateBean	(Lorg/json/JSONObject;)Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;
    //   151: astore 4
    //   153: aload 4
    //   155: astore_3
    //   156: aload_2
    //   157: aload_3
    //   158: putfield 448	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mProteusTemplateBean	Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;
    //   161: new 255	java/lang/StringBuilder
    //   164: dup
    //   165: invokespecial 256	java/lang/StringBuilder:<init>	()V
    //   168: ldc_w 462
    //   171: invokevirtual 262	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: astore 4
    //   176: aload_0
    //   177: ifnull +280 -> 457
    //   180: new 255	java/lang/StringBuilder
    //   183: dup
    //   184: invokespecial 256	java/lang/StringBuilder:<init>	()V
    //   187: aload_0
    //   188: ldc_w 464
    //   191: invokevirtual 470	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   194: invokevirtual 262	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: ldc_w 472
    //   200: invokevirtual 262	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: aload_0
    //   204: invokevirtual 473	org/json/JSONObject:toString	()Ljava/lang/String;
    //   207: invokevirtual 262	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: ldc_w 475
    //   213: invokevirtual 262	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: invokevirtual 269	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   219: astore_2
    //   220: ldc 243
    //   222: iconst_2
    //   223: aload 4
    //   225: aload_2
    //   226: invokevirtual 262	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: invokevirtual 269	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   232: invokestatic 248	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   235: ldc 243
    //   237: iconst_1
    //   238: new 255	java/lang/StringBuilder
    //   241: dup
    //   242: invokespecial 256	java/lang/StringBuilder:<init>	()V
    //   245: ldc_w 477
    //   248: invokevirtual 262	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: aload_0
    //   252: invokevirtual 312	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   255: invokevirtual 269	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   258: invokestatic 248	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   261: aload_3
    //   262: areturn
    //   263: iload_1
    //   264: lookupswitch	default:+100->364, 1:+116->380, 5:+108->372, 29:+132->396, 34:+156->420, 40:+172->436, 41:+180->444, 42:+164->428, 47:+140->404, 60:+148->412, 96:+148->412, 104:+124->388
    //   365: invokestatic 482	qmg:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   368: astore_0
    //   369: goto -246 -> 123
    //   372: aload_2
    //   373: invokestatic 485	qlz:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   376: astore_0
    //   377: goto -254 -> 123
    //   380: aload_2
    //   381: invokestatic 488	qly:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   384: astore_0
    //   385: goto -262 -> 123
    //   388: aload_2
    //   389: invokestatic 491	qlp:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   392: astore_0
    //   393: goto -270 -> 123
    //   396: aload_2
    //   397: invokestatic 494	qlx:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   400: astore_0
    //   401: goto -278 -> 123
    //   404: aload_2
    //   405: invokestatic 497	qlr:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   408: astore_0
    //   409: goto -286 -> 123
    //   412: aload_2
    //   413: invokestatic 500	qmf:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   416: astore_0
    //   417: goto -294 -> 123
    //   420: aload_2
    //   421: invokestatic 503	qmh:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   424: astore_0
    //   425: goto -302 -> 123
    //   428: aload_2
    //   429: invokestatic 506	qmj:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   432: astore_0
    //   433: goto -310 -> 123
    //   436: aload_2
    //   437: invokestatic 509	qmi:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   440: astore_0
    //   441: goto -318 -> 123
    //   444: aload_2
    //   445: invokestatic 512	qmk:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   448: astore_0
    //   449: goto -326 -> 123
    //   452: aconst_null
    //   453: astore_3
    //   454: goto -298 -> 156
    //   457: ldc_w 433
    //   460: astore_2
    //   461: goto -241 -> 220
    //   464: astore_0
    //   465: aconst_null
    //   466: astore_3
    //   467: ldc 243
    //   469: iconst_1
    //   470: ldc_w 514
    //   473: aload_0
    //   474: invokestatic 518	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   477: goto -216 -> 261
    //   480: astore_0
    //   481: aconst_null
    //   482: astore_3
    //   483: ldc 243
    //   485: iconst_1
    //   486: ldc_w 520
    //   489: aload_0
    //   490: invokestatic 518	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
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
    if (!rnz.c(paramBaseArticleInfo))
    {
      QLog.d("ProteusSupportUtil", 1, "UGRuleManager getUGSchema is not ugCard");
      return null;
    }
    int i = rnv.jdField_a_of_type_Int;
    rnv localrnv = rnv.a();
    boolean bool = localrnv.a(paramBaseArticleInfo, true, i);
    if (bool)
    {
      str = localrnv.a(paramBaseArticleInfo, i, null, null);
      QLog.d("ProteusSupportUtil", 1, "UGRuleManager getUGSchema ugUrl is " + str);
    }
    localrnv.a(paramBaseArticleInfo, bool, true, i);
    return str;
  }
  
  private static void a()
  {
    qsg.a("ProteusSupportUtil", "resetProteusSeparatorHeightPx ");
    QLog.d("TemplateFactory", 4, "resetProteusSeparatorHeightPx");
    jdField_a_of_type_Int = 0;
  }
  
  public static void a(int paramInt, ProteusItemView paramProteusItemView, VafContext paramVafContext, FaceDecoder paramFaceDecoder, szd paramszd, qfw paramqfw, BaseArticleInfo paramBaseArticleInfo)
  {
    Container localContainer = paramProteusItemView.a();
    ViewFactory.findClickableViewListener(localContainer.getVirtualView(), new pja(paramInt, localContainer, paramqfw, paramBaseArticleInfo, paramVafContext, paramProteusItemView, paramFaceDecoder, paramszd));
  }
  
  private static void a(int paramInt1, Container paramContainer, qfw paramqfw, int paramInt2)
  {
    blfz.a("ProteusSupportUtil.bindView");
    if (paramContainer == null)
    {
      blfz.a();
      return;
    }
    qsg.a("ProteusSupportUtil", "[bindView]");
    Object localObject = (qqa)jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt1));
    if (localObject != null)
    {
      ((qqa)localObject).a(paramInt1, paramContainer, paramqfw, paramInt2);
      blfz.a();
    }
    for (;;)
    {
      blfz.a();
      return;
      paramContainer = paramContainer.getVirtualView();
      switch (paramInt1)
      {
      default: 
        break;
      case 10: 
        localObject = (qsw)paramContainer.findViewBaseByName("id_info_avator");
        if (localObject != null) {
          ((qsw)localObject).a(paramqfw);
        }
        localObject = (qvj)paramContainer.findViewBaseByName("id_summary");
        if (localObject != null) {
          ((qvj)localObject).a(paramqfw);
        }
        localObject = (qsy)paramContainer.findViewBaseByName("id_biu_comment");
        if (localObject != null) {
          ((qsy)localObject).a(paramqfw);
        }
        paramContainer = (qta)paramContainer.findViewBaseByName("id_corner_text_image");
        if (paramContainer != null) {
          paramContainer.a(paramqfw);
        }
        break;
      case 34: 
      case 40: 
      case 41: 
      case 42: 
        localObject = (qsw)paramContainer.findViewBaseByName("id_info_avator");
        if (localObject != null) {
          ((qsw)localObject).a(paramqfw);
        }
        localObject = (qvj)paramContainer.findViewBaseByName("id_summary");
        if (localObject != null) {
          ((qvj)localObject).a(paramqfw);
        }
        localObject = (qsy)paramContainer.findViewBaseByName("id_biu_comment");
        if (localObject != null) {
          ((qsy)localObject).a(paramqfw);
        }
        paramContainer = (qtc)paramContainer.findViewBaseByName("id_multi_image");
        if (paramContainer != null) {
          paramContainer.a(paramqfw.a());
        }
        break;
      }
    }
  }
  
  private static void a(int paramInt, qqa paramqqa)
  {
    if (paramqqa == null) {
      throw new NullPointerException();
    }
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), paramqqa);
  }
  
  public static void a(ProteusItemView paramProteusItemView, int paramInt1, BaseArticleInfo paramBaseArticleInfo, VafContext paramVafContext, FaceDecoder paramFaceDecoder, szd paramszd, qfw paramqfw, int paramInt2, String paramString)
  {
    if (qsh.a()) {
      qsh.a("ProteusSupportUtil", "[bindData]  adapterViewType: " + paramInt1 + ", data : " + paramBaseArticleInfo);
    }
    blfz.a("ProteusSupportUtil.bindData");
    long l1 = System.currentTimeMillis();
    if ((paramProteusItemView == null) || (paramProteusItemView.a() == null))
    {
      blfz.a();
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
      qsg.a("ProteusSupportUtil", "[bindData] trigger re-inflation, adapterViewType: " + paramInt1 + " new id: " + i + " old id: " + j);
      paramString = paramVafContext.getViewFactory().inflate(paramVafContext, localTemplateBean);
      if (paramString != null)
      {
        paramString.setBackgroundDrawable(paramVafContext.getContext().getResources().getDrawable(2130841743));
        paramProteusItemView.d();
        paramProteusItemView.a(paramString);
        qsh.a(paramString.getVirtualView(), "ProteusSupportUtil");
        qsh.a(paramString, "ProteusSupportUtil");
      }
      paramBaseArticleInfo.mProteusTemplateBean = localTemplateBean;
      a();
      paramString = null;
    }
    localObject = paramProteusItemView.a();
    paramProteusItemView.setTemplateBean(localTemplateBean);
    paramProteusItemView.setModel(paramqfw, paramszd.a().a());
    blfz.a("ProteusSupportUtil.bindDataImpl");
    label452:
    long l2;
    if (localTemplateBean != null)
    {
      QLog.i("ProteusSupportUtil", 1, "[bindData] bind data for " + localTemplateBean.getStyleName());
      a((Container)localObject, paramString, localTemplateBean);
      blfz.a();
      a(paramInt1, (Container)localObject, paramqfw, paramInt2);
      a(paramInt1, paramProteusItemView, paramVafContext, paramFaceDecoder, paramszd, paramqfw, paramBaseArticleInfo);
      blfz.a("ProteusSupportUtil.configDivider");
      a(paramqfw, paramVafContext);
      a((Container)localObject, paramqfw, localTemplateBean);
      blfz.a();
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
      uda.a("ProteusSupportUtil", paramProteusItemView, " ProteusSupportUtil.bindData", l2 - l1);
      blfz.a();
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
    a(null, ppe.a(paramArticleInfo), paramArticleInfo);
  }
  
  public static void a(BaseArticleInfo paramBaseArticleInfo, TemplateBean paramTemplateBean, ViewBase paramViewBase)
  {
    if ((!(paramBaseArticleInfo instanceof ArticleInfo)) || (paramTemplateBean == null)) {
      return;
    }
    String str = uvs.b(paramBaseArticleInfo.mChannelID);
    HashMap localHashMap = new HashMap();
    Map localMap = paramTemplateBean.getDataAttribute(null);
    paramTemplateBean = paramTemplateBean.getDataAttribute(paramViewBase.getViewId());
    if (localMap != null) {
      localHashMap.putAll(localMap);
    }
    if (paramTemplateBean != null) {
      localHashMap.putAll(paramTemplateBean);
    }
    usp.a((ArticleInfo)paramBaseArticleInfo, str, str, (int)paramBaseArticleInfo.mChannelID, localHashMap);
    usp.a(paramTemplateBean);
    bmhv.a(paramBaseArticleInfo);
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
    pqg localpqg = new pqg();
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
          localpqg.b(paramViewBase, localObject.toString());
        }
      }
    }
    olh.a(null, "CliOper", "", "", str, str, 0, 0, "", "", "", localpqg.a(), false);
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
      pqg localpqg = new pqg();
      Iterator localIterator = localJSONObject.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localpqg.b(str, localJSONObject.get(str).toString());
      }
      olh.a(null, "CliOper", "", "", paramViewBean, paramViewBean, 0, 0, "", "", "", localpqg.a(), false);
    }
    catch (Exception paramViewBean)
    {
      QLog.d("ProteusSupportUtil", 1, paramViewBean, new Object[] { "" });
      return;
    }
  }
  
  public static void a(Container paramContainer, TemplateBean paramTemplateBean1, TemplateBean paramTemplateBean2)
  {
    if (paramTemplateBean2 == null)
    {
      QLog.d("ProteusSupportUtil", 1, new Object[] { "[bindDynamicValueWithoutRecursion", "newTemplateBean == null", "return" });
      return;
    }
    blfz.a("ProteusSupportUtil.bindDynamicValueWithoutRecursion");
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
        label187:
        ViewBase localViewBase;
        label206:
        int i;
        if (paramContainer != null)
        {
          paramTemplateBean1 = (ViewBean)paramContainer.get(str);
          if (localMap1 == null) {
            break label339;
          }
          localViewBase = (ViewBase)localMap1.get(str);
          blfz.a("bindDynamicValueWithoutRecursion.bindDynamicVal.check");
          if ((str == null) || (localViewBase == null) || (localViewBean == null) || ((paramTemplateBean1 != null) && (localViewBean.valueBean.dynamicValue.equals(paramTemplateBean1.valueBean.dynamicValue)))) {
            break label345;
          }
          i = 1;
          label256:
          blfz.a();
          if (i == 0) {
            break label350;
          }
          localViewBean.setVisible(true);
          localViewBase.bindDynamicValue(localViewBean);
          blfz.a();
          localStringBuilder.append("[bindNewValue] bind dynamicValue: ").append(localViewBean.valueBean.dynamicValue).append(" viewId = ").append(str).append("\n");
        }
        for (;;)
        {
          if (localViewBase != null) {
            localViewBase.setVisibility(0);
          }
          blfz.a();
          break;
          paramTemplateBean1 = null;
          break label187;
          label339:
          localViewBase = null;
          break label206;
          label345:
          i = 0;
          break label256;
          label350:
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
      blfz.a();
      return;
    }
  }
  
  public static void a(Container paramContainer, VafContext paramVafContext, TemplateBean paramTemplateBean)
  {
    ViewFactory.findClickableViewListener(paramContainer.getVirtualView(), new piw(paramVafContext, paramTemplateBean));
  }
  
  public static void a(Container paramContainer, qfw paramqfw, TemplateBean paramTemplateBean)
  {
    if (pig.a(paramContainer, paramqfw)) {
      return;
    }
    ViewBase localViewBase1 = paramContainer.getVirtualView();
    ViewBase localViewBase2 = localViewBase1.findViewBaseByName("id_separator");
    ArticleInfo localArticleInfo = paramqfw.a();
    if ((localArticleInfo == null) || (localViewBase2 == null))
    {
      QLog.d("ProteusSupportUtil", 1, "configDivider failed, articleInfo is null or divider is null.");
      return;
    }
    Layout.Params localParams = localViewBase2.getComLayoutParams();
    int m = localParams.mLayoutHeight;
    int j = Utils.dp2px(5.0D);
    double d = Utils.dp2px(6.0D);
    int i = paramqfw.a();
    int k = paramqfw.b();
    if (localArticleInfo.mChannelID == 70L)
    {
      blfz.a("configDivider.FollowFeeds");
      localParams.mLayoutMarginLeft = 0;
      localParams.mLayoutMarginRight = 0;
      localParams.mLayoutWidth = -1;
      i = Utils.dp2px(5.0D);
      blfz.a();
    }
    for (;;)
    {
      localParams.mLayoutHeight = i;
      localViewBase2.setComLayoutParams(localParams);
      paramqfw = localViewBase1.getComLayoutParams();
      if (paramqfw.mLayoutHeight >= 0) {
        paramqfw.mLayoutHeight = (i - m + paramqfw.mLayoutHeight);
      }
      paramqfw = localViewBase1.getComLayoutParams();
      paramContainer.setLayoutParams(new RelativeLayout.LayoutParams(paramqfw.mLayoutWidth, paramqfw.mLayoutHeight));
      return;
      if (plm.c((int)localArticleInfo.mChannelID))
      {
        blfz.a("configDivider.DailyFeeds");
        paramqfw = paramqfw.b();
        j = 0;
        k = 0;
        i = k;
        if (paramqfw != null)
        {
          i = k;
          if (paramqfw.mProteusTemplateBean != null)
          {
            if (paramqfw.mProteusTemplateBean.getDataAttribute(null, "position_jump") == null) {
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
          blfz.a();
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
      else if ((a(paramqfw.b())) || (a(paramqfw)))
      {
        i = 0;
        localParams.mLayoutMarginLeft = 0;
        localParams.mLayoutMarginRight = 0;
        localParams.mLayoutWidth = -1;
      }
      else if (a(i, k, paramqfw.b()))
      {
        blfz.a("configDivider.normal");
        blfz.a("configDivider.normal.getProteusSeparatorHeightPx");
        i = a(paramTemplateBean);
        blfz.a();
        blfz.a("configDivider.normal.getProteusSeparatorMarginLeftPx");
        d = a(paramTemplateBean);
        blfz.a();
        j = Utils.dp2px(d);
        localParams.mLayoutMarginRight = j;
        localParams.mLayoutMarginLeft = j;
        localParams.mLayoutWidth = -1;
        blfz.a();
      }
      else
      {
        localParams.mLayoutMarginLeft = 0;
        localParams.mLayoutMarginRight = 0;
        localParams.mLayoutWidth = -1;
        i = j;
        if (!b(k))
        {
          a(paramqfw, localViewBase2);
          i = j;
        }
      }
    }
  }
  
  public static void a(VafContext paramVafContext, String paramString)
  {
    paramVafContext.setTemplateFactory(tmh.a(paramString, true));
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyLikeButton", new qtz());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyAvatarView", new qsx());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyVariableImageContentView", new qtd());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoySummaryView", new qvk());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyCommentView", new qsv());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyBiuCommentView", new qsz());
    paramVafContext.getViewFactory().registerViewBuilder("CornerTextImageView", new qtb());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyMiddleBodyView", new que());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyUsersCommentView", new qvm());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyFriendsBiu", new qts());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyQARichView", new NativeText.Builder());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyBiuButton", new qtn());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyCoordinateView", new qtq());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoySocializeRecommendFollowView", new quq());
    paramVafContext.getViewFactory().registerViewBuilder("UILabel", new qvi());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInjoyAsynImageView", new qva());
    paramVafContext.getViewFactory().registerViewBuilder("UIImageView", new qva());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInjoyAsynImageIcon", new quy());
    paramVafContext.getViewFactory().registerViewBuilder("ProteusCollectionView", new qwv());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyAdVideoGuide", new qtk());
    paramVafContext.getViewFactory().registerViewBuilder("PTSAvatarView", new pgz());
    paramVafContext.getViewFactory().registerViewBuilder("QQAvatarView", new pgz());
    paramVafContext.getViewFactory().registerViewBuilder("RIJCommentRichTextView", new phk());
    paramVafContext.getViewFactory().registerViewBuilder("QQRIJRichTextView", new phb());
    paramVafContext.getViewFactory().registerViewBuilder("QQRIJCommentLikeButton", new phd());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyExposeReplyCommentView", new phm());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyAwesomeCommentView", new qtm());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyAdDownloadView", new ufo());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyAdLocationView", new qti());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyIconText", new unv());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInjoyDoubleImageView", new uob());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyBlurImageView", new unt());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyAdBubbleView", new umx());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyAdInnerOperateView", new unf());
    paramVafContext.getViewFactory().registerViewBuilder("ProteusTickerView", new qtf());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInjoyShareView", new qug());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInjoyApngImageView", new quw());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyAdBrandOptimizationView", new umu());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInjoyProgressView", new qvd());
    paramVafContext.getViewFactory().registerViewBuilder("RIJCommentLinksView", new phr());
    a();
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyArticleBottomVideoView", new unq());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyVideoView", new quu());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyGifView", new qtu());
    paramVafContext.getViewFactory().registerViewBuilder("ProteusMarqueeLabel", new NativeText.Builder());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyLinkClickableLabel", new qvi());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyLottieView", new quc());
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
      qsg.a("ProteusSupportUtil", "[bindDynamicValue]");
    }
  }
  
  private static void a(qfw paramqfw, VafContext paramVafContext)
  {
    Object localObject = paramqfw.a();
    if (localObject != null)
    {
      localObject = ((szd)localObject).b(paramqfw.g() + 1);
      if ((localObject != null) && (((BaseArticleInfo)localObject).mProteusTemplateBean == null))
      {
        QLog.d("ProteusSupportUtil", 2, "next.mProteusTemplateBean == null " + localObject);
        ((BaseArticleInfo)localObject).mProteusTemplateBean = a(paramVafContext, paramqfw.b(), (BaseArticleInfo)localObject);
      }
    }
  }
  
  private static void a(qfw paramqfw, ViewBase paramViewBase)
  {
    if ((paramqfw != null) && (paramViewBase != null) && (paramViewBase.getNativeView() != null))
    {
      paramqfw = paramqfw.b();
      if ((paramqfw != null) && (paramqfw.mProteusTemplateBean != null))
      {
        paramqfw = (ViewBean)paramqfw.mProteusTemplateBean.getViewDataBinding().get("id_separator");
        if ((paramqfw != null) && (paramqfw.valueBean != null) && (paramqfw.valueBean.normalValue != null))
        {
          paramqfw = paramqfw.valueBean.normalValue.get("setBackgroundColorString:");
          if (!(paramqfw instanceof String)) {}
        }
      }
    }
    try
    {
      paramViewBase.getNativeView().setBackgroundColor(Color.parseColor((String)paramqfw));
      return;
    }
    catch (Exception paramqfw)
    {
      QLog.d("ProteusSupportUtil", 1, paramqfw.getMessage());
    }
  }
  
  public static boolean a(int paramInt)
  {
    if (!piu.a()) {}
    do
    {
      return false;
      switch (paramInt)
      {
      }
    } while (ukk.a(paramInt));
    return jdField_a_of_type_JavaUtilMap.containsKey(Integer.valueOf(paramInt));
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
    blfz.a("configDivider.isDividerNormal");
    if ((b(paramInt1)) && ((b(paramInt2)) || (rab.a.a(paramArticleInfo, paramInt2) == 0))) {}
    for (boolean bool = true;; bool = false)
    {
      blfz.a();
      return bool;
    }
  }
  
  /* Error */
  public static boolean a(ArticleInfo paramArticleInfo)
  {
    // Byte code:
    //   0: ldc_w 1299
    //   3: invokestatic 166	blfz:a	(Ljava/lang/String;)V
    //   6: aload_0
    //   7: ifnull +154 -> 161
    //   10: aload_0
    //   11: getfield 1302	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:proteusItemsData	Ljava/lang/String;
    //   14: invokestatic 742	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   17: ifne +144 -> 161
    //   20: aload_0
    //   21: getfield 1305	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mFeedType	I
    //   24: bipush 29
    //   26: if_icmpeq +8 -> 34
    //   29: invokestatic 180	blfz:a	()V
    //   32: iconst_0
    //   33: ireturn
    //   34: new 466	org/json/JSONObject
    //   37: dup
    //   38: aload_0
    //   39: getfield 1302	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:proteusItemsData	Ljava/lang/String;
    //   42: invokespecial 1306	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   45: astore_0
    //   46: aload_0
    //   47: invokevirtual 822	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   50: astore_2
    //   51: aload_2
    //   52: invokeinterface 778 1 0
    //   57: ifeq +104 -> 161
    //   60: aload_2
    //   61: invokeinterface 782 1 0
    //   66: checkcast 211	java/lang/String
    //   69: astore_3
    //   70: aload_0
    //   71: aload_3
    //   72: invokevirtual 1309	org/json/JSONObject:opt	(Ljava/lang/String;)Ljava/lang/Object;
    //   75: astore 4
    //   77: ldc_w 1311
    //   80: aload_3
    //   81: invokevirtual 644	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   84: ifeq -33 -> 51
    //   87: ldc 243
    //   89: iconst_1
    //   90: iconst_2
    //   91: anewarray 4	java/lang/Object
    //   94: dup
    //   95: iconst_0
    //   96: ldc_w 1313
    //   99: aastore
    //   100: dup
    //   101: iconst_1
    //   102: aload 4
    //   104: aastore
    //   105: invokestatic 238	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   108: invokestatic 180	blfz:a	()V
    //   111: ldc_w 1315
    //   114: aload 4
    //   116: invokestatic 1318	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   119: invokevirtual 644	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   122: ifne +19 -> 141
    //   125: ldc_w 1320
    //   128: aload 4
    //   130: invokestatic 1318	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   133: invokevirtual 644	java/lang/String:equals	(Ljava/lang/Object;)Z
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
    //   151: ldc 243
    //   153: iconst_1
    //   154: ldc_w 1322
    //   157: aload_0
    //   158: invokestatic 1324	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   161: invokestatic 180	blfz:a	()V
    //   164: iconst_0
    //   165: ireturn
    //   166: astore_0
    //   167: ldc 243
    //   169: iconst_1
    //   170: ldc_w 1326
    //   173: aload_0
    //   174: invokestatic 1324	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
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
              QQAppInterface localQQAppInterface = pnn.a();
              if (((NativeLayoutImpl)localObject).getContentDescription() == null) {
                continue;
              }
              localObject = ((NativeLayoutImpl)localObject).getContentDescription().toString();
              olh.a(localQQAppInterface, "CliOper", "", "", "0X8009AC1", "0X8009AC1", 0, 0, "", "", "", (String)localObject, false);
              if (QLog.isColorLevel())
              {
                qsh.a(paramContainer.getVirtualView(), "ProteusSupportUtil");
                qsh.a(paramContainer, "ProteusSupportUtil");
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
    paramString = tmh.a(paramString, true);
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
  
  public static boolean a(qfw paramqfw)
  {
    if (paramqfw != null) {
      try
      {
        int i = paramqfw.b();
        if ((i == 66) || (i == 39))
        {
          paramqfw = paramqfw.b();
          if ((paramqfw != null) && (AdvertisementInfo.isAdvertisementInfo(paramqfw)))
          {
            paramqfw = ((AdvertisementInfo)paramqfw).mAdExtInfo;
            if (paramqfw != null)
            {
              i = new JSONObject(paramqfw).optInt("is_video_new");
              return i == 1;
            }
          }
        }
      }
      catch (Exception paramqfw)
      {
        QLog.d("ProteusSupportUtil", 1, "isNextCardAdBigImgOrAdVideo JSONException, e = ", paramqfw);
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
        qsg.a("ProteusSupportUtil", "[getSepatatorHeight] getSepatatorHeight");
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
    paramString = tmh.a(paramString, false);
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
      if ((pqw.c((ArticleInfo)paramBaseArticleInfo)) || (pqw.d((ArticleInfo)paramBaseArticleInfo))) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    case 1035: 
    case 1170: 
    case 1171: 
      return false;
    case 1044: 
      return uvp.a((ArticleInfo)paramBaseArticleInfo);
    }
    return a(paramBaseArticleInfo, paramViewBase, paramVafContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     piv
 * JD-Core Version:    0.7.0.1
 */