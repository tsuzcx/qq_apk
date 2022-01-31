import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoRecommendManager.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class rkb
{
  private float jdField_a_of_type_Float = -1.0F;
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private BaseArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
  private String jdField_a_of_type_JavaLangString;
  private HashMap<Long, BaseArticleInfo> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private rkc jdField_a_of_type_Rkc;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -1;
  private HashMap<Long, BaseArticleInfo> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  private int c;
  
  public rkb(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    ThreadManager.post(new VideoRecommendManager.1(this), 10, null, true);
  }
  
  private void a(int paramInt, long paramLong)
  {
    switch (paramInt)
    {
    default: 
      paramInt = 0;
    }
    for (;;)
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("dynamic_recommend_strategyid", this.jdField_a_of_type_Int);
        localJSONObject.put("condition", paramInt);
        localJSONObject.put("strategy_duration_limit", this.jdField_b_of_type_Int);
        localJSONObject.put("strategy_duration_percent", this.jdField_a_of_type_Float);
        localJSONObject.put("operator", this.c);
        if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
          localJSONObject.put("video_session_id", this.jdField_a_of_type_JavaLangString);
        }
        if ((this.jdField_a_of_type_AndroidAppActivity != null) && (this.jdField_a_of_type_AndroidAppActivity.getIntent() != null))
        {
          paramInt = this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("channel_from", -1);
          nrt.b(null, null, "0X80087C7", "0X80087C7", 0, 0, String.valueOf(0), "", "", new ron(ntd.a(localJSONObject)).O(paramInt).a().a(), false);
          return;
          paramInt = 1;
          continue;
          paramInt = 2;
          continue;
          if (paramLong >= this.jdField_b_of_type_Int)
          {
            paramInt = 3;
            continue;
          }
          paramInt = 4;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          continue;
          paramInt = 0;
        }
      }
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a(int paramInt, BaseArticleInfo paramBaseArticleInfo, long paramLong1, long paramLong2)
  {
    int j = 1;
    if (paramBaseArticleInfo != null) {}
    int i;
    try
    {
      boolean bool = this.jdField_a_of_type_JavaUtilHashMap.containsKey(Long.valueOf(paramBaseArticleInfo.mArticleID));
      if (bool) {}
      for (;;)
      {
        return;
        if ((paramInt != 1) && (paramInt != 2)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.pubaccount.video.feeds.VideoReommendManager", 2, "updateLatestUserAction() action=" + paramInt);
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = paramBaseArticleInfo;
        i = j;
        if ((i != 0) && (this.jdField_a_of_type_Rkc != null))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.pubaccount.video.feeds.VideoReommendManager", 2, "updateLatestUserAction() 触发拉取 articleInfo.mArticleID = " + paramBaseArticleInfo.mArticleID + ", articleInfo.mTitle = " + paramBaseArticleInfo.mTitle);
          }
          a(paramInt, paramLong1);
          this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleID), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
          this.jdField_a_of_type_Rkc.a(this.jdField_a_of_type_Boolean, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
        }
      }
      if (paramInt != 0) {
        break label347;
      }
    }
    finally {}
    if (this.c == 0)
    {
      if ((paramLong1 < this.jdField_b_of_type_Int) || ((float)paramLong1 <= (float)paramLong2 * this.jdField_a_of_type_Float)) {
        break label353;
      }
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.pubaccount.video.feeds.VideoReommendManager", 2, "updateLatestUserAction() action=" + paramInt + ", playDuration=" + paramLong1 + ", totalDuration=" + paramLong2);
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = paramBaseArticleInfo;
        i = j;
        break;
        if (paramLong1 < this.jdField_b_of_type_Int)
        {
          float f1 = (float)paramLong1;
          float f2 = (float)paramLong2;
          float f3 = this.jdField_a_of_type_Float;
          if (f1 <= f2 * f3) {}
        }
        else
        {
          i = 1;
          continue;
        }
        i = 0;
        continue;
      }
      label347:
      i = 0;
      break;
      label353:
      i = 0;
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(List<ArticleInfo> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ArticleInfo localArticleInfo = (ArticleInfo)paramList.next();
      this.jdField_b_of_type_JavaUtilHashMap.put(Long.valueOf(localArticleInfo.mArticleID), localArticleInfo);
    }
  }
  
  public boolean a(long paramLong)
  {
    return this.jdField_b_of_type_JavaUtilHashMap.containsKey(Long.valueOf(paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rkb
 * JD-Core Version:    0.7.0.1
 */