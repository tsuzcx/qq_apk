import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import com.tencent.biz.pubaccount.readinjoy.skin.BaseResData;
import com.tencent.biz.pubaccount.readinjoy.skin.GuideData;
import com.tencent.biz.pubaccount.readinjoy.skin.SkinData;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.MobileQQ;
import org.json.JSONObject;

public class rau
  extends ral
{
  protected int a;
  protected Handler a;
  protected SparseArray<rai[]> a;
  protected String a;
  protected ArrayList<rbh> b = new ArrayList();
  
  public rau(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    a(3, new rai[] { new rai(), new rav(this) });
    a(2, new rai[] { new rai(), new raz(this) });
    a(4, new rai[] { new rba(this), new rbb(this, paramAppInterface) });
    a(5, new rai[] { new rbc(this), new rbd(this, paramAppInterface) });
    a(6, new rai[] { new rbe(this), new rbf(this, paramAppInterface) });
    a(7, new rai[] { new rbg(this), new raw(this, paramAppInterface) });
    a(8, new rai[] { new rax(this), new ray(this) });
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public SkinData a(Context paramContext)
  {
    SkinData localSkinData = null;
    paramContext = bfyz.q(paramContext, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
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
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public String a(String paramString)
  {
    if ("skin".equals(paramString)) {
      return raj.a();
    }
    if ("guide".equals(paramString)) {
      return raj.c();
    }
    return raj.c();
  }
  
  public String a(String paramString1, String paramString2)
  {
    if ("skin".equals(paramString1)) {
      return raj.a(paramString2);
    }
    if ("guide".equals(paramString1)) {
      return raj.b(paramString2);
    }
    return raj.b(paramString2);
  }
  
  public rai a(int paramInt)
  {
    rai[] arrayOfrai = (rai[])this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if ((arrayOfrai != null) && (this.jdField_a_of_type_Int < arrayOfrai.length)) {
      return arrayOfrai[this.jdField_a_of_type_Int];
    }
    return null;
  }
  
  public void a(int paramInt, rai... paramVarArgs)
  {
    this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, paramVarArgs);
  }
  
  public void a(Context paramContext, String paramString, BaseResData paramBaseResData)
  {
    bfyz.g(paramContext, paramString, paramBaseResData.seq);
  }
  
  public void a(rbh paramrbh)
  {
    synchronized (this.b)
    {
      if (!this.b.contains(paramrbh)) {
        this.b.add(paramrbh);
      }
      return;
    }
  }
  
  public void a(String[] paramArrayOfString)
  {
    bcef.b(null, "dc00899", "BizTechReport", "", "skin_download", "skin_guide", 0, 0, paramArrayOfString[0], paramArrayOfString[1], paramArrayOfString[2], String.valueOf(NetworkUtil.getSystemNetwork(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication())));
  }
  
  public boolean a(GuideData paramGuideData)
  {
    return super.a("guide", paramGuideData);
  }
  
  public boolean a(SkinData paramSkinData)
  {
    return super.a("skin", paramSkinData);
  }
  
  public boolean a(String paramString)
  {
    paramString = (String)this.jdField_a_of_type_JavaUtilHashMap.remove("skin_" + paramString);
    if (paramString != null)
    {
      this.jdField_a_of_type_Bgoj.a(false, paramString);
      return true;
    }
    return false;
  }
  
  public boolean a(String paramString, BaseResData paramBaseResData)
  {
    if ((paramBaseResData instanceof GuideData)) {
      return a((GuideData)paramBaseResData) & true & a(((GuideData)paramBaseResData).skinData);
    }
    return true;
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, long paramLong3, bgod parambgod)
  {
    paramString1 = new SkinData(paramString1, paramString3, paramLong1, (int)paramLong2, (int)paramLong3);
    paramString2 = a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication().getBaseContext());
    if ((paramString2 != null) && (paramString2.id.equals(paramString1.id)) && (paramString2.seq != paramString1.seq) && (!this.jdField_a_of_type_JavaLangString.equals(paramString1.id))) {
      FileUtils.deleteDirectory(raj.a(paramString2.id));
    }
    a(parambgod);
    return super.a("skin", paramString1, 3);
  }
  
  public void b()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public void b(String paramString, BaseResData paramBaseResData)
  {
    bfyz.t(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), paramBaseResData.id);
    bfyz.B(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
  }
  
  public void b(rbh paramrbh)
  {
    synchronized (this.b)
    {
      this.b.remove(paramrbh);
      return;
    }
  }
  
  public boolean b(String paramString, BaseResData paramBaseResData)
  {
    return (a() != 1) || (!paramBaseResData.id.equals(a()));
  }
  
  public boolean c(String paramString, BaseResData paramBaseResData)
  {
    paramString = a(paramString, paramBaseResData.id);
    long l1 = bfyz.h(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin()) / 86400000L;
    long l2 = System.currentTimeMillis() / 86400000L;
    return (bcro.a(new File(paramString))) && (raj.a(paramBaseResData.id)) && (!bfyz.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), paramBaseResData.id)) && (l2 > l1);
  }
  
  public void onDestroy()
  {
    this.b.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rau
 * JD-Core Version:    0.7.0.1
 */