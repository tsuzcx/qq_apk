import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.MemoryInfoEntry;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.map.geolocation.TencentLocation;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class swm
  extends swl
  implements slx<szk, tbi>
{
  protected String a;
  protected swp a;
  protected String b;
  protected long c;
  protected String c;
  protected final String d;
  
  public swm(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_c_of_type_JavaLangString = paramString2;
    this.d = a(this.jdField_b_of_type_JavaLangString);
  }
  
  public static String a(String paramString)
  {
    return paramString;
  }
  
  private void d()
  {
    int i = vms.a();
    Object localObject;
    MemoryInfoEntry localMemoryInfoEntry;
    long l;
    if (this.jdField_a_of_type_Swp.jdField_a_of_type_Int != i)
    {
      urk.d("Q.qqstory.net:DateCollectionListPageLoader", "timezone has changed. old=%d, new=%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Swp.jdField_a_of_type_Int), Integer.valueOf(i) });
      localObject = (spt)sqg.a(19);
      localMemoryInfoEntry = ((spt)localObject).a(this.d);
      if (localMemoryInfoEntry == null)
      {
        localObject = new MemoryInfoEntry(this.d);
        ((MemoryInfoEntry)localObject).seq = 0L;
        ((MemoryInfoEntry)localObject).timeZone = i;
        this.jdField_a_of_type_Swp.a((MemoryInfoEntry)localObject);
      }
    }
    else
    {
      if (!a(this.jdField_a_of_type_JavaLangString)) {
        break label264;
      }
      l = this.jdField_a_of_type_Swp.jdField_a_of_type_Long;
      label125:
      this.jdField_c_of_type_Long = l;
      localObject = new szk();
      ((szk)localObject).c = 10;
      ((szk)localObject).d = 10;
      ((szk)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      ((szk)localObject).jdField_b_of_type_Long = l;
      ((szk)localObject).e = this.jdField_a_of_type_Swp.jdField_a_of_type_Int;
      ((szk)localObject).jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      localMemoryInfoEntry = ((spt)sqg.a(19)).a(this.d);
      if (localMemoryInfoEntry != null) {
        if (localMemoryInfoEntry.isFriend != 1) {
          break label269;
        }
      }
    }
    label264:
    label269:
    for (boolean bool = true;; bool = false)
    {
      ((szk)localObject).jdField_a_of_type_Boolean = bool;
      slv.a().a((slz)localObject, this);
      return;
      localMemoryInfoEntry.seq = 0L;
      localMemoryInfoEntry.timeZone = i;
      localObject = ((spt)localObject).a(localMemoryInfoEntry);
      break;
      l = 0L;
      break label125;
    }
  }
  
  public void a(@Nullable TencentLocation paramTencentLocation, int paramInt)
  {
    super.a(paramTencentLocation, paramInt);
    Bosses.get().postJob(new swn(this, "Q.qqstory.net:DateCollectionListPageLoader"));
  }
  
  public void a(@NonNull szk paramszk, @Nullable tbi paramtbi, @NonNull ErrorMessage paramErrorMessage)
  {
    if (paramszk.jdField_b_of_type_Long != this.jdField_c_of_type_Long)
    {
      urk.a("Q.qqstory.net:DateCollectionListPageLoader", "%d request is old , now seq = %d , give up", Long.valueOf(paramszk.jdField_b_of_type_Long), Long.valueOf(this.jdField_c_of_type_Long));
      return;
    }
    spt localspt = (spt)sqg.a(19);
    MemoryInfoEntry localMemoryInfoEntry = localspt.a(this.d);
    if (localMemoryInfoEntry == null) {
      localMemoryInfoEntry = new MemoryInfoEntry(this.d);
    }
    for (;;)
    {
      boolean bool2 = a(paramszk.jdField_a_of_type_JavaLangString);
      swq localswq = new swq(this.jdField_c_of_type_JavaLangString, paramErrorMessage);
      localswq.jdField_b_of_type_JavaLangString = paramszk.jdField_b_of_type_JavaLangString;
      localswq.c = bool2;
      localswq.jdField_b_of_type_Boolean = false;
      if ((paramtbi == null) || ((paramErrorMessage.isFail()) && (paramErrorMessage.errorCode != 11111)))
      {
        sgi.a().dispatch(localswq);
        return;
      }
      int i;
      boolean bool1;
      label231:
      Object localObject1;
      label293:
      label312:
      long l;
      Object localObject2;
      if ((localMemoryInfoEntry.isFriend != -1) && (localMemoryInfoEntry.isFriend != paramtbi.c))
      {
        i = 1;
        localMemoryInfoEntry.isFriend = paramtbi.c;
        localswq.jdField_a_of_type_Boolean = paramtbi.jdField_a_of_type_Boolean;
        localswq.jdField_a_of_type_JavaUtilList = paramtbi.jdField_a_of_type_JavaUtilArrayList;
        localswq.jdField_a_of_type_Int = paramtbi.b;
        if ((paramtbi.jdField_a_of_type_Long == paramszk.jdField_b_of_type_Long) && (i == 0)) {
          break label487;
        }
        bool1 = true;
        localswq.e = bool1;
        if (!localswq.e) {
          break label524;
        }
        localObject1 = paramtbi.jdField_a_of_type_JavaUtilArrayList;
        if (localObject1 != null)
        {
          Collections.sort((List)localObject1, new uhi());
          localspt.a((List)localObject1, paramszk.jdField_b_of_type_JavaLangString, bool2);
        }
        if (i == 0) {
          break label493;
        }
        localMemoryInfoEntry.seq = 0L;
        localMemoryInfoEntry.cookie = paramtbi.jdField_a_of_type_JavaLangString;
        if (!paramtbi.jdField_a_of_type_Boolean) {
          break label505;
        }
        i = 1;
        localMemoryInfoEntry.isEnd = i;
        l = this.jdField_a_of_type_Swp.jdField_a_of_type_Long;
        localObject2 = this.jdField_a_of_type_Swp.jdField_a_of_type_JavaLangString;
        if (!paramtbi.jdField_a_of_type_Boolean) {
          break label511;
        }
      }
      label487:
      label493:
      label505:
      label511:
      for (paramszk = "true";; paramszk = "false")
      {
        urk.a("Q.qqstory.net:DateCollectionListPageLoader", "save cache state , seq = %d ,cookie = %s , isEnd = %s", Long.valueOf(l), localObject2, paramszk);
        paramszk = (uje)sqg.a(11);
        if (localObject1 == null) {
          break label524;
        }
        paramtbi = new ArrayList(((List)localObject1).size());
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (VideoCollectionItem)((Iterator)localObject1).next();
          if (!TextUtils.isEmpty(((VideoCollectionItem)localObject2).feedId))
          {
            FeedItem localFeedItem = paramszk.a(((VideoCollectionItem)localObject2).feedId);
            if (localFeedItem != null)
            {
              if ((localFeedItem instanceof VideoListFeedItem)) {
                ((VideoListFeedItem)localFeedItem).mViewTotalTime = ((VideoCollectionItem)localObject2).viewTimes;
              }
              paramtbi.add(localFeedItem);
            }
          }
        }
        i = 0;
        break;
        bool1 = false;
        break label231;
        localMemoryInfoEntry.seq = paramtbi.jdField_a_of_type_Long;
        break label293;
        i = 0;
        break label312;
      }
      paramszk.a(paramtbi);
      label524:
      if (paramErrorMessage.errorCode == 11111) {
        localMemoryInfoEntry.seq = 0L;
      }
      paramszk = localspt.a(localMemoryInfoEntry);
      this.jdField_a_of_type_Swp.a(paramszk);
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Swp.jdField_a_of_type_JavaLangString;
      sgi.a().dispatch(localswq);
      return;
    }
  }
  
  protected boolean a(String paramString)
  {
    return (TextUtils.isEmpty(paramString)) || (paramString.equals("0"));
  }
  
  public void c()
  {
    super.c();
    Bosses.get().postJob(new swo(this, "Q.qqstory.net:DateCollectionListPageLoader"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     swm
 * JD-Core Version:    0.7.0.1
 */