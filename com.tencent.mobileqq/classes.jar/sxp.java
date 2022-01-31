import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.network.handler.GetUserInfoHandler.1;
import com.tribe.async.dispatch.Dispatcher;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public class sxp
  extends swk
  implements slx<szg, tbe>
{
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  public String a;
  public SoftReference<sxq> a;
  public List<srn> a;
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  public int b;
  private List<srn> b;
  
  public sxp()
  {
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
  }
  
  public sxp(int paramInt, List<srn> paramList)
  {
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public sxp(sxq paramsxq)
  {
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangRefSoftReference = new SoftReference(paramsxq);
  }
  
  public static void d()
  {
    sxp localsxp = new sxp();
    if (TextUtils.isEmpty(QQStoryContext.a().b()))
    {
      long l = QQStoryContext.a().a();
      localsxp.a(0, new srn(String.valueOf(l), ""), String.valueOf(l));
      return;
    }
    String str = QQStoryContext.a().b();
    localsxp.a(1, new srn("", str), str);
  }
  
  public void a()
  {
    szg localszg = new szg();
    localszg.jdField_c_of_type_Int = this.jdField_b_of_type_Int;
    localszg.jdField_a_of_type_JavaUtilList.addAll(this.jdField_a_of_type_JavaUtilList);
    slv.a().a(localszg, this);
  }
  
  public void a(int paramInt, List<srn> paramList)
  {
    if (paramInt == 1) {}
    for (Object localObject = "unionId";; localObject = "uin")
    {
      urk.d("Q.qqstory.user.GetUserInfoHandler", "start get user id: %s , convert from %s", new Object[] { paramList, localObject });
      localObject = new szg();
      ((szg)localObject).jdField_c_of_type_Int = paramInt;
      ((szg)localObject).jdField_a_of_type_JavaUtilList.addAll(paramList);
      slv.a().a((slz)localObject, this);
      return;
    }
  }
  
  public void a(int paramInt, srn paramsrn, String paramString)
  {
    a(paramInt, paramsrn, paramString, false, false);
  }
  
  public void a(int paramInt, srn paramsrn, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramInt == 1) {}
    for (Object localObject = "unionId";; localObject = "uin")
    {
      urk.d("Q.qqstory.user.GetUserInfoHandler", "start get user id: %s , convert from %s, needMetal:%s, needGradeSpeed:%s", new Object[] { paramsrn, localObject, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
      localObject = new szg();
      ((szg)localObject).jdField_a_of_type_JavaLangString = paramString;
      ((szg)localObject).jdField_c_of_type_Int = paramInt;
      ((szg)localObject).jdField_a_of_type_JavaUtilList.add(paramsrn);
      ((szg)localObject).jdField_c_of_type_Boolean = paramsrn.a();
      ((szg)localObject).jdField_a_of_type_Boolean = paramBoolean1;
      ((szg)localObject).b = paramBoolean2;
      slv.a().a((slz)localObject, this);
      return;
    }
  }
  
  public void a(@NonNull String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (!this.jdField_a_of_type_JavaUtilSet.contains(paramString))
      {
        this.jdField_b_of_type_JavaUtilList.add(new srn("", paramString));
        this.jdField_a_of_type_JavaUtilSet.add(paramString);
      }
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true)) {
        new Handler().postDelayed(new GetUserInfoHandler.1(this), 600L);
      }
      return;
    }
  }
  
  public void a(@NonNull szg paramszg, @Nullable tbe arg2, @NonNull ErrorMessage paramErrorMessage)
  {
    sxr localsxr = new sxr();
    localsxr.b = this.jdField_a_of_type_JavaLangString;
    if (paramErrorMessage.isSuccess())
    {
      Object localObject = ???.jdField_a_of_type_JavaUtilList;
      ??? = new ArrayList();
      sqs localsqs = (sqs)sqg.a(2);
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        QQUserUIItem localQQUserUIItem = (QQUserUIItem)((Iterator)localObject).next();
        if (TextUtils.isEmpty(localQQUserUIItem.nickName)) {
          localQQUserUIItem.nickName = "QQ用户";
        }
        ???.add(localsqs.a(localQQUserUIItem));
      }
      localsxr.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
      localsxr.jdField_a_of_type_JavaUtilList = ???;
      localsxr.jdField_a_of_type_JavaLangString = paramszg.jdField_a_of_type_JavaLangString;
      if (???.size() == 1)
      {
        ??? = (QQUserUIItem)???.get(0);
        localsxr.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem = ???;
        if (paramszg.jdField_c_of_type_Boolean)
        {
          ((spz)sqg.a(10)).b("qqstory_my_uin", ???.qq);
          QQStoryContext.a().a(???.uid);
        }
      }
      sgi.a().dispatch(localsxr);
      b();
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if ((paramszg.jdField_c_of_type_Int != 1) || (paramszg.jdField_a_of_type_JavaUtilList == null)) {
          break;
        }
        paramszg = paramszg.jdField_a_of_type_JavaUtilList.iterator();
        if (!paramszg.hasNext()) {
          break;
        }
        paramErrorMessage = ((srn)paramszg.next()).b;
        if (TextUtils.isEmpty(paramErrorMessage)) {
          continue;
        }
        this.jdField_a_of_type_JavaUtilSet.remove(paramErrorMessage);
      }
      urk.c("Q.qqstory.user.GetUserInfoHandler", "get server info fail , %s, time :%d", paramErrorMessage);
      localsxr.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
      localsxr.jdField_a_of_type_JavaLangString = paramszg.jdField_a_of_type_JavaLangString;
      sgi.a().dispatch(localsxr);
      c();
    }
    if ((this.jdField_a_of_type_JavaLangRefSoftReference != null) && (this.jdField_a_of_type_JavaLangRefSoftReference.get() != null)) {
      ((sxq)this.jdField_a_of_type_JavaLangRefSoftReference.get()).a(localsxr);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sxp
 * JD-Core Version:    0.7.0.1
 */