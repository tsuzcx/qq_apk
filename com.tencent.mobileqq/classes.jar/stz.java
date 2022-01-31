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

public class stz
{
  protected String a;
  public List<WeakReference<sum>> a;
  protected Map<String, sui> a;
  protected suc a;
  protected sue a;
  
  public stz()
  {
    this.jdField_a_of_type_Sue = new sue(this, null);
    this.jdField_a_of_type_Suc = new suc(this, null);
    this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  }
  
  private boolean b(sui paramsui)
  {
    if ((paramsui.d != null) && (paramsui.d.contains("qqstocdnd")))
    {
      String str = ((stf)tcz.a(4)).a();
      ved.a("AsyncFileDownloader", "get url key:%s", str);
      if ((str == null) || (str.equals("00"))) {
        return false;
      }
      paramsui.d = bfnx.a(paramsui.d, "authkey", str);
    }
    return true;
  }
  
  public void a(List<WeakReference<sum>> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public boolean a()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      sui localsui = (sui)this.jdField_a_of_type_JavaUtilMap.remove(this.jdField_a_of_type_JavaLangString);
      if (localsui != null) {
        localsui.jdField_a_of_type_Suh.b(localsui);
      }
      return true;
    }
    return false;
  }
  
  public boolean a(sui paramsui)
  {
    paramsui = (sui)this.jdField_a_of_type_JavaUtilMap.remove(paramsui.jdField_a_of_type_JavaLangString);
    if (paramsui != null)
    {
      paramsui.jdField_a_of_type_Suh.b(paramsui);
      return true;
    }
    return false;
  }
  
  public boolean a(sui paramsui, sub paramsub)
  {
    if (paramsui == null)
    {
      ved.d("AsyncFileDownloader", "task is empty");
      return false;
    }
    if (TextUtils.isEmpty(paramsui.d))
    {
      if ((!vwp.a(paramsui.b)) || ((paramsui.jdField_a_of_type_Int != 2) && (paramsui.jdField_a_of_type_Int != 0))) {
        break label279;
      }
      QQStoryContext.a();
      localObject1 = vwp.a(QQStoryContext.a(), paramsui.b);
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
        if (paramsub != null) {
          paramsub.a(paramsui, new ErrorMessage(14, "ERR_URL_EMPTY"));
        }
        return false;
        localObject2 = null;
      }
      if (!vym.a(QQStoryContext.a().a()))
      {
        if (paramsub != null) {
          paramsub.a(paramsui, new ErrorMessage(9004, "no net work"));
        }
        return false;
      }
      if (!b(paramsui))
      {
        if (paramsub != null) {
          paramsub.a(paramsui, new ErrorMessage(200, "ERR_VERIFY_ERROR"));
        }
        return false;
      }
      paramsui.jdField_a_of_type_Sub = paramsub;
      paramsui.jdField_a_of_type_Long = System.currentTimeMillis();
      if (localObject2 != null) {
        paramsui.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = localObject2;
      }
      for (paramsui.jdField_a_of_type_Suh = this.jdField_a_of_type_Suc; !paramsui.jdField_a_of_type_Suh.a(); paramsui.jdField_a_of_type_Suh = this.jdField_a_of_type_Sue)
      {
        if (paramsub != null) {
          paramsub.a(paramsui, new ErrorMessage(15, "downloader not prepare"));
        }
        return false;
      }
      Bosses.get().postJob(new sua(this, "AsyncFileDownloader", paramsui));
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     stz
 * JD-Core Version:    0.7.0.1
 */