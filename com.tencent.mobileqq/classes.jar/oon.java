import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.Aladdin.InitParams;
import com.tencent.aladdin.config.Aladdin.InitParams.Builder;
import com.tencent.aladdin.config.handlers.SimpleConfigHandler;
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

public class oon
{
  public static final int[] a = { 1, 3, 40, 41, 111, 112, 116, 114, 117, 119, 156, 121, 122, 123, 124, 127, 131, 133, 134, 132, 136, 139, 135, 138, 144, 140, 142, 145, 147, 148, 149, 151, 152, 153, 154, 155, 157, 159, 160, 161, 162, 164, 165, 167, 168, 169, 171, 170, 172, 173, 174, 176, 177, 178, 180, 179, 181, 182, 183, 185, 187, 186, 194, 190, 189, 188, 192, 193, 191, 196, 199, 200, 201, 204, 202, 205, 206, 207, 208, 209, 211, 212, 214, 215, 216, 218, 219, 217, 220, 221, 222, 197, 223, 225, 226, 246, 227, 226, 228, 227, 230, 232, 234, 243, 238, 239, 242, 244, 245, 247, 250, 252, 251, 254, 253, 255, 256, 259, 258, 260, 261, 263, 262, 264, 265, 267, 266, 276 };
  
  static
  {
    Aladdin.registerConfigHandler(111, new oor());
    Aladdin.registerConfigHandler(112, new opp());
    Aladdin.registerConfigHandler(116, new opr());
    Aladdin.registerConfigHandler(114, new opq());
    Aladdin.registerConfigHandler(117, new oos());
    Aladdin.registerConfigHandler(119, new ops());
    Aladdin.registerConfigHandler(156, new opi());
    Aladdin.registerConfigHandler(121, new KandianReportDataConfigHandler());
    Aladdin.registerConfigHandler(122, new ooy());
    Aladdin.registerConfigHandler(123, new opf());
    Aladdin.registerConfigHandler(124, new opo());
    Aladdin.registerConfigHandler(127, new opd());
    Aladdin.registerConfigHandler(131, new opc());
    Aladdin.registerConfigHandler(133, new opm());
    Aladdin.registerConfigHandler(132, new opj());
    Aladdin.registerConfigHandler(134, new opb());
    Aladdin.registerConfigHandler(135, new oox());
    Aladdin.registerConfigHandler(138, new AwesomeCommentConfigHandler());
    Aladdin.registerConfigHandler(142, new opg());
    Aladdin.registerConfigHandler(147, new oop());
    Aladdin.registerConfigHandler(148, new ooq());
    Aladdin.registerConfigHandler(149, new ope());
    Aladdin.registerConfigHandler(155, new opa());
    Aladdin.registerConfigHandler(162, new oou());
    Aladdin.registerConfigHandler(170, new oot());
    Aladdin.registerConfigHandler(181, new oov());
    Aladdin.registerConfigHandler(182, new SimpleConfigHandler());
    Aladdin.registerConfigHandler(185, new nyl());
    Aladdin.registerConfigHandler(187, new ntx());
    Aladdin.registerConfigHandler(188, new nyl());
    Aladdin.registerConfigHandler(157, new oow());
    Aladdin.registerConfigHandler(191, new opn());
    Aladdin.registerConfigHandler(200, new nyq());
    Aladdin.registerConfigHandler(202, new opl());
    Aladdin.registerConfigHandler(211, new opt());
    Aladdin.registerConfigHandler(219, new oph());
    Aladdin.registerConfigHandler(221, new ooz());
    Aladdin.registerConfigHandler(197, new opu());
    Aladdin.registerConfigHandler(247, new opv());
    Aladdin.registerConfigHandler(244, new opk());
  }
  
  public static void a()
  {
    Aladdin.initialize(Aladdin.InitParams.newBuilder().withUserId(onk.a()).withAppVersion("8.2.8").withContext(BaseApplicationImpl.getContext()).withExecutor(ooo.a).withRequestHandler(new ool()).withAppFlavorId(AppSetting.a() + "").withLogger(new ooj()).build());
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
  }
  
  private static void c()
  {
    ThreadManagerV2.executeOnSubThread(new QQAladdinUtils.1());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oon
 * JD-Core Version:    0.7.0.1
 */