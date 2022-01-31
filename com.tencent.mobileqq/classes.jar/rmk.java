import android.content.Context;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebDislikeUtils.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

public class rmk
{
  private static final String a = ajya.a(2131716892);
  
  public static String a(int paramInt)
  {
    return bhvy.a(paramInt, 99990000L, "9999万+", a);
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
      rno.b(paramArticleInfo, "0X8009765", "2");
    }
    for (;;)
    {
      osj.a().d();
      osg.a().a(onh.a(), paramFastWebArticleInfo.jdField_a_of_type_Boolean, paramFastWebArticleInfo);
      return;
      paramFastWebArticleInfo.jdField_a_of_type_Boolean = true;
      paramFastWebArticleInfo.jdField_a_of_type_Int += 1;
      rno.b(paramArticleInfo, "0X8009764", "2");
    }
  }
  
  public static void a(ArticleInfo paramArticleInfo, String paramString)
  {
    int j = 0;
    if (paramArticleInfo == null) {
      return;
    }
    ono localono = rno.a(paramArticleInfo);
    for (;;)
    {
      try
      {
        localono.b("source_from", "2");
        localono.j();
        localono.k();
        localono.l();
        localono.a(paramArticleInfo.mAlgorithmID);
        localono.b(paramArticleInfo.mStrategyId);
        AladdinConfig localAladdinConfig = Aladdin.getConfig(151);
        if (localAladdinConfig != null)
        {
          i = localAladdinConfig.getIntegerFromString("readinjoy_bottom_action_bar_business_id", -1);
          localono.b("interact_style", localAladdinConfig.getIntegerFromString("readinjoy_bottom_action_bar_style", -1));
          localono.b("businessID", i);
        }
        if (onh.n())
        {
          i = 1;
          localono.b("artical_interact_area", i);
          localono.b("artical_interact_type", onh.h());
          if ((paramString.equals("0X80101DC")) || (paramString.equals("0X80100DB")))
          {
            i = j;
            if (onh.o()) {
              i = 1;
            }
            localono.b("ad_relative_pos", i);
          }
          rno.a(paramArticleInfo, paramString, localono.a());
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
 * Qualified Name:     rmk
 * JD-Core Version:    0.7.0.1
 */