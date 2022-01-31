import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.UnionIdMapEntity;
import com.tencent.biz.qqstory.database.UserEntry;
import com.tencent.biz.qqstory.model.UserManager.1;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;

public class sqs
  implements spo
{
  protected sfq<String, QQUserUIItem> a;
  private sxp a;
  
  public sqs()
  {
    this.jdField_a_of_type_Sfq = new sfq(300);
    this.jdField_a_of_type_Sxp = new sxp();
  }
  
  private QQStoryContext a()
  {
    return QQStoryContext.a();
  }
  
  protected static String a(String paramString)
  {
    return "k_" + paramString;
  }
  
  public static List<? extends atmo> a(atmp paramatmp, Class<? extends atmo> paramClass, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    return paramatmp.a(paramClass, paramString1, false, paramString2, paramArrayOfString, null, null, null, null, null);
  }
  
  public QQUserUIItem a()
  {
    return b(QQStoryContext.a().b());
  }
  
  public QQUserUIItem a(QQUserUIItem paramQQUserUIItem)
  {
    String str = paramQQUserUIItem.uid;
    b(str);
    paramQQUserUIItem = (QQUserUIItem)this.jdField_a_of_type_Sfq.a(a(str), paramQQUserUIItem);
    a().a().createEntityManager().b(paramQQUserUIItem.convert2UserEntry());
    return paramQQUserUIItem;
  }
  
  public QQUserUIItem a(@NonNull String paramString)
  {
    vkw.a(paramString);
    QQUserUIItem localQQUserUIItem = b(paramString);
    paramString = localQQUserUIItem;
    if (localQQUserUIItem == null)
    {
      paramString = new QQUserUIItem();
      paramString.uid = QQStoryContext.a().b();
      paramString.qq = tfy.a().getCurrentAccountUin();
      paramString.nickName = tfy.a().getCurrentNickname();
      paramString.headUrl = "";
      urk.d("Q.qqstory.user.UserManager", "create fake feed item while QQUserUIItem is null! use fake QQUserUIItem to instead.", new Object[] { paramString.toString() });
    }
    return paramString;
  }
  
  @Nullable
  public QQUserUIItem a(@NonNull String paramString, boolean paramBoolean)
  {
    String str = paramString;
    if ("0_1000".equals(paramString)) {
      str = (String)((spz)sqg.a(10)).b("qqstory_my_union_id", paramString);
    }
    QQUserUIItem localQQUserUIItem = (QQUserUIItem)this.jdField_a_of_type_Sfq.a(a(str));
    paramString = localQQUserUIItem;
    if (localQQUserUIItem == null)
    {
      if (paramBoolean) {
        break label62;
      }
      paramString = localQQUserUIItem;
    }
    label62:
    do
    {
      return paramString;
      localQQUserUIItem = d(str);
      paramString = localQQUserUIItem;
    } while (localQQUserUIItem != null);
    urk.d("Q.qqstory.user.UserManager", "%s get userItem is null", new Object[] { str });
    return localQQUserUIItem;
  }
  
  public String a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "-9";
    }
    if (QQStoryContext.a().a(paramString)) {
      return QQStoryContext.a().a();
    }
    Object localObject = b(paramString);
    if ((localObject != null) && (!TextUtils.isEmpty(((QQUserUIItem)localObject).qq))) {
      return ((QQUserUIItem)localObject).qq;
    }
    localObject = a(a().a().createEntityManager(), UnionIdMapEntity.class, UnionIdMapEntity.class.getSimpleName(), UnionIdMapEntity.selectionUnionId(), new String[] { paramString });
    if ((localObject != null) && (((List)localObject).size() > 0)) {
      return ((UnionIdMapEntity)((List)localObject).get(0)).qq;
    }
    if (paramBoolean) {}
    for (localObject = "wait and ask from net";; localObject = "ret")
    {
      urk.d("Q.qqstory.user.UserManager", "unionId %s cannot find uin ,%s", new Object[] { paramString, localObject });
      localObject = new srn("-9", paramString);
      a(1, (srn)localObject);
      if (paramBoolean) {
        break;
      }
      return "-9";
    }
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      urk.e("Q.qqstory.user.UserManager", "Cannot req on UI thread");
      return "-9";
    }
    try
    {
      localObject.wait(10000L);
      urk.d("Q.qqstory.user.UserManager", "%s wait end", new Object[] { paramString });
      return ((srn)localObject).a;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        urk.d("Q.qqstory.user.UserManager", "%s wait exception", new Object[] { paramString, localInterruptedException });
      }
    }
    finally {}
  }
  
  public void a() {}
  
  protected void a(int paramInt, srn paramsrn)
  {
    if (paramInt == 1) {}
    for (Object localObject = "unionId";; localObject = "uin")
    {
      urk.d("Q.qqstory.user.UserManager", "start get user id: %s , convert from %s", new Object[] { paramsrn, localObject });
      long l = System.currentTimeMillis();
      localObject = new szg();
      ((szg)localObject).c = paramInt;
      ((szg)localObject).a.add(paramsrn);
      boolean bool = paramsrn.a();
      slv.a().a((slz)localObject, new sqt(this, paramsrn, bool, l));
      return;
    }
  }
  
  public void a(@NonNull String paramString1, @NonNull String paramString2)
  {
    vkw.a(paramString1);
    vkw.a(paramString2);
    atmp localatmp = a().a().createEntityManager();
    UnionIdMapEntity localUnionIdMapEntity = new UnionIdMapEntity();
    localUnionIdMapEntity.unionId = paramString1;
    localUnionIdMapEntity.qq = paramString2;
    localatmp.b(localUnionIdMapEntity);
  }
  
  public void a(@NonNull String paramString, sxq paramsxq)
  {
    QQUserUIItem localQQUserUIItem = a(paramString, false);
    sxr localsxr = new sxr();
    if (localQQUserUIItem != null)
    {
      localsxr.a = localQQUserUIItem;
      paramsxq.a(localsxr);
      return;
    }
    ThreadManager.excute(new UserManager.1(this, paramString, localsxr, paramsxq), 32, null, true);
  }
  
  public boolean a(String paramString)
  {
    return ahwj.a(QQStoryContext.a().getCurrentAccountUin() + paramString);
  }
  
  @Nullable
  public QQUserUIItem b(@NonNull String paramString)
  {
    return a(paramString, true);
  }
  
  public String b(String paramString, boolean paramBoolean)
  {
    Object localObject = e(paramString);
    if ((localObject != null) && (!TextUtils.isEmpty(((QQUserUIItem)localObject).uid))) {
      return ((QQUserUIItem)localObject).uid;
    }
    localObject = a(a().a().createEntityManager(), UnionIdMapEntity.class, UnionIdMapEntity.class.getSimpleName(), UnionIdMapEntity.selectionQQ(), new String[] { paramString });
    if ((localObject != null) && (((List)localObject).size() > 0)) {
      return ((UnionIdMapEntity)((List)localObject).get(0)).unionId;
    }
    if (paramBoolean) {}
    for (localObject = "wait and ask from net";; localObject = "ret")
    {
      urk.d("Q.qqstory.user.UserManager", "qq %s cannot find unionid ,%s", new Object[] { paramString, localObject });
      localObject = new srn(paramString, "");
      a(0, (srn)localObject);
      if (paramBoolean) {
        break;
      }
      return "";
    }
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      urk.e("Q.qqstory.user.UserManager", "Cannot req on UI thread");
      return "";
    }
    try
    {
      localObject.wait(10000L);
      urk.d("Q.qqstory.user.UserManager", "%s wait end", new Object[] { paramString });
      return ((srn)localObject).b;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        urk.d("Q.qqstory.user.UserManager", "%s wait exception", new Object[] { paramString, localInterruptedException });
      }
    }
    finally {}
  }
  
  public void b() {}
  
  public QQUserUIItem c(@NonNull String paramString)
  {
    QQUserUIItem localQQUserUIItem = b(paramString);
    if ((localQQUserUIItem == null) || (!localQQUserUIItem.isAvailable())) {
      this.jdField_a_of_type_Sxp.a(paramString);
    }
    return localQQUserUIItem;
  }
  
  public void c()
  {
    String str = QQStoryContext.a().b();
    if ((str.equals("0_1000")) || (a() == null))
    {
      urk.d("Q.qqstory.user.UserManager", "current union %s is default or userItem is null", new Object[] { str });
      a(1, new srn(QQStoryContext.a().a(), str));
    }
  }
  
  @Nullable
  protected QQUserUIItem d(String paramString)
  {
    Object localObject = a(a().a().createEntityManager(), UserEntry.class, UserEntry.class.getSimpleName(), UserEntry.getUserSelectionNoArg(), new String[] { paramString });
    if ((localObject == null) || (((List)localObject).size() == 0))
    {
      urk.a("Q.qqstory.user.UserManager", "%s cannot get userItem from db", paramString);
      return null;
    }
    paramString = (UserEntry)((List)localObject).get(0);
    localObject = new QQUserUIItem(paramString);
    return (QQUserUIItem)this.jdField_a_of_type_Sfq.a(a(paramString.unionId), (sfp)localObject);
  }
  
  public void d()
  {
    this.jdField_a_of_type_Sfq.a(0);
  }
  
  protected QQUserUIItem e(String paramString)
  {
    Object localObject = a(a().a().createEntityManager(), UserEntry.class, UserEntry.class.getSimpleName(), UserEntry.getUserSelectionByQQ(), new String[] { paramString });
    if ((localObject == null) || (((List)localObject).size() == 0))
    {
      urk.a("Q.qqstory.user.UserManager", "qq %s cannot get userItem from db", paramString);
      return null;
    }
    paramString = (UserEntry)((List)localObject).get(0);
    localObject = new QQUserUIItem(paramString);
    return (QQUserUIItem)this.jdField_a_of_type_Sfq.a(a(paramString.qq), (sfp)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sqs
 * JD-Core Version:    0.7.0.1
 */