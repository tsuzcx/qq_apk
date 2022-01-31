import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class shg
{
  protected String a;
  public List<WeakReference<sht>> a;
  protected Map<String, shp> a;
  protected shj a;
  protected shl a;
  
  public shg()
  {
    this.jdField_a_of_type_Shl = new shl(this, null);
    this.jdField_a_of_type_Shj = new shj(this, null);
    this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  }
  
  private boolean b(shp paramshp)
  {
    if ((paramshp.d != null) && (paramshp.d.contains("qqstocdnd")))
    {
      String str = ((sgm)sqg.a(4)).a();
      urk.a("AsyncFileDownloader", "get url key:%s", str);
      if ((str == null) || (str.equals("00"))) {
        return false;
      }
      paramshp.d = befm.a(paramshp.d, "authkey", str);
    }
    return true;
  }
  
  public void a(List<WeakReference<sht>> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public boolean a()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      shp localshp = (shp)this.jdField_a_of_type_JavaUtilMap.remove(this.jdField_a_of_type_JavaLangString);
      if (localshp != null) {
        localshp.jdField_a_of_type_Sho.b(localshp);
      }
      return true;
    }
    return false;
  }
  
  public boolean a(shp paramshp)
  {
    paramshp = (shp)this.jdField_a_of_type_JavaUtilMap.remove(paramshp.jdField_a_of_type_JavaLangString);
    if (paramshp != null)
    {
      paramshp.jdField_a_of_type_Sho.b(paramshp);
      return true;
    }
    return false;
  }
  
  public boolean a(shp paramshp, shi paramshi)
  {
    if (paramshp == null)
    {
      urk.d("AsyncFileDownloader", "task is empty");
      return false;
    }
    if (TextUtils.isEmpty(paramshp.d))
    {
      if ((!vjw.a(paramshp.b)) || ((paramshp.jdField_a_of_type_Int != 2) && (paramshp.jdField_a_of_type_Int != 0))) {
        break label279;
      }
      QQStoryContext.a();
      localObject1 = vjw.a(QQStoryContext.a(), paramshp.b);
      if (!(localObject1 instanceof MessageForShortVideo)) {
        break label279;
      }
    }
    label279:
    for (Object localObject1 = (MessageForShortVideo)localObject1;; localObject1 = null)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null)
      {
        if (paramshi != null) {
          paramshi.a(paramshp, new ErrorMessage(14, "ERR_URL_EMPTY"));
        }
        return false;
        localObject2 = null;
      }
      if (!vlt.a(QQStoryContext.a().a()))
      {
        if (paramshi != null) {
          paramshi.a(paramshp, new ErrorMessage(9004, "no net work"));
        }
        return false;
      }
      if (!b(paramshp))
      {
        if (paramshi != null) {
          paramshi.a(paramshp, new ErrorMessage(200, "ERR_VERIFY_ERROR"));
        }
        return false;
      }
      paramshp.jdField_a_of_type_Shi = paramshi;
      paramshp.jdField_a_of_type_Long = System.currentTimeMillis();
      if (localObject2 != null) {
        paramshp.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = localObject2;
      }
      for (paramshp.jdField_a_of_type_Sho = this.jdField_a_of_type_Shj; !paramshp.jdField_a_of_type_Sho.a(); paramshp.jdField_a_of_type_Sho = this.jdField_a_of_type_Shl)
      {
        if (paramshi != null) {
          paramshi.a(paramshp, new ErrorMessage(15, "downloader not prepare"));
        }
        return false;
      }
      Bosses.get().postJob(new shh(this, "AsyncFileDownloader", paramshp));
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     shg
 * JD-Core Version:    0.7.0.1
 */