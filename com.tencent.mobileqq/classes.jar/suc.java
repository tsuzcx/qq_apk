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

public class suc
{
  protected String a;
  public List<WeakReference<sup>> a;
  protected Map<String, sul> a;
  protected suf a;
  protected suh a;
  
  public suc()
  {
    this.jdField_a_of_type_Suh = new suh(this, null);
    this.jdField_a_of_type_Suf = new suf(this, null);
    this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  }
  
  private boolean b(sul paramsul)
  {
    if ((paramsul.d != null) && (paramsul.d.contains("qqstocdnd")))
    {
      String str = ((sti)tdc.a(4)).a();
      veg.a("AsyncFileDownloader", "get url key:%s", str);
      if ((str == null) || (str.equals("00"))) {
        return false;
      }
      paramsul.d = bfng.a(paramsul.d, "authkey", str);
    }
    return true;
  }
  
  public void a(List<WeakReference<sup>> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public boolean a()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      sul localsul = (sul)this.jdField_a_of_type_JavaUtilMap.remove(this.jdField_a_of_type_JavaLangString);
      if (localsul != null) {
        localsul.jdField_a_of_type_Suk.b(localsul);
      }
      return true;
    }
    return false;
  }
  
  public boolean a(sul paramsul)
  {
    paramsul = (sul)this.jdField_a_of_type_JavaUtilMap.remove(paramsul.jdField_a_of_type_JavaLangString);
    if (paramsul != null)
    {
      paramsul.jdField_a_of_type_Suk.b(paramsul);
      return true;
    }
    return false;
  }
  
  public boolean a(sul paramsul, sue paramsue)
  {
    if (paramsul == null)
    {
      veg.d("AsyncFileDownloader", "task is empty");
      return false;
    }
    if (TextUtils.isEmpty(paramsul.d))
    {
      if ((!vws.a(paramsul.b)) || ((paramsul.jdField_a_of_type_Int != 2) && (paramsul.jdField_a_of_type_Int != 0))) {
        break label279;
      }
      QQStoryContext.a();
      localObject1 = vws.a(QQStoryContext.a(), paramsul.b);
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
        if (paramsue != null) {
          paramsue.a(paramsul, new ErrorMessage(14, "ERR_URL_EMPTY"));
        }
        return false;
        localObject2 = null;
      }
      if (!vyp.a(QQStoryContext.a().a()))
      {
        if (paramsue != null) {
          paramsue.a(paramsul, new ErrorMessage(9004, "no net work"));
        }
        return false;
      }
      if (!b(paramsul))
      {
        if (paramsue != null) {
          paramsue.a(paramsul, new ErrorMessage(200, "ERR_VERIFY_ERROR"));
        }
        return false;
      }
      paramsul.jdField_a_of_type_Sue = paramsue;
      paramsul.jdField_a_of_type_Long = System.currentTimeMillis();
      if (localObject2 != null) {
        paramsul.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = localObject2;
      }
      for (paramsul.jdField_a_of_type_Suk = this.jdField_a_of_type_Suf; !paramsul.jdField_a_of_type_Suk.a(); paramsul.jdField_a_of_type_Suk = this.jdField_a_of_type_Suh)
      {
        if (paramsue != null) {
          paramsue.a(paramsul, new ErrorMessage(15, "downloader not prepare"));
        }
        return false;
      }
      Bosses.get().postJob(new sud(this, "AsyncFileDownloader", paramsul));
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     suc
 * JD-Core Version:    0.7.0.1
 */