import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

class qfn
  extends nev
{
  private qfn(qfk paramqfk) {}
  
  protected void a(boolean paramBoolean, Bundle paramBundle)
  {
    int m = 0;
    Object localObject1;
    if (paramBoolean)
    {
      localObject1 = paramBundle.getString("VALUE_REQUEST_VIDEO_ARTICLE_ID");
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (((String)localObject1).equals(qfk.a(this.a).g))) {
        break label42;
      }
    }
    for (;;)
    {
      return;
      label42:
      paramBundle = paramBundle.getParcelableArrayList("VIDEO_RECOMMEND_LIST");
      if ((paramBundle != null) && (paramBundle.size() != 0))
      {
        Object localObject2 = paramBundle.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (VideoInfo)((Iterator)localObject2).next();
          ((VideoInfo)localObject3).j = true;
          ((VideoInfo)localObject3).I = ((String)localObject1);
          if (QLog.isColorLevel()) {
            QLog.d("Q.pubaccount.video.feeds.VideoFeedsRecommendManager", 2, "动态插入视频 title = " + ((VideoInfo)localObject3).jdField_c_of_type_JavaLangString + ", rowkey = " + ((VideoInfo)localObject3).g);
          }
        }
        localObject2 = new ArrayList();
        Object localObject3 = new ArrayList();
        int i = 0;
        int j = -1;
        if (i < qfk.a(this.a).size())
        {
          int k;
          if (j == -1) {
            if (((VideoInfo)qfk.a(this.a).get(i)).a() == null) {
              k = j;
            }
          }
          for (;;)
          {
            i += 1;
            j = k;
            break;
            k = j;
            if (((VideoInfo)qfk.a(this.a).get(i)).a().equals(qfk.a(this.a).a()))
            {
              k = i;
              continue;
              k = j;
              if (((VideoInfo)qfk.a(this.a).get(i)).jdField_c_of_type_Boolean)
              {
                ((ArrayList)localObject2).add(Integer.valueOf(i));
                ((ArrayList)localObject3).add(qfk.a(this.a).get(i));
                k = j;
              }
            }
          }
        }
        if ((!qfk.a(this.a).c()) && (((String)localObject1).equals(qfk.a(this.a).g)))
        {
          localObject1 = qfk.b(this.a).iterator();
          while (((Iterator)localObject1).hasNext()) {
            ((qfm)((Iterator)localObject1).next()).c();
          }
          i = ((ArrayList)localObject2).size() - 1;
          while (i >= 0)
          {
            qfk.a(this.a).remove(((Integer)((ArrayList)localObject2).get(i)).intValue());
            qfk.a(this.a).notifyItemRemoved(((Integer)((ArrayList)localObject2).get(i)).intValue());
            i -= 1;
          }
          qfk.a(this.a).addAll(j + 1, paramBundle);
          qfk.a(this.a).notifyItemRangeInserted(j + 1, paramBundle.size());
          i = m;
          while (i < ((ArrayList)localObject2).size())
          {
            qfk.a(this.a).add(((Integer)((ArrayList)localObject2).get(i)).intValue(), ((ArrayList)localObject3).get(i));
            qfk.a(this.a).notifyItemInserted(((Integer)((ArrayList)localObject2).get(i)).intValue());
            i += 1;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qfn
 * JD-Core Version:    0.7.0.1
 */