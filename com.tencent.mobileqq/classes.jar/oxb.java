import android.content.res.Configuration;
import android.support.annotation.UiThread;
import android.util.SparseArray;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.model.DiandianTopConfig;
import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule.PositionData;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.InterestLabelInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.RecommendFollowInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TagInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopBannerInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import tencent.im.oidb.cmd0xbd6.oidb_cmd0xbd6.RspBody;
import tencent.im.oidb.cmd0xc6d.oidb_cmd0xc6d.ModuleInfo;
import tencent.im.oidb.cmd0xc6d.oidb_cmd0xc6d.TextCardInfo;

public class oxb
{
  private static oxb jdField_a_of_type_Oxb;
  private final CopyOnWriteArrayList<oxe> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  
  public static oxb a()
  {
    try
    {
      if (jdField_a_of_type_Oxb == null) {
        jdField_a_of_type_Oxb = new oxb();
      }
      return jdField_a_of_type_Oxb;
    }
    finally {}
  }
  
  public void a()
  {
    ??? = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    oxe localoxe;
    do
    {
      if (!((Iterator)???).hasNext()) {
        break;
      }
      localoxe = (oxe)((Iterator)???).next();
    } while (!(localoxe instanceof ampi));
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
      {
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
        if (localoxe != null) {
          this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(localoxe);
        }
        return;
      }
      Object localObject2 = null;
    }
  }
  
  public void a(float paramFloat, int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((oxe)localIterator.next()).a(paramFloat, paramInt);
      }
    }
  }
  
  public void a(int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((oxe)localIterator.next()).e(paramInt);
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((oxe)localIterator.next()).a(paramInt1, paramInt2);
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, pfm parampfm)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((oxe)localIterator.next()).a(paramInt1, paramInt2, paramInt3, paramBoolean, parampfm);
      }
    }
  }
  
  public void a(int paramInt, long paramLong, String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((oxe)localIterator.next()).a(paramInt, paramLong, paramString);
      }
    }
  }
  
  public void a(int paramInt1, long paramLong, String paramString1, int paramInt2, String paramString2, String paramString3)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((oxe)localIterator.next()).a(paramInt1, paramLong, paramString1, paramInt2, paramString2, paramString3);
      }
    }
  }
  
  public void a(int paramInt1, long paramLong, List<Long> paramList, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((oxe)localIterator.next()).a(paramInt1, paramLong, paramList, paramInt2, paramInt3, paramBoolean);
      }
    }
  }
  
  public void a(int paramInt, SelectPositionModule.PositionData paramPositionData)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = new ArrayList(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList).iterator();
      if (localIterator.hasNext()) {
        ((oxe)localIterator.next()).a(paramInt, paramPositionData);
      }
    }
  }
  
  public void a(int paramInt, ArticleInfo paramArticleInfo, String paramString1, String paramString2)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((oxe)localIterator.next()).a(paramInt, paramArticleInfo, paramString1, paramString2);
      }
    }
  }
  
  public void a(int paramInt, Object paramObject)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((oxe)localIterator.next()).a(paramInt, paramObject);
      }
    }
  }
  
  public void a(int paramInt, List<Long> paramList)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((oxe)localIterator.next()).a(paramInt, paramList);
      }
    }
  }
  
  public void a(int paramInt, qlf paramqlf)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((oxe)localIterator.next()).a(paramInt, paramqlf);
      }
    }
  }
  
  public void a(int paramInt, boolean paramBoolean, List<ChannelCoverInfo> paramList)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((oxe)localIterator.next()).a(paramInt, paramBoolean, paramList);
      }
    }
  }
  
  public void a(long paramLong, int paramInt, String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((oxe)localIterator.next()).a(paramLong, paramInt, paramString);
      }
    }
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((oxe)localIterator.next()).a(paramLong, paramBoolean);
      }
    }
  }
  
  public void a(Configuration paramConfiguration)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((oxe)localIterator.next()).a(paramConfiguration);
      }
    }
  }
  
  public void a(View paramView)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((oxe)localIterator.next()).a(paramView);
      }
    }
  }
  
  public void a(ArticleInfo paramArticleInfo, boolean paramBoolean)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((oxe)localIterator.next()).a(paramArticleInfo, paramBoolean);
      }
    }
  }
  
  public void a(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = new ArrayList(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList).iterator();
      if (localIterator.hasNext()) {
        ((oxe)localIterator.next()).a(paramTabChannelCoverInfo);
      }
    }
  }
  
  public void a(TopBannerInfo paramTopBannerInfo)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((oxe)localIterator.next()).a(paramTopBannerInfo);
      }
    }
  }
  
  public void a(Object paramObject, int paramInt, boolean paramBoolean, String... paramVarArgs)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((oxe)localIterator.next()).a(paramObject, paramInt, paramBoolean, paramVarArgs);
      }
    }
  }
  
  public void a(String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((oxe)localIterator.next()).a(paramString);
      }
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((oxe)localIterator.next()).a(paramString, paramInt);
      }
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((oxe)localIterator.next()).a(paramString, paramInt1, paramInt2);
      }
    }
  }
  
  public void a(String paramString1, int paramInt1, long paramLong, String paramString2, int paramInt2, String paramString3, String paramString4)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((oxe)localIterator.next()).a(paramString1, paramInt1, paramLong, paramString2, paramInt2, paramString3, paramString4);
      }
    }
  }
  
  public void a(String paramString1, int paramInt, oidb_cmd0xbd6.RspBody paramRspBody, String paramString2)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((oxe)localIterator.next()).a(paramString1, paramInt, paramRspBody, paramString2);
      }
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((oxe)localIterator.next()).a(paramString1, paramString2, paramInt);
      }
    }
  }
  
  public void a(ArrayList<String> paramArrayList, List<oidb_cmd0xc6d.ModuleInfo> paramList, List<oidb_cmd0xc6d.TextCardInfo> paramList1)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((oxe)localIterator.next()).a(paramArrayList, paramList, paramList1);
      }
    }
  }
  
  public void a(List<InterestLabelInfo> paramList)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((oxe)localIterator.next()).b(paramList);
      }
    }
  }
  
  public void a(List<String> paramList, List<TopicInfo> paramList1)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((oxe)localIterator.next()).a(paramList, paramList1);
      }
    }
  }
  
  public void a(oxc paramoxc)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext()) {
      paramoxc.a((oxe)localIterator.next());
    }
  }
  
  public void a(oxe paramoxe)
  {
    if (paramoxe == null) {}
    while (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(paramoxe)) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramoxe);
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((oxe)localIterator.next()).d(paramBoolean);
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, long paramLong, List<Long> paramList, List<ArticleInfo> paramList1)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((oxe)localIterator.next()).a(paramBoolean, paramInt, paramLong, paramList, paramList1);
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, SparseArray<ChannelInfo> paramSparseArray)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((oxe)localIterator.next()).a(paramBoolean, paramInt, paramSparseArray);
      }
    }
  }
  
  public void a(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((oxe)localIterator.next()).a(paramBoolean1, paramInt, paramList, paramBoolean2);
      }
    }
  }
  
  public void a(boolean paramBoolean, long paramLong, List<RecommendFollowInfo> paramList)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((oxe)localIterator.next()).a(paramBoolean, paramLong, paramList);
      }
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((oxe)localIterator.next()).a(paramBoolean, paramString);
      }
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((oxe)localIterator.next()).a(paramBoolean, paramString1, paramString2, paramString3, paramInt1, paramInt2);
      }
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, int paramInt2, String paramString5)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((oxe)localIterator.next()).a(paramBoolean, paramString1, paramString2, paramString3, paramInt1, paramString4, paramInt2, paramString5);
      }
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((oxe)localIterator.next()).a(paramBoolean, paramString1, paramString2, paramString3, paramString4, paramInt);
      }
    }
  }
  
  public void a(boolean paramBoolean, List<DiandianTopConfig> paramList)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((oxe)localIterator.next()).d(paramBoolean, paramList);
      }
    }
  }
  
  public void a(boolean paramBoolean1, List<qkw> paramList, long paramLong, boolean paramBoolean2)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((oxe)localIterator.next()).b(paramBoolean1, paramList, paramLong, paramBoolean2);
      }
    }
  }
  
  public void a(boolean paramBoolean, List<Long> paramList, List<ArticleInfo> paramList1)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((oxe)localIterator.next()).a(paramBoolean, paramList, paramList1);
      }
    }
  }
  
  public void b()
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((oxe)localIterator.next()).au_();
      }
    }
  }
  
  public void b(int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((oxe)localIterator.next()).b(paramInt);
      }
    }
  }
  
  public void b(int paramInt, List<Long> paramList)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((oxe)localIterator.next()).c(paramInt, paramList);
      }
    }
  }
  
  public void b(long paramLong, boolean paramBoolean)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((oxe)localIterator.next()).b(paramLong, paramBoolean);
      }
    }
  }
  
  public void b(List<sut> paramList)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((oxe)localIterator.next()).a_(paramList);
      }
    }
  }
  
  public void b(oxe paramoxe)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(paramoxe);
      return;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = new ArrayList(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList).iterator();
      if (localIterator.hasNext()) {
        ((oxe)localIterator.next()).b(paramBoolean);
      }
    }
  }
  
  public void b(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((oxe)localIterator.next()).b(paramBoolean1, paramInt, paramList, paramBoolean2);
      }
    }
  }
  
  public void b(boolean paramBoolean, List<ChannelInfo> paramList)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((oxe)localIterator.next()).e(paramBoolean, paramList);
      }
    }
  }
  
  public void b(boolean paramBoolean1, List<qkw> paramList, long paramLong, boolean paramBoolean2)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((oxe)localIterator.next()).a(paramBoolean1, paramList, paramLong, paramBoolean2);
      }
    }
  }
  
  public void c()
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((oxe)localIterator.next()).d();
      }
    }
  }
  
  public void c(int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((oxe)localIterator.next()).c(paramInt);
      }
    }
  }
  
  public void c(int paramInt, List<Long> paramList)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((oxe)localIterator.next()).b(paramInt, paramList);
      }
    }
  }
  
  public void c(List<TagInfo> paramList)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((oxe)localIterator.next()).c(paramList);
      }
    }
  }
  
  public void c(boolean paramBoolean)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((oxe)localIterator.next()).f(paramBoolean);
      }
    }
  }
  
  public void c(boolean paramBoolean, List<ChannelInfo> paramList)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((oxe)localIterator.next()).f(paramBoolean, paramList);
      }
    }
  }
  
  public void c(boolean paramBoolean1, List<qkv> paramList, long paramLong, boolean paramBoolean2)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((oxe)localIterator.next()).c(paramBoolean1, paramList, paramLong, paramBoolean2);
      }
    }
  }
  
  public void d()
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((oxe)localIterator.next()).e();
      }
    }
  }
  
  public void d(int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((oxe)localIterator.next()).g(paramInt);
      }
    }
  }
  
  public void d(boolean paramBoolean)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((oxe)localIterator.next()).e(paramBoolean);
      }
    }
  }
  
  public void d(boolean paramBoolean, List<Integer> paramList)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((oxe)localIterator.next()).g(paramBoolean, paramList);
      }
    }
  }
  
  public void e()
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((oxe)localIterator.next()).n();
      }
    }
  }
  
  public void e(int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((oxe)localIterator.next()).d(paramInt);
      }
    }
  }
  
  @UiThread
  public void e(boolean paramBoolean)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((oxe)localIterator.next()).a(paramBoolean);
      }
    }
  }
  
  public void e(boolean paramBoolean, List<TabChannelCoverInfo> paramList)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = new ArrayList(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList).iterator();
      if (localIterator.hasNext()) {
        ((oxe)localIterator.next()).a(paramBoolean, paramList);
      }
    }
  }
  
  public void f()
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((oxe)localIterator.next()).o();
      }
    }
  }
  
  public void f(int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((oxe)localIterator.next()).f(paramInt);
      }
    }
  }
  
  public void f(boolean paramBoolean, List<ChannelCoverInfo> paramList)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((oxe)localIterator.next()).b(paramBoolean, paramList);
      }
    }
  }
  
  public void g()
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((oxe)localIterator.next()).f();
      }
    }
  }
  
  public void g(int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = new ArrayList(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList).iterator();
      if (localIterator.hasNext()) {
        ((oxe)localIterator.next()).a(paramInt);
      }
    }
  }
  
  public void g(boolean paramBoolean, List<ChannelCoverInfo> paramList)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((oxe)localIterator.next()).c(paramBoolean, paramList);
      }
    }
  }
  
  public void h()
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((oxe)localIterator.next()).g();
      }
    }
  }
  
  public void h(boolean paramBoolean, List<ChannelCoverInfo> paramList)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((oxe)localIterator.next()).h(paramBoolean, paramList);
      }
    }
  }
  
  public void i()
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((oxe)localIterator.next()).h();
      }
    }
  }
  
  public void j()
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = new ArrayList(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList).iterator();
      if (localIterator.hasNext()) {
        ((oxe)localIterator.next()).i();
      }
    }
  }
  
  public void k()
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((oxe)localIterator.next()).j();
      }
    }
  }
  
  public void l()
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((oxe)localIterator.next()).k();
      }
    }
  }
  
  public void m()
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((oxe)localIterator.next()).l();
      }
    }
  }
  
  public void n()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext()) {
      ((oxe)localIterator.next()).m();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     oxb
 * JD-Core Version:    0.7.0.1
 */