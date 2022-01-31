import android.content.Context;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebDislikeUtils.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

public class qzv
{
  private static final String a = ajjy.a(2131651090);
  
  public static String a(int paramInt)
  {
    return bgmq.a(paramInt, 99990000L, "9999万+", a);
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
      raz.b(paramArticleInfo, "0X8009765", "2");
    }
    for (;;)
    {
      ohb.a().d();
      ogy.a().a(obz.a(), paramFastWebArticleInfo.jdField_a_of_type_Boolean, paramFastWebArticleInfo);
      return;
      paramFastWebArticleInfo.jdField_a_of_type_Boolean = true;
      paramFastWebArticleInfo.jdField_a_of_type_Int += 1;
      raz.b(paramArticleInfo, "0X8009764", "2");
    }
  }
  
  public static void a(ArticleInfo paramArticleInfo, String paramString)
  {
    int j = 0;
    if (paramArticleInfo == null) {
      return;
    }
    ocg localocg = raz.a(paramArticleInfo);
    for (;;)
    {
      try
      {
        localocg.b("source_from", "2");
        localocg.j();
        localocg.k();
        localocg.l();
        localocg.a(paramArticleInfo.mAlgorithmID);
        localocg.b(paramArticleInfo.mStrategyId);
        AladdinConfig localAladdinConfig = Aladdin.getConfig(151);
        if (localAladdinConfig != null)
        {
          i = localAladdinConfig.getIntegerFromString("readinjoy_bottom_action_bar_business_id", -1);
          localocg.b("interact_style", localAladdinConfig.getIntegerFromString("readinjoy_bottom_action_bar_style", -1));
          localocg.b("businessID", i);
        }
        if (obz.o())
        {
          i = 1;
          localocg.b("artical_interact_area", i);
          localocg.b("artical_interact_type", obz.h());
          if ((paramString.equals("0X80101DC")) || (paramString.equals("0X80100DB")))
          {
            i = j;
            if (obz.p()) {
              i = 1;
            }
            localocg.b("ad_relative_pos", i);
          }
          raz.a(paramArticleInfo, paramString, localocg.a());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qzv
 * JD-Core Version:    0.7.0.1
 */