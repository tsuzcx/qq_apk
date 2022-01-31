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

public class tdo
  implements tck
{
  protected ssm<String, QQUserUIItem> a;
  private tkl a;
  
  public tdo()
  {
    this.jdField_a_of_type_Ssm = new ssm(300);
    this.jdField_a_of_type_Tkl = new tkl();
  }
  
  private QQStoryContext a()
  {
    return QQStoryContext.a();
  }
  
  protected static String a(String paramString)
  {
    return "k_" + paramString;
  }
  
  public static List<? extends aukm> a(aukn paramaukn, Class<? extends aukm> paramClass, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    return paramaukn.a(paramClass, paramString1, false, paramString2, paramArrayOfString, null, null, null, null, null);
  }
  
  public QQUserUIItem a()
  {
    return b(QQStoryContext.a().b());
  }
  
  public QQUserUIItem a(QQUserUIItem paramQQUserUIItem)
  {
    String str = paramQQUserUIItem.uid;
    b(str);
    paramQQUserUIItem = (QQUserUIItem)this.jdField_a_of_type_Ssm.a(a(str), paramQQUserUIItem);
    a().a().createEntityManager().b(paramQQUserUIItem.convert2UserEntry());
    return paramQQUserUIItem;
  }
  
  public QQUserUIItem a(@NonNull String paramString)
  {
    vxs.a(paramString);
    QQUserUIItem localQQUserUIItem = b(paramString);
    paramString = localQQUserUIItem;
    if (localQQUserUIItem == null)
    {
      paramString = new QQUserUIItem();
      paramString.uid = QQStoryContext.a().b();
      paramString.qq = tsu.a().getCurrentAccountUin();
      paramString.nickName = tsu.a().getCurrentNickname();
      paramString.headUrl = "";
      veg.d("Q.qqstory.user.UserManager", "create fake feed item while QQUserUIItem is null! use fake QQUserUIItem to instead.", new Object[] { paramString.toString() });
    }
    return paramString;
  }
  
  @Nullable
  public QQUserUIItem a(@NonNull String paramString, boolean paramBoolean)
  {
    String str = paramString;
    if ("0_1000".equals(paramString)) {
      str = (String)((tcv)tdc.a(10)).b("qqstory_my_union_id", paramString);
    }
    QQUserUIItem localQQUserUIItem = (QQUserUIItem)this.jdField_a_of_type_Ssm.a(a(str));
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
    veg.d("Q.qqstory.user.UserManager", "%s get userItem is null", new Object[] { str });
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
      veg.d("Q.qqstory.user.UserManager", "unionId %s cannot find uin ,%s", new Object[] { paramString, localObject });
      localObject = new tej("-9", paramString);
      a(1, (tej)localObject);
      if (paramBoolean) {
        break;
      }
      return "-9";
    }
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      veg.e("Q.qqstory.user.UserManager", "Cannot req on UI thread");
      return "-9";
    }
    try
    {
      localObject.wait(10000L);
      veg.d("Q.qqstory.user.UserManager", "%s wait end", new Object[] { paramString });
      return ((tej)localObject).a;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        veg.d("Q.qqstory.user.UserManager", "%s wait exception", new Object[] { paramString, localInterruptedException });
      }
    }
    finally {}
  }
  
  public void a() {}
  
  protected void a(int paramInt, tej paramtej)
  {
    if (paramInt == 1) {}
    for (Object localObject = "unionId";; localObject = "uin")
    {
      veg.d("Q.qqstory.user.UserManager", "start get user id: %s , convert from %s", new Object[] { paramtej, localObject });
      long l = System.currentTimeMillis();
      localObject = new tmc();
      ((tmc)localObject).c = paramInt;
      ((tmc)localObject).a.add(paramtej);
      boolean bool = paramtej.a();
      syr.a().a((syv)localObject, new tdp(this, paramtej, bool, l));
      return;
    }
  }
  
  public void a(@NonNull String paramString1, @NonNull String paramString2)
  {
    vxs.a(paramString1);
    vxs.a(paramString2);
    aukn localaukn = a().a().createEntityManager();
    UnionIdMapEntity localUnionIdMapEntity = new UnionIdMapEntity();
    localUnionIdMapEntity.unionId = paramString1;
    localUnionIdMapEntity.qq = paramString2;
    localaukn.b(localUnionIdMapEntity);
  }
  
  public void a(@NonNull String paramString, tkm paramtkm)
  {
    QQUserUIItem localQQUserUIItem = a(paramString, false);
    tkn localtkn = new tkn();
    if (localQQUserUIItem != null)
    {
      localtkn.a = localQQUserUIItem;
      paramtkm.a(localtkn);
      return;
    }
    ThreadManager.excute(new UserManager.1(this, paramString, localtkn, paramtkm), 32, null, true);
  }
  
  public boolean a(String paramString)
  {
    return aijb.a(QQStoryContext.a().getCurrentAccountUin() + paramString);
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
      veg.d("Q.qqstory.user.UserManager", "qq %s cannot find unionid ,%s", new Object[] { paramString, localObject });
      localObject = new tej(paramString, "");
      a(0, (tej)localObject);
      if (paramBoolean) {
        break;
      }
      return "";
    }
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      veg.e("Q.qqstory.user.UserManager", "Cannot req on UI thread");
      return "";
    }
    try
    {
      localObject.wait(10000L);
      veg.d("Q.qqstory.user.UserManager", "%s wait end", new Object[] { paramString });
      return ((tej)localObject).b;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        veg.d("Q.qqstory.user.UserManager", "%s wait exception", new Object[] { paramString, localInterruptedException });
      }
    }
    finally {}
  }
  
  public void b() {}
  
  public QQUserUIItem c(@NonNull String paramString)
  {
    QQUserUIItem localQQUserUIItem = b(paramString);
    if ((localQQUserUIItem == null) || (!localQQUserUIItem.isAvailable())) {
      this.jdField_a_of_type_Tkl.a(paramString);
    }
    return localQQUserUIItem;
  }
  
  public void c()
  {
    String str = QQStoryContext.a().b();
    if ((str.equals("0_1000")) || (a() == null))
    {
      veg.d("Q.qqstory.user.UserManager", "current union %s is default or userItem is null", new Object[] { str });
      a(1, new tej(QQStoryContext.a().a(), str));
    }
  }
  
  @Nullable
  protected QQUserUIItem d(String paramString)
  {
    Object localObject = a(a().a().createEntityManager(), UserEntry.class, UserEntry.class.getSimpleName(), UserEntry.getUserSelectionNoArg(), new String[] { paramString });
    if ((localObject == null) || (((List)localObject).size() == 0))
    {
      veg.a("Q.qqstory.user.UserManager", "%s cannot get userItem from db", paramString);
      return null;
    }
    paramString = (UserEntry)((List)localObject).get(0);
    localObject = new QQUserUIItem(paramString);
    return (QQUserUIItem)this.jdField_a_of_type_Ssm.a(a(paramString.unionId), (ssl)localObject);
  }
  
  public void d()
  {
    this.jdField_a_of_type_Ssm.a(0);
  }
  
  protected QQUserUIItem e(String paramString)
  {
    Object localObject = a(a().a().createEntityManager(), UserEntry.class, UserEntry.class.getSimpleName(), UserEntry.getUserSelectionByQQ(), new String[] { paramString });
    if ((localObject == null) || (((List)localObject).size() == 0))
    {
      veg.a("Q.qqstory.user.UserManager", "qq %s cannot get userItem from db", paramString);
      return null;
    }
    paramString = (UserEntry)((List)localObject).get(0);
    localObject = new QQUserUIItem(paramString);
    return (QQUserUIItem)this.jdField_a_of_type_Ssm.a(a(paramString.qq), (ssl)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tdo
 * JD-Core Version:    0.7.0.1
 */