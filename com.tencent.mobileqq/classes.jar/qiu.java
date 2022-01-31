import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.tencent.biz.pubaccount.readinjoy.skin.ReadInJoyRefreshManager.1;
import com.tencent.biz.pubaccount.readinjoy.skin.RefreshData;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class qiu
  implements Manager
{
  public static volatile boolean b;
  protected int a;
  protected long a;
  protected beaj a;
  protected AppInterface a;
  protected String a;
  protected ArrayList<qiw> a;
  protected HashMap<String, String> a;
  protected boolean a;
  protected int b;
  private int c = -1;
  
  static
  {
    jdField_b_of_type_Boolean = true;
  }
  
  public qiu(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Long = -1L;
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_Beaj = ((beag)paramAppInterface.getManager(47)).a(1);
  }
  
  public static RefreshData b(Context paramContext, int paramInt)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (qiu)((AppRuntime)localObject).getManager(270);
      if (localObject != null) {
        return ((qiu)localObject).a(paramContext, paramInt);
      }
    }
    return null;
  }
  
  private void b(int paramInt1, String paramString, long paramLong, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_b_of_type_Int = paramInt2;
    qjs.a(this.jdField_a_of_type_JavaLangString, paramLong);
    paramInt1 = 0;
    while (paramInt1 < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ((qiw)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt1)).a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long);
      paramInt1 += 1;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public RefreshData a(Context paramContext, int paramInt)
  {
    RefreshData localRefreshData = null;
    paramContext = bdne.a(paramContext, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), paramInt);
    if (paramContext != null) {}
    for (;;)
    {
      try
      {
        paramContext = new JSONObject(paramContext);
        if (paramContext != null) {
          localRefreshData = new RefreshData(paramContext);
        }
        return localRefreshData;
      }
      catch (Exception paramContext)
      {
        paramContext = null;
        continue;
      }
      paramContext = null;
    }
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = -1;
  }
  
  public void a(int paramInt1, String paramString, long paramLong, int paramInt2)
  {
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      b(paramInt1, paramString, paramLong, paramInt2);
      return;
    }
    ThreadManager.getUIHandler().post(new ReadInJoyRefreshManager.1(this, paramInt1, paramString, paramLong, paramInt2));
  }
  
  public void a(qiw paramqiw)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramqiw)) {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramqiw);
      }
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return (a() == 1) && (qjs.b() == 1);
  }
  
  public boolean a(RefreshData paramRefreshData, int paramInt)
  {
    return a(paramRefreshData, 0, paramInt);
  }
  
  public boolean a(RefreshData paramRefreshData, int paramInt1, int paramInt2)
  {
    Object localObject = paramRefreshData.id;
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyRefreshManager", 2, "downloadRefreshRes start id = " + (String)localObject);
    }
    String str = qjs.a((String)localObject);
    if (qjs.a((String)localObject)) {
      return true;
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.get("refresh_" + (String)localObject) != null) {
      return false;
    }
    bdhb.a(str);
    this.jdField_a_of_type_JavaUtilHashMap.put("refresh_" + (String)localObject, paramRefreshData.url);
    str = str + ".zip";
    File localFile = new File(str);
    Bundle localBundle = new Bundle();
    localBundle.putString("refreshId", (String)localObject);
    localObject = new beae(paramRefreshData.url, localFile);
    ((beae)localObject).jdField_b_of_type_Int = paramInt1;
    ((beae)localObject).d = 60L;
    ((beae)localObject).m = true;
    this.jdField_a_of_type_Beaj.a((beae)localObject, new qiv(this, str, paramRefreshData, paramInt2), localBundle);
    return false;
  }
  
  public void b(qiw paramqiw)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      this.jdField_a_of_type_JavaUtilArrayList.remove(paramqiw);
      return;
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_Int = -1;
    jdField_b_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qiu
 * JD-Core Version:    0.7.0.1
 */