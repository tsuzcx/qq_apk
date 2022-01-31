import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.biz.pubaccount.readinjoy.skin.BaseResData;
import com.tencent.biz.pubaccount.readinjoy.skin.GuideData;
import com.tencent.biz.pubaccount.readinjoy.skin.ReadInJoySkinManager.13;
import com.tencent.biz.pubaccount.readinjoy.skin.RefreshData;
import com.tencent.biz.pubaccount.readinjoy.skin.SkinData;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class pnn
  extends pne
{
  protected int a;
  protected Handler a;
  protected SparseArray<pnb[]> a;
  protected String a;
  protected ArrayList<poa> b = new ArrayList();
  
  public pnn(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    a(3, new pnb[] { new pnb(), new pno(this) });
    a(2, new pnb[] { new pnb(), new pns(this) });
    a(4, new pnb[] { new pnt(this), new pnu(this, paramAppInterface) });
    a(5, new pnb[] { new pnv(this), new pnw(this, paramAppInterface) });
    a(6, new pnb[] { new pnx(this), new pny(this, paramAppInterface) });
    a(7, new pnb[] { new pnz(this), new pnp(this, paramAppInterface) });
    a(8, new pnb[] { new pnq(this), new pnr(this) });
  }
  
  public static String b()
  {
    return ajed.aU + ".readInjoy/skin_guide/";
  }
  
  public static String b(String paramString)
  {
    return b() + paramString;
  }
  
  private void b(int paramInt, String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    pnc.a(this.jdField_a_of_type_JavaLangString);
    paramInt = 0;
    while (paramInt < this.b.size())
    {
      ((poa)this.b.get(paramInt)).a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, paramBoolean);
      paramInt += 1;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public SkinData a(Context paramContext)
  {
    SkinData localSkinData = null;
    paramContext = baig.p(paramContext, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
    if (paramContext != null) {}
    for (;;)
    {
      try
      {
        paramContext = new JSONObject(paramContext);
        if (paramContext != null) {
          localSkinData = new SkinData(paramContext);
        }
        return localSkinData;
      }
      catch (Exception paramContext)
      {
        paramContext = null;
        continue;
      }
      paramContext = null;
    }
  }
  
  public ErrorMessage a(int paramInt, String paramString1, long paramLong1, String paramString2, String paramString3, long paramLong2, long paramLong3, boolean paramBoolean)
  {
    if ((!pnc.a(paramString1)) && (!TextUtils.isEmpty(paramString1)))
    {
      QLog.i("ReadInJoySkinManager", 1, "skin is not valid skinId:" + paramString1 + " skinName:" + paramString2);
      return new ErrorMessage(-2, "please download skin first");
    }
    if (!TextUtils.isEmpty(paramString1))
    {
      paramString2 = new SkinData(paramString1, paramString3, paramLong1, (int)paramLong2, (int)paramLong3);
      paramLong1 = System.currentTimeMillis() / 1000L;
      if (paramLong1 < paramLong2)
      {
        QLog.i("ReadInJoySkinManager", 1, "current:" + paramLong1 + " startTime:" + paramLong2);
        return new ErrorMessage(-1, "time error");
      }
      if (paramLong1 >= paramLong3)
      {
        QLog.i("ReadInJoySkinManager", 1, "current:" + paramLong1 + " endTime:" + paramLong3);
        return new ErrorMessage(-1, "the skin is expired");
      }
    }
    for (;;)
    {
      boolean bool = baig.u(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication().getBaseContext(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
      if ((this.jdField_a_of_type_JavaLangString.equals(paramString1)) && (paramBoolean == bool)) {
        return new ErrorMessage(-1, "your are already set the skin");
      }
      paramString3 = (pnh)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(270);
      Object localObject = paramString3.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication().getBaseContext(), 0);
      int i = (int)(System.currentTimeMillis() / 1000L);
      if ("".equals(paramString1))
      {
        if (localObject != null)
        {
          ((RefreshData)localObject).isShown = true;
          baig.f(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication().getBaseContext(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), ((RefreshData)localObject).toJson().toString(), 0);
          if ((i >= ((RefreshData)localObject).beginTime) && (i <= ((RefreshData)localObject).endTime))
          {
            paramString3.a(1, ((RefreshData)localObject).id, ((RefreshData)localObject).seq, 0);
            paramString3.a(true);
          }
        }
        baig.l(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication().getBaseContext(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), paramBoolean);
        paramString3 = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication().getBaseContext();
        localObject = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
        if (paramString2 == null) {
          break label512;
        }
      }
      label512:
      for (paramString2 = paramString2.toJson().toString();; paramString2 = null)
      {
        baig.r(paramString3, (String)localObject, paramString2);
        a(paramInt, paramString1, false);
        return new ErrorMessage();
        if (localObject == null) {
          break;
        }
        ((RefreshData)localObject).isShown = false;
        baig.f(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication().getBaseContext(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), ((RefreshData)localObject).toJson().toString(), 0);
        break;
      }
      paramString2 = null;
    }
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public String a(String paramString)
  {
    if ("skin".equals(paramString)) {
      return pnc.a();
    }
    if ("guide".equals(paramString)) {
      return b();
    }
    return b();
  }
  
  public pnb a(int paramInt)
  {
    pnb[] arrayOfpnb = (pnb[])this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if ((arrayOfpnb != null) && (this.jdField_a_of_type_Int < arrayOfpnb.length)) {
      return arrayOfpnb[this.jdField_a_of_type_Int];
    }
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public void a(int paramInt, String paramString, boolean paramBoolean)
  {
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      b(paramInt, paramString, paramBoolean);
      return;
    }
    ThreadManager.getUIHandler().post(new ReadInJoySkinManager.13(this, paramInt, paramString, paramBoolean));
  }
  
  public void a(int paramInt, pnb... paramVarArgs)
  {
    this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, paramVarArgs);
  }
  
  public void a(Context paramContext, String paramString, BaseResData paramBaseResData)
  {
    baig.g(paramContext, paramString, paramBaseResData.seq);
  }
  
  public void a(poa parampoa)
  {
    synchronized (this.b)
    {
      if (!this.b.contains(parampoa)) {
        this.b.add(parampoa);
      }
      return;
    }
  }
  
  public void a(String[] paramArrayOfString)
  {
    awqx.b(null, "dc00899", "BizTechReport", "", "skin_download", "skin_guide", 0, 0, paramArrayOfString[0], paramArrayOfString[1], paramArrayOfString[2], String.valueOf(badq.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication())));
  }
  
  public boolean a(GuideData paramGuideData)
  {
    return super.c("guide", paramGuideData);
  }
  
  public boolean a(SkinData paramSkinData)
  {
    return super.c("skin", paramSkinData);
  }
  
  public boolean a(String paramString)
  {
    paramString = (String)this.jdField_a_of_type_JavaUtilHashMap.remove("skin_" + paramString);
    if (paramString != null)
    {
      this.jdField_a_of_type_Batr.a(false, paramString);
      return true;
    }
    return false;
  }
  
  public boolean a(String paramString, BaseResData paramBaseResData)
  {
    return (a() != 1) || (!paramBaseResData.id.equals(a()));
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, long paramLong3, batl parambatl)
  {
    paramString1 = new SkinData(paramString1, paramString3, paramLong1, (int)paramLong2, (int)paramLong3);
    paramString2 = a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication().getBaseContext());
    if ((paramString2 != null) && (paramString2.id.equals(paramString1.id)) && (paramString2.seq != paramString1.seq) && (!this.jdField_a_of_type_JavaLangString.equals(paramString1.id))) {
      bace.a(pnc.a(paramString2.id));
    }
    a(parambatl);
    return super.a("skin", paramString1, 3);
  }
  
  public String b(String paramString1, String paramString2)
  {
    if ("skin".equals(paramString1)) {
      return pnc.a(paramString2);
    }
    if ("guide".equals(paramString1)) {
      return b(paramString2);
    }
    return b(paramString2);
  }
  
  public void b(String paramString, BaseResData paramBaseResData)
  {
    baig.s(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), paramBaseResData.id);
    baig.C(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
  }
  
  public void b(poa parampoa)
  {
    synchronized (this.b)
    {
      this.b.remove(parampoa);
      return;
    }
  }
  
  public boolean b(String paramString, BaseResData paramBaseResData)
  {
    paramString = b(paramString, paramBaseResData.id);
    long l1 = baig.h(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin()) / 86400000L;
    long l2 = System.currentTimeMillis() / 86400000L;
    return (axbo.a(new File(paramString))) && (pnc.a(paramBaseResData.id)) && (!baig.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), paramBaseResData.id)) && (l2 > l1);
  }
  
  public boolean c(String paramString, BaseResData paramBaseResData)
  {
    if ((paramBaseResData instanceof GuideData)) {
      return a((GuideData)paramBaseResData) & true & a(((GuideData)paramBaseResData).skinData);
    }
    return true;
  }
  
  public void onDestroy()
  {
    this.b.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     pnn
 * JD-Core Version:    0.7.0.1
 */