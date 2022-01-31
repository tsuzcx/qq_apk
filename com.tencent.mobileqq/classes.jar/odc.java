import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.Aladdin.InitParams;
import com.tencent.aladdin.config.Aladdin.InitParams.Builder;
import com.tencent.aladdin.config.handlers.SimpleConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.config.AladdinConfigServlet;
import com.tencent.biz.pubaccount.readinjoy.config.QQAladdinUtils.1;
import com.tencent.biz.pubaccount.readinjoy.config.beans.AchillesParams;
import com.tencent.biz.pubaccount.readinjoy.config.beans.OccasionRule;
import com.tencent.biz.pubaccount.readinjoy.config.beans.SneakyParams;
import com.tencent.biz.pubaccount.readinjoy.config.beans.SneakyRule;
import com.tencent.biz.pubaccount.readinjoy.kandianreport.AwesomeCommentConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.kandianreport.KandianReportDataConfigHandler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManagerV2;

public class odc
{
  public static final int[] a = { 1, 3, 40, 41, 111, 112, 116, 114, 117, 119, 156, 121, 122, 123, 124, 127, 131, 133, 134, 132, 136, 139, 135, 138, 144, 140, 142, 145, 147, 148, 149, 151, 152, 153, 154, 155, 157, 159, 160, 161, 162, 164, 165, 167, 168, 169, 171, 170, 172, 173, 174, 176, 177, 178, 180, 179, 181, 182, 183, 185, 187, 186, 194, 190, 189, 188, 192, 193, 191, 196, 199, 200, 201, 204, 202, 205, 206, 207, 208, 209, 211, 212, 214, 215, 216, 218, 219, 217, 220, 221, 222, 197, 223, 225, 226, 246, 227, 226, 228, 227, 230, 232, 234, 243, 238, 239, 242, 244, 247, 250, 252, 251, 254, 253, 255, 256, 259 };
  
