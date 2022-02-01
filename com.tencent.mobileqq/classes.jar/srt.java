import android.content.Context;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebDislikeUtils.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

public class srt
{
  private static final String a = anzj.a(2131715662);
  
  public static String a(int paramInt)
  {
    return bnrf.a(paramInt, 99990000L, "9999万+", a);
  }
  
  public static void a(Context paramContext, ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    ThreadManager.executeOnSubThread(new FastWebDislikeUtils.1(paramArticleInfo, paramContext));
    a(paramArticleInfo, "0X80101DC");
  }
  
  public static void a(ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    if (paramFastWebArticleInfo.jdField_a_of_type_Boolean)
    {
      paramFastWebArticleInfo.jdField_a_of_type_Boolean = false;
      paramFastWebArticleInfo.jdField_a_of_type_Int -= 1;
      ssy.b(paramArticleInfo, "0X8009765", "2");
    }
    for (;;)
    {
      pfd.a().d();
      pfa.a().a(ozs.a(), paramFastWebArticleInfo.jdField_a_of_type_Boolean, paramFastWebArticleInfo);
      return;
      paramFastWebArticleInfo.jdField_a_of_type_Boolean = true;
      paramFastWebArticleInfo.jdField_a_of_type_Int += 1;
      ssy.b(paramArticleInfo, "0X8009764", "2");
    }
  }
  
  public static void a(ArticleInfo paramArticleInfo, String paramString)
  {
    int j = 0;
    if (paramArticleInfo == null) {
      return;
    }
    paa localpaa = ssy.a(paramArticleInfo);
    for (;;)
    {
      try
      {
        localpaa.b("source_from", "2");
        localpaa.j();
        localpaa.k();
        localpaa.l();
        localpaa.a(paramArticleInfo.mAlgorithmID);
        localpaa.b(paramArticleInfo.mStrategyId);
        AladdinConfig localAladdinConfig = Aladdin.getConfig(151);
        if (localAladdinConfig != null)
        {
          i = localAladdinConfig.getIntegerFromString("readinjoy_bottom_action_bar_business_id", -1);
          localpaa.b("interact_style", localAladdinConfig.getIntegerFromString("readinjoy_bottom_action_bar_style", -1));
          localpaa.b("businessID", i);
        }
        if (ozs.p())
        {
          i = 1;
          localpaa.b("artical_interact_area", i);
          localpaa.b("artical_interact_type", ozs.h());
          if ((paramString.equals("0X80101DC")) || (paramString.equals("0X80100DB")))
          {
            i = j;
            if (ozs.q()) {
              i = 1;
            }
            localpaa.b("ad_relative_pos", i);
          }
          ssy.a(paramArticleInfo, paramString, localpaa.a());
          return;
        }
      }
      catch (Exception paramArticleInfo)
      {
        QLog.d("FastWebDislikeUtils", 1, "report error! msg=" + paramArticleInfo);
        return;
      }
      int i = 0;
    }
  }
  
  public static void b(Context paramContext, ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    a(paramArticleInfo, "0X8009A5B");
    if ((paramContext instanceof FastWebActivity)) {
      ((FastWebActivity)paramContext).a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     srt
 * JD-Core Version:    0.7.0.1
 */