import com.tencent.TMG.utils.QLog;
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
import java.util.Arrays;

public class osv
{
  public static final int[] a = { 1, 3, 40, 41, 111, 112, 116, 114, 117, 119, 156, 121, 122, 123, 124, 127, 131, 133, 134, 132, 136, 139, 135, 138, 144, 140, 142, 145, 147, 148, 149, 151, 152, 153, 154, 155, 157, 159, 160, 161, 162, 164, 165, 167, 168, 169, 171, 170, 172, 173, 174, 176, 177, 178, 180, 179, 181, 182, 183, 185, 187, 186, 194, 190, 189, 188, 192, 193, 191, 196, 199, 200, 201, 204, 202, 205, 206, 207, 208, 209, 211, 212, 214, 215, 216, 218, 219, 217, 220, 221, 222, 197, 223, 225, 226, 246, 227, 226, 228, 227, 230, 232, 234, 243, 238, 239, 242, 244, 245, 247, 250, 252, 251, 254, 253, 255, 256, 259, 258, 260, 261, 263, 262, 264, 265, 269, 271, 272, 273, 274, 272, 267, 266, 276, 277, 278, 280, 282, 279, 275, 281, 283, 284, 285, 286, 287, 288, 290, 289, 293, 298, 304, 305 };
  
  static
  {
    Aladdin.registerConfigHandler(111, new osz());
    Aladdin.registerConfigHandler(112, new oub());
    Aladdin.registerConfigHandler(116, new oud());
    Aladdin.registerConfigHandler(114, new ouc());
    Aladdin.registerConfigHandler(117, new ota());
    Aladdin.registerConfigHandler(119, new oue());
    Aladdin.registerConfigHandler(156, new otq());
    Aladdin.registerConfigHandler(121, new KandianReportDataConfigHandler());
    Aladdin.registerConfigHandler(122, new otg());
    Aladdin.registerConfigHandler(123, new otn());
    Aladdin.registerConfigHandler(124, new oua());
    Aladdin.registerConfigHandler(127, new otl());
    Aladdin.registerConfigHandler(131, new otk());
    Aladdin.registerConfigHandler(133, new otx());
    Aladdin.registerConfigHandler(132, new otr());
    Aladdin.registerConfigHandler(134, new otj());
    Aladdin.registerConfigHandler(135, new otf());
    Aladdin.registerConfigHandler(138, new AwesomeCommentConfigHandler());
    Aladdin.registerConfigHandler(142, new oto());
    Aladdin.registerConfigHandler(147, new osx());
    Aladdin.registerConfigHandler(148, new osy());
    Aladdin.registerConfigHandler(149, new otm());
    Aladdin.registerConfigHandler(155, new oti());
    Aladdin.registerConfigHandler(162, new otc());
    Aladdin.registerConfigHandler(170, new otb());
    Aladdin.registerConfigHandler(181, new otd());
    Aladdin.registerConfigHandler(182, new SimpleConfigHandler());
    Aladdin.registerConfigHandler(185, new obp());
    Aladdin.registerConfigHandler(187, new nwz());
    Aladdin.registerConfigHandler(188, new obp());
    Aladdin.registerConfigHandler(157, new ote());
    Aladdin.registerConfigHandler(191, new otz());
    Aladdin.registerConfigHandler(200, new obu());
    Aladdin.registerConfigHandler(202, new otw());
    Aladdin.registerConfigHandler(211, new ouf());
    Aladdin.registerConfigHandler(219, new otp());
    Aladdin.registerConfigHandler(221, new oth());
    Aladdin.registerConfigHandler(197, new oug());
    Aladdin.registerConfigHandler(247, new oui());
    Aladdin.registerConfigHandler(244, new ots());
    Aladdin.registerConfigHandler(274, new SimpleConfigHandler());
    Aladdin.registerConfigHandler(280, new otv());
    Aladdin.registerConfigHandler(282, new ouh());
    Aladdin.registerConfigHandler(287, new ouj());
    Aladdin.registerConfigHandler(290, new oty());
    Aladdin.registerConfigHandler(304, new otu());
    Aladdin.registerConfigHandler(305, new ott());
  }
  
  public static void a()
  {
    Aladdin.initialize(Aladdin.InitParams.newBuilder().withUserId(ors.a()).withAppVersion("8.3.5").withContext(BaseApplicationImpl.getContext()).withExecutor(osw.a).withRequestHandler(new ost()).withAppFlavorId(AppSetting.a() + "").withLogger(new osr()).build());
    Aladdin.registerBeanClass("SneakyParams", SneakyParams.class);
    Aladdin.registerBeanClass("AchillesParams", AchillesParams.class);
    Aladdin.registerBeanClass("SneakyRule", SneakyRule.class);
    Aladdin.registerBeanClass("OccasionRule", OccasionRule.class);
    Aladdin.registerConfigParser(136, Aladdin.DEFAULT_SIMPLE_OBJECT_PARSER);
    Aladdin.registerConfigParser(139, Aladdin.DEFAULT_SIMPLE_OBJECT_PARSER);
    Aladdin.registerConfigParser(140, Aladdin.DEFAULT_SIMPLE_OBJECT_PARSER);
    c();
  }
  
  private static int[] a(int[] paramArrayOfInt)
  {
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length == 0)) {
      return a;
    }
    try
    {
      int[] arrayOfInt = new int[a.length + paramArrayOfInt.length];
      arrayOfInt = Arrays.copyOf(a, arrayOfInt.length);
      System.arraycopy(paramArrayOfInt, 0, arrayOfInt, a.length, paramArrayOfInt.length);
      return arrayOfInt;
    }
    catch (Throwable paramArrayOfInt)
    {
      QLog.d("mergeIds", 1, "mergeIds error: " + paramArrayOfInt.getMessage());
    }
    return null;
  }
  
  public static void b()
  {
    Object localObject = oty.a();
    if ((localObject == null) || (localObject.length == 0))
    {
      Aladdin.requestForUpdate(a);
      return;
    }
    int[] arrayOfInt = a((int[])localObject);
    if (arrayOfInt != null)
    {
      localObject = arrayOfInt;
      if (arrayOfInt.length > a.length) {}
    }
    else
    {
      localObject = a;
    }
    Aladdin.requestForUpdate((int[])localObject);
  }
  
  private static void c()
  {
    ThreadManagerV2.executeOnSubThread(new QQAladdinUtils.1());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     osv
 * JD-Core Version:    0.7.0.1
 */