import android.app.Activity;
import android.content.Intent;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class qxf
{
  private static final String jdField_a_of_type_JavaLangString = qxf.class.getSimpleName();
  private Activity jdField_a_of_type_AndroidAppActivity;
  private qwy jdField_a_of_type_Qwy;
  private qxr jdField_a_of_type_Qxr;
  
  qxf(Activity paramActivity, qwy paramqwy, qxr paramqxr)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Qwy = paramqwy;
    this.jdField_a_of_type_Qxr = paramqxr;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    label20:
    String str;
    VideoInfo localVideoInfo;
    do
    {
      do
      {
        do
        {
          return;
          break label20;
          while (paramInt2 != -1) {}
          str = paramIntent.getStringExtra("ARG_VIDEO_ARTICLE_ID");
        } while ((!paramIntent.getBooleanExtra("KEY_VIDEO_BIU_SUCCESS", false)) || (str == null) || (this.jdField_a_of_type_Qwy == null));
        paramIntent = this.jdField_a_of_type_Qxr.a().iterator();
      } while (!paramIntent.hasNext());
      localVideoInfo = (VideoInfo)paramIntent.next();
    } while (!str.equals(localVideoInfo.g));
    localVideoInfo.f += 1;
    this.jdField_a_of_type_Qwy.b(localVideoInfo);
  }
  
  public void a(VideoInfo paramVideoInfo)
  {
    boolean bool = true;
    if (odo.a() == 1) {}
    for (;;)
    {
      try
      {
        Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, ReadInJoyDeliverBiuActivity.class);
        if ((paramVideoInfo.jdField_a_of_type_Int == 6) && (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null)) {
          localIntent.putExtra("feedsType", paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedType);
        }
        localIntent.putExtra("ARG_VIDEO_ARTICLE_ID", paramVideoInfo.g);
        localIntent.putExtra("biu_src", 2);
        localIntent.putExtra("arg_from_type", 8);
        localIntent.putExtra("arg_article_info", paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
        localIntent.putExtra("fast_biu_type", bool);
        this.jdField_a_of_type_AndroidAppActivity.startActivityForResult(localIntent, 102);
        this.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(0, 0);
        return;
      }
      catch (Exception paramVideoInfo)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e(jdField_a_of_type_JavaLangString, 2, "innerOpenReadInJoyBiuActivity error exception = " + paramVideoInfo.getMessage());
      }
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qxf
 * JD-Core Version:    0.7.0.1
 */