import android.app.Activity;
import android.content.res.Resources;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopBannerInfo;
import com.tencent.biz.pubaccount.util.PreloadManager;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

class nij
  extends ohe
{
  nij(nii paramnii) {}
  
  private void b(String paramString) {}
  
  private void d(List<Long> paramList)
  {
    Object localObject = obz.a();
    if ((!bgmq.y((AppRuntime)localObject)) || (!bgmq.z((AppRuntime)localObject))) {}
    while ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    if (paramList.size() > 5) {}
    for (int i = 5;; i = paramList.size())
    {
      localObject = new ArrayList();
      int j = 0;
      while (j < i)
      {
        long l = ((Long)paramList.get(j)).longValue();
        ArticleInfo localArticleInfo = ogy.a().a(nii.a(this.a), l);
        if ((localArticleInfo != null) && (!obz.a(localArticleInfo))) {
          ((ArrayList)localObject).add((ArticleInfo)localArticleInfo);
        }
        j += 1;
      }
    }
    ogy.a().a().a((List)localObject);
  }
  
  public void a(int paramInt, List<Long> paramList)
  {
    if (paramInt != nii.a(this.a)) {
      return;
    }
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      nii.a(this.a, ogy.a().a(Integer.valueOf(nii.a(this.a)), paramList), 1);
      Object localObject1 = (Long)paramList.get(0);
      Object localObject2 = ogy.a().a(nii.a(this.a), ((Long)localObject1).longValue());
      StringBuilder localStringBuilder = new StringBuilder().append("load history successful ! first article title : ");
      if (localObject2 != null)
      {
        localObject1 = ((ArticleInfo)localObject2).mTitle;
        localObject1 = obz.c((String)localObject1);
        localStringBuilder = new StringBuilder().append((String)localObject1).append(" articleID : ");
        if (localObject2 == null) {
          break label285;
        }
      }
      label285:
      for (localObject1 = Long.valueOf(((ArticleInfo)localObject2).mArticleID);; localObject1 = "-1")
      {
        localObject1 = localObject1;
        QLog.d("ReadInJoyChannelWaterFallViewController_" + nii.a(this.a), 1, (String)localObject1);
        if (!QLog.isColorLevel()) {
          break label326;
        }
        localObject1 = new StringBuilder("onChannelArticleLoaded ");
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localObject2 = (Long)paramList.next();
          ((StringBuilder)localObject1).append("recommendSeq = " + localObject2 + ",\n ");
        }
        localObject1 = "";
        break;
      }
      QLog.d("ReadInJoyChannelWaterFallViewController_" + nii.a(this.a), 1, ((StringBuilder)localObject1).toString());
    }
    label326:
    this.a.a.a(true, true);
    paramList = this.a;
    if (!nii.a(this.a)) {}
    for (boolean bool = true;; bool = false)
    {
      if (!nii.a(paramList, bool)) {
        nii.a(this.a);
      }
      if (nii.a(this.a)) {
        break;
      }
      nii.b(this.a, true);
      return;
    }
  }
  
  public void a(int paramInt, boolean paramBoolean, List<ChannelCoverInfo> paramList)
  {
    super.a(paramInt, paramBoolean, paramList);
    if ((paramInt == nii.a(this.a)) && (paramBoolean) && (paramList != null) && (!paramList.isEmpty())) {
      this.a.a.c(paramList);
    }
  }
  
  public void a(TopBannerInfo paramTopBannerInfo) {}
  
  public void a(List<Long> paramList)
  {
    if (!PreloadManager.a().a()) {}
    for (;;)
    {
      return;
      PreloadManager.a().e();
      nii.a(this.a);
      if ((paramList != null) && (paramList.size() >= 5))
      {
        int i = 0;
        while (i < 5)
        {
          long l = ((Long)paramList.get(i)).longValue();
          Object localObject = ogy.a().a(nii.a(this.a), l);
          if ((localObject != null) && (!obz.a(((BaseArticleInfo)localObject).mArticleContentUrl, ((BaseArticleInfo)localObject).mChannelID, ((BaseArticleInfo)localObject).mFeedType, (ArticleInfo)localObject)) && (!obz.a((BaseArticleInfo)localObject)) && (!ogy.a().a(((BaseArticleInfo)localObject).mArticleID)))
          {
            localObject = ((BaseArticleInfo)localObject).mArticleContentUrl;
            if (xcu.a((String)localObject)) {
              PreloadManager.a().a((String)localObject);
            }
          }
          i += 1;
        }
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, long paramLong, List<Long> paramList, List<ArticleInfo> paramList1) {}
  
  public void a(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2)
  {
    if (paramInt != nii.a(this.a)) {
      return;
    }
    paramInt = ogy.a().a(Integer.valueOf(paramInt));
    Object localObject;
    if (paramBoolean1) {
      if ((paramList != null) && (paramInt > 0) && (paramList.size() > 0))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder("onChannelRefreshed ");
          Iterator localIterator = paramList.iterator();
          while (localIterator.hasNext())
          {
            Long localLong = (Long)localIterator.next();
            ((StringBuilder)localObject).append("recommendSeq = " + localLong + ",\n ");
          }
          QLog.d("ReadInJoyChannelWaterFallViewController_" + nii.a(this.a), 1, ((StringBuilder)localObject).toString());
        }
        nii.a(this.a, ogy.a().a(Integer.valueOf(nii.a(this.a)), paramList), 1);
        localObject = String.format(this.a.a().getResources().getString(2131652508), new Object[] { Integer.valueOf(paramInt) });
        this.a.a.a(true, (String)localObject);
      }
    }
    for (;;)
    {
      a(paramList);
      d(paramList);
      return;
      if (this.a.a.a())
      {
        this.a.a.b(true);
        b(this.a.a().getResources().getString(2131652712));
      }
      else
      {
        localObject = this.a.a().getResources().getString(2131652507);
        this.a.a.a(true, (String)localObject);
        continue;
        if (this.a.a.a()) {
          b(this.a.a().getResources().getString(2131652680));
        }
        this.a.a.b(paramBoolean1);
      }
    }
  }
  
  public void as_()
  {
    this.a.a.a();
  }
  
  public void b(int paramInt, List<Long> paramList)
  {
    if ((paramInt != nii.a(this.a)) || (paramList == null)) {
      return;
    }
    paramList = ogy.a().a(Integer.valueOf(nii.a(this.a)), paramList);
    this.a.a.b(paramList);
    this.a.a.a();
  }
  
  public void b(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2)
  {
    boolean bool = true;
    if (paramInt != nii.a(this.a))
    {
      nii.c(this.a, false);
      return;
    }
    if ((paramBoolean1) && (paramList != null)) {
      nii.a(this.a, ogy.a().a(Integer.valueOf(nii.a(this.a)), paramList), 2);
    }
    ojt localojt;
    if ((paramBoolean1) && (paramList == null))
    {
      paramBoolean2 = true;
      localojt = this.a.a;
      if (paramBoolean2) {
        break label278;
      }
    }
    for (;;)
    {
      localojt.a(paramBoolean1, bool);
      if ((paramList != null) && (!paramList.isEmpty())) {
        nii.a(this.a, NetConnInfoCenter.getServerTime());
      }
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyChannelWaterFallViewController", 2, "autoLoad:" + nii.b(this.a) + " noMoreData:" + paramBoolean2 + " fore:" + GesturePWDUtils.isAppOnForeground(this.a.a()));
      }
      if ((!nii.b(this.a)) && (paramBoolean2) && (GesturePWDUtils.isAppOnForeground(this.a.a())) && (nii.a(this.a) != 70))
      {
        paramList = this.a.a().getResources().getString(2131652507);
        bbmy.a(this.a.a().getApplicationContext(), paramList, 0).a();
      }
      nii.c(this.a, false);
      return;
      paramBoolean2 = false;
      break;
      label278:
      bool = false;
    }
  }
  
  public void c(int paramInt, List<Long> paramList)
  {
    if ((paramInt != nii.a(this.a)) || (paramList == null)) {}
    do
    {
      return;
      if (paramList.size() > 0)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder("refreshChannelData ");
          localStringBuilder.append("channelID : ").append(paramInt).append("\n");
          Iterator localIterator = paramList.iterator();
          while (localIterator.hasNext())
          {
            Long localLong = (Long)localIterator.next();
            localStringBuilder.append("recommendSeq = " + localLong + ",\n ");
          }
          QLog.d("ReadInJoyChannelWaterFallViewController_" + nii.a(this.a), 1, localStringBuilder.toString());
        }
        nii.a(this.a, ogy.a().a(Integer.valueOf(nii.a(this.a)), paramList), 1);
        return;
      }
    } while (!this.a.a.a());
    b(this.a.a().getResources().getString(2131652712));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nij
 * JD-Core Version:    0.7.0.1
 */