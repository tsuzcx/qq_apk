import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class qfk
{
  private long jdField_a_of_type_Long;
  private VideoInfo jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
  private VideoFeedsRecyclerView jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private ArrayList<qfm> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private nev jdField_a_of_type_Nev;
  private pzs jdField_a_of_type_Pzs;
  private boolean jdField_a_of_type_Boolean;
  private ArrayList<VideoInfo> b;
  
  public qfk(AppInterface paramAppInterface, BaseActivity paramBaseActivity, ArrayList<VideoInfo> paramArrayList, pzs parampzs, VideoFeedsRecyclerView paramVideoFeedsRecyclerView)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.b = paramArrayList;
    this.jdField_a_of_type_Pzs = parampzs;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView = paramVideoFeedsRecyclerView;
  }
  
  public VideoInfo a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
    }
    return null;
  }
  
  public String a()
  {
    for (;;)
    {
      int m;
      try
      {
        localJSONObject1 = new JSONObject();
        localJSONArray = new JSONArray();
        i = 0;
        if (i >= this.b.size()) {
          break label667;
        }
        if ((((VideoInfo)this.b.get(i)).a() == null) || (!((VideoInfo)this.b.get(i)).a().equals(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a()))) {
          break label672;
        }
        j = i;
      }
      catch (Exception localException)
      {
        JSONObject localJSONObject1;
        JSONArray localJSONArray;
        VideoInfo localVideoInfo;
        JSONObject localJSONObject2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsRecommendManager", 2, "getRequestHistoryData() ERROR = " + localException.getMessage());
        return null;
      }
      if (k >= 0)
      {
        localVideoInfo = (VideoInfo)this.b.get(k);
        if (localVideoInfo.a != null)
        {
          localJSONObject2 = new JSONObject();
          localJSONObject2.put("rowkey", localVideoInfo.g);
          localJSONObject2.put("video_duration", localVideoInfo.a());
          localJSONObject2.put("watch_duration", (float)localVideoInfo.a.jdField_a_of_type_Long / 1000.0F);
          localJSONObject2.put("alg_id", localVideoInfo.f);
          localJSONObject2.put("video_index", k);
          if (!localVideoInfo.a.jdField_a_of_type_Boolean) {
            break label704;
          }
          m = 1;
          localJSONObject2.put("is_biu", m);
          if (!localVideoInfo.a.b) {
            break label710;
          }
          m = 1;
          localJSONObject2.put("is_like", m);
          if (!localVideoInfo.a.c) {
            break label716;
          }
          m = 1;
          localJSONObject2.put("is_comment", m);
          localJSONArray.put(localJSONObject2);
          i += 1;
          break label695;
        }
      }
      else
      {
        localJSONObject1.put("play_info", localJSONArray);
        localJSONObject1.put("first_rowkey", ((VideoInfo)this.b.get(0)).g);
        if (((VideoInfo)this.b.get(0)).a != null)
        {
          localJSONObject1.put("first_watch_duration", (float)((VideoInfo)this.b.get(0)).a.jdField_a_of_type_Long / 1000.0F);
          localJSONObject1.put("first_video_duration", ((VideoInfo)this.b.get(0)).a());
          localJSONObject1.put("current_rowkey", this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g);
          localJSONObject1.put("current_watch_duration", (float)this.jdField_a_of_type_Long / 1000.0F);
          localJSONObject1.put("current_video_duration", this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a());
          localJSONObject1.put("current_algid", this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.f);
          if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a == null) {
            break label634;
          }
          if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a.jdField_a_of_type_Boolean)
          {
            i = 1;
            localJSONObject1.put("current_isbiu", i);
            if (!this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a.c) {
              break label624;
            }
            i = 1;
            localJSONObject1.put("current_iscomment", i);
            if (!this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a.b) {
              break label629;
            }
            i = 1;
            localJSONObject1.put("current_islike", i);
            localJSONObject1.put("current_video_index", j);
            if (QLog.isColorLevel()) {
              QLog.d("Q.pubaccount.video.feeds.VideoFeedsRecommendManager", 2, "触发动态插入 json = " + localJSONObject1.toString());
            }
            return localJSONObject1.toString();
          }
        }
        else
        {
          localJSONObject1.put("first_watch_duration", 0);
          continue;
        }
        i = 0;
        continue;
        label624:
        i = 0;
        continue;
        label629:
        i = 0;
        continue;
        label634:
        localException.put("current_isbiu", 0);
        localException.put("current_iscomment", 0);
        localException.put("current_islike", 0);
        continue;
      }
      break label695;
      label667:
      int j = -1;
      break label679;
      label672:
      i += 1;
      continue;
      label679:
      if (j == -1) {
        return null;
      }
      int k = j - 1;
      int i = 0;
      continue;
      label695:
      if (i >= 10)
      {
        continue;
        label704:
        m = 0;
        continue;
        label710:
        m = 0;
        continue;
        label716:
        m = 0;
      }
      else
      {
        k -= 1;
      }
    }
  }
  
  public nev a()
  {
    if (this.jdField_a_of_type_Nev == null)
    {
      this.jdField_a_of_type_Nev = new qfn(this, null);
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.addObserver(this.jdField_a_of_type_Nev);
    }
    return this.jdField_a_of_type_Nev;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.removeObserver(this.jdField_a_of_type_Nev);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = null;
  }
  
  public void a(int paramInt, VideoInfo paramVideoInfo, long paramLong)
  {
    Iterator localIterator = this.b.iterator();
    VideoInfo localVideoInfo;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localVideoInfo = (VideoInfo)localIterator.next();
    } while ((localVideoInfo.a() == null) || (!localVideoInfo.a().equals(paramVideoInfo.a())));
    for (paramVideoInfo = localVideoInfo;; paramVideoInfo = null)
    {
      if (paramVideoInfo == null) {
        return;
      }
      if (paramVideoInfo.a == null) {
        paramVideoInfo.a = new ner();
      }
      switch (paramInt)
      {
      default: 
        return;
      case 1: 
        paramVideoInfo.a.jdField_a_of_type_Long = paramLong;
        return;
      case 2: 
        paramVideoInfo.a.jdField_a_of_type_Boolean = true;
        return;
      case 3: 
        paramVideoInfo.a.b = true;
        return;
      }
      paramVideoInfo.a.c = true;
      return;
    }
  }
  
  /* Error */
  public void a(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 222	qfk:jdField_a_of_type_Boolean	Z
    //   6: istore_3
    //   7: iload_3
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: lload_1
    //   16: putfield 143	qfk:jdField_a_of_type_Long	J
    //   19: aload_0
    //   20: getfield 43	qfk:jdField_a_of_type_ComTencentBizPubaccountVideoInfo	Lcom/tencent/biz/pubaccount/VideoInfo;
    //   23: getfield 226	com/tencent/biz/pubaccount/VideoInfo:q	I
    //   26: ifeq -15 -> 11
    //   29: aload_0
    //   30: getfield 143	qfk:jdField_a_of_type_Long	J
    //   33: aload_0
    //   34: getfield 43	qfk:jdField_a_of_type_ComTencentBizPubaccountVideoInfo	Lcom/tencent/biz/pubaccount/VideoInfo;
    //   37: getfield 226	com/tencent/biz/pubaccount/VideoInfo:q	I
    //   40: sipush 1000
    //   43: imul
    //   44: i2l
    //   45: lcmp
    //   46: ifle -35 -> 11
    //   49: aload_0
    //   50: iconst_1
    //   51: putfield 222	qfk:jdField_a_of_type_Boolean	Z
    //   54: invokestatic 161	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   57: ifeq +34 -> 91
    //   60: ldc 163
    //   62: iconst_2
    //   63: new 165	java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   70: ldc 228
    //   72: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: aload_0
    //   76: getfield 43	qfk:jdField_a_of_type_ComTencentBizPubaccountVideoInfo	Lcom/tencent/biz/pubaccount/VideoInfo;
    //   79: getfield 230	com/tencent/biz/pubaccount/VideoInfo:c	Ljava/lang/String;
    //   82: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: invokestatic 180	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   91: aload_0
    //   92: getfield 27	qfk:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   95: invokevirtual 210	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   98: astore 4
    //   100: aload 4
    //   102: invokeinterface 215 1 0
    //   107: ifeq -96 -> 11
    //   110: aload 4
    //   112: invokeinterface 219 1 0
    //   117: checkcast 232	qfm
    //   120: invokeinterface 234 1 0
    //   125: goto -25 -> 100
    //   128: astore 4
    //   130: aload_0
    //   131: monitorexit
    //   132: aload 4
    //   134: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	135	0	this	qfk
    //   0	135	1	paramLong	long
    //   6	2	3	bool	boolean
    //   98	13	4	localIterator	Iterator
    //   128	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	128	finally
    //   14	91	128	finally
    //   91	100	128	finally
    //   100	125	128	finally
  }
  
  public void a(VideoInfo paramVideoInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = paramVideoInfo;
    this.jdField_a_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsRecommendManager", 2, "切换视频 videoInfo.DynamicTriggerSec = " + this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.q);
    }
  }
  
  public void a(qfm paramqfm)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(paramqfm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qfk
 * JD-Core Version:    0.7.0.1
 */