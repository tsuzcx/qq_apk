import android.annotation.TargetApi;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.async.Job;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@TargetApi(14)
public class suq
{
  private long jdField_a_of_type_Long;
  protected List<StoryVideoItem> a;
  public suo a;
  protected sus a;
  public sut a;
  protected suu a;
  private boolean jdField_a_of_type_Boolean;
  protected List<sul> b = new ArrayList();
  protected List<String> c = new ArrayList();
  
  public suq()
  {
    this.jdField_a_of_type_Suo = new svd();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Sut = new sut(this);
    this.jdField_a_of_type_Suo.a(0);
    this.jdField_a_of_type_Suo.a(this.jdField_a_of_type_Sut);
  }
  
  private boolean a()
  {
    long l = System.currentTimeMillis();
    if (Math.abs(l - this.jdField_a_of_type_Long) > 5000L)
    {
      this.jdField_a_of_type_Long = l;
      this.jdField_a_of_type_Boolean = bbev.h(BaseApplicationImpl.getContext());
    }
    return this.jdField_a_of_type_Boolean;
  }
  
  public String a(String paramString)
  {
    this.jdField_a_of_type_Sus = new sus(paramString);
    paramString = a(paramString, uee.a(BaseApplicationImpl.getContext()).a());
    a(true);
    return paramString;
  }
  
  protected String a(String paramString, boolean paramBoolean)
  {
    Object localObject2 = null;
    if ((!this.c.isEmpty()) && (this.c.contains(paramString)))
    {
      QQStoryContext.a();
      paramString = vws.a(QQStoryContext.a(), paramString);
      if (!(paramString instanceof MessageForShortVideo)) {
        break label141;
      }
    }
    label141:
    for (paramString = (MessageForShortVideo)paramString;; paramString = null)
    {
      Object localObject1 = localObject2;
      if (paramString != null)
      {
        paramString = ShortVideoUtils.a(paramString, "mp4");
        if (!vyi.c(paramString)) {
          break label77;
        }
        localObject1 = paramString;
      }
      label77:
      do
      {
        do
        {
          return localObject1;
          paramString = null;
          break;
          if (a(paramString))
          {
            localObject1 = sum.a(paramString, 0, paramBoolean, paramBoolean);
            if (localObject1 != null) {
              return ((File)localObject1).getAbsolutePath();
            }
          }
          localObject1 = localObject2;
        } while (!StoryVideoItem.isFakeVid(paramString));
        paramString = ((tcz)tdc.a(5)).a(paramString);
        localObject1 = localObject2;
      } while (paramString == null);
      return paramString.mLocalVideoPath;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Suo.a();
    this.jdField_a_of_type_Suu = null;
  }
  
  public void a(List<StoryVideoItem> paramList)
  {
    if (paramList == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList = new ArrayList(paramList);
  }
  
  public void a(suu paramsuu)
  {
    this.jdField_a_of_type_Suu = paramsuu;
  }
  
  protected void a(boolean paramBoolean)
  {
    sur localsur = new sur(this, "Q.qqstory.download.preload.PlayingListPreloader", paramBoolean);
    localsur.setJobType(4);
    Bosses.get().postJob(localsur);
  }
  
  protected boolean a(String paramString)
  {
    return StoryVideoItem.isPlayable(paramString, true);
  }
  
  protected void b(boolean paramBoolean)
  {
    List localList1 = this.jdField_a_of_type_JavaUtilList;
    String str;
    List localList2;
    int k;
    label33:
    ArrayList localArrayList;
    int i;
    label52:
    int j;
    if (this.jdField_a_of_type_Sus == null)
    {
      str = "";
      localList2 = this.c;
      if (!a()) {
        break label333;
      }
      k = 3;
      localArrayList = new ArrayList();
      if (TextUtils.isEmpty(str)) {
        break label470;
      }
      i = 0;
      if (i >= localList1.size()) {
        break label465;
      }
      if (!TextUtils.equals(((StoryVideoItem)localList1.get(i)).mVid, str)) {
        break label339;
      }
      j = 1;
    }
    for (;;)
    {
      if (j == 0) {
        i = 0;
      }
      j = i;
      i = 0;
      for (;;)
      {
        int m = i;
        Object localObject;
        label151:
        sul localsul1;
        if (j < localList1.size())
        {
          localObject = (StoryVideoItem)localList1.get(j);
          if ((localList2.isEmpty()) || (!localList2.contains(((StoryVideoItem)localObject).mVid))) {
            break label346;
          }
          paramBoolean = true;
          if (!TextUtils.equals(str, ((StoryVideoItem)localObject).mVid)) {
            break label371;
          }
          localsul1 = sul.a(((StoryVideoItem)localObject).mVid, 1);
          sul localsul2 = sul.a(((StoryVideoItem)localObject).mVid, 0, paramBoolean);
          localObject = sul.a(((StoryVideoItem)localObject).mVid, 2, paramBoolean);
          localsul1.g = 0;
          localsul2.g = 0;
          ((sul)localObject).g = 1;
          localArrayList.add(localsul1);
          if (uee.a(BaseApplicationImpl.getContext()).a()) {
            break label351;
          }
          localArrayList.add(localsul2);
          localsul2.a.put("handleCallback", Boolean.valueOf(true));
          label266:
          localArrayList.add(localObject);
        }
        for (;;)
        {
          i += 1;
          if (i < k) {
            break label458;
          }
          m = i;
          veg.a("Q.qqstory.download.preload.PlayingListPreloader", "start download ,download count = %d", Integer.valueOf(m));
          this.b = localArrayList;
          this.jdField_a_of_type_Suo.a(localArrayList, true);
          return;
          str = this.jdField_a_of_type_Sus.a;
          break;
          label333:
          k = 2;
          break label33;
          label339:
          i += 1;
          break label52;
          label346:
          paramBoolean = false;
          break label151;
          label351:
          localsul1.a.put("handleCallback", Boolean.valueOf(true));
          break label266;
          label371:
          localArrayList.add(sul.a(((StoryVideoItem)localObject).mVid, 2, paramBoolean));
          localArrayList.add(sul.a(((StoryVideoItem)localObject).mVid, 1));
          localsul1 = sul.a(((StoryVideoItem)localObject).mVid, 0, paramBoolean);
          localsul1.a.put("handleCallback", Boolean.valueOf(true));
          localArrayList.add(localsul1);
          localArrayList.add(localsul1);
        }
        label458:
        j += 1;
      }
      label465:
      j = 0;
      continue;
      label470:
      j = 0;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     suq
 * JD-Core Version:    0.7.0.1
 */