  static
  {
    Aladdin.registerConfigHandler(111, new odg());
    Aladdin.registerConfigHandler(112, new oee());
    Aladdin.registerConfigHandler(116, new oeg());
    Aladdin.registerConfigHandler(114, new oef());
    Aladdin.registerConfigHandler(117, new odh());
    Aladdin.registerConfigHandler(119, new oeh());
    Aladdin.registerConfigHandler(156, new odx());
    Aladdin.registerConfigHandler(121, new KandianReportDataConfigHandler());
    Aladdin.registerConfigHandler(122, new odn());
    Aladdin.registerConfigHandler(123, new odu());
    Aladdin.registerConfigHandler(124, new oed());
    Aladdin.registerConfigHandler(127, new ods());
    Aladdin.registerConfigHandler(131, new odr());
    Aladdin.registerConfigHandler(133, new oeb());
    Aladdin.registerConfigHandler(132, new ody());
    Aladdin.registerConfigHandler(134, new odq());
    Aladdin.registerConfigHandler(135, new odm());
    Aladdin.registerConfigHandler(138, new AwesomeCommentConfigHandler());
    Aladdin.registerConfigHandler(142, new odv());
    Aladdin.registerConfigHandler(144, new SimpleConfigHandler());
    Aladdin.registerConfigHandler(147, new ode());
    Aladdin.registerConfigHandler(148, new odf());
    Aladdin.registerConfigHandler(149, new odt());
    Aladdin.registerConfigHandler(151, new SimpleConfigHandler());
    Aladdin.registerConfigHandler(152, new SimpleConfigHandler());
    Aladdin.registerConfigHandler(153, new SimpleConfigHandler());
    Aladdin.registerConfigHandler(155, new odp());
    Aladdin.registerConfigHandler(159, new SimpleConfigHandler());
    Aladdin.registerConfigHandler(160, new SimpleConfigHandler());
    Aladdin.registerConfigHandler(161, new SimpleConfigHandler());
    Aladdin.registerConfigHandler(162, new odj());
    Aladdin.registerConfigHandler(165, new SimpleConfigHandler());
    Aladdin.registerConfigHandler(167, new SimpleConfigHandler());
    Aladdin.registerConfigHandler(168, new SimpleConfigHandler());
    Aladdin.registerConfigHandler(169, new SimpleConfigHandler());
    Aladdin.registerConfigHandler(170, new odi());
    Aladdin.registerConfigHandler(171, new SimpleConfigHandler());
    Aladdin.registerConfigHandler(172, new SimpleConfigHandler());
    Aladdin.registerConfigHandler(173, new SimpleConfigHandler());
    Aladdin.registerConfigHandler(174, new SimpleConfigHandler());
    Aladdin.registerConfigHandler(176, new SimpleConfigHandler());
    Aladdin.registerConfigHandler(177, new SimpleConfigHandler());
    Aladdin.registerConfigHandler(178, new SimpleConfigHandler());
    Aladdin.registerConfigHandler(180, new SimpleConfigHandler());
    Aladdin.registerConfigHandler(183, new SimpleConfigHandler());
    Aladdin.registerConfigHandler(179, new SimpleConfigHandler());
    Aladdin.registerConfigHandler(181, new odk());
    Aladdin.registerConfigHandler(182, new SimpleConfigHandler());
    Aladdin.registerConfigHandler(185, new nna());
    Aladdin.registerConfigHandler(187, new nin());
    Aladdin.registerConfigHandler(186, new SimpleConfigHandler());
    Aladdin.registerConfigHandler(190, new SimpleConfigHandler());
    Aladdin.registerConfigHandler(194, new SimpleConfigHandler());
    Aladdin.registerConfigHandler(189, new SimpleConfigHandler());
    Aladdin.registerConfigHandler(188, new nna());
    Aladdin.registerConfigHandler(192, new SimpleConfigHandler());
    Aladdin.registerConfigHandler(193, new SimpleConfigHandler());
    Aladdin.registerConfigHandler(157, new odl());
    Aladdin.registerConfigHandler(191, new oec());
    Aladdin.registerConfigHandler(201, new SimpleConfigHandler());
    Aladdin.registerConfigHandler(200, new nnf());
    Aladdin.registerConfigHandler(202, new oea());
    Aladdin.registerConfigHandler(204, new SimpleConfigHandler());
    Aladdin.registerConfigHandler(205, new SimpleConfigHandler());
    Aladdin.registerConfigHandler(209, new SimpleConfigHandler());
    Aladdin.registerConfigHandler(211, new oei());
    Aladdin.registerConfigHandler(212, new SimpleConfigHandler());
    Aladdin.registerConfigHandler(216, new SimpleConfigHandler());
    Aladdin.registerConfigHandler(218, new SimpleConfigHandler());
    Aladdin.registerConfigHandler(219, new odw());
    Aladdin.registerConfigHandler(221, new odo());
    Aladdin.registerConfigHandler(197, new oej());
    Aladdin.registerConfigHandler(228, new SimpleConfigHandler());
    Aladdin.registerConfigHandler(239, new SimpleConfigHandler());
    Aladdin.registerConfigHandler(243, new SimpleConfigHandler());
    Aladdin.registerConfigHandler(247, new oek());
    Aladdin.registerConfigHandler(244, new odz());
  }
  
  public static void a()
  {
    Aladdin.initialize(Aladdin.InitParams.newBuilder().withUserId(obz.a()).withAppVersion("8.2.6").withContext(BaseApplicationImpl.getContext()).withExecutor(odd.a).withRequestHandler(new oda()).withAppFlavorId(AppSetting.a() + "").withLogger(new ocy()).build());
    Aladdin.registerBeanClass("SneakyParams", SneakyParams.class);
    Aladdin.registerBeanClass("AchillesParams", AchillesParams.class);
    Aladdin.registerBeanClass("SneakyRule", SneakyRule.class);
    Aladdin.registerBeanClass("OccasionRule", OccasionRule.class);
    Aladdin.registerConfigParser(136, Aladdin.DEFAULT_SIMPLE_OBJECT_PARSER);
    Aladdin.registerConfigParser(139, Aladdin.DEFAULT_SIMPLE_OBJECT_PARSER);
    Aladdin.registerConfigParser(140, Aladdin.DEFAULT_SIMPLE_OBJECT_PARSER);
    c();
  }
  
  public static void b()
  {
    Aladdin.requestForUpdate(a);
    AladdinConfigServlet.a();
  }
  
  private static void c()
  {
    ThreadManagerV2.executeOnSubThread(new QQAladdinUtils.1());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     odc
 * JD-Core Version:    0.7.0.1
 */