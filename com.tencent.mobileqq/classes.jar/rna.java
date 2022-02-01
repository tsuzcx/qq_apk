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

public class rna
  extends rmr
{
  protected int a;
  protected Handler a;
  protected SparseArray<rmo[]> a;
  protected String a;
  protected ArrayList<rnn> b = new ArrayList();
  
  public rna(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    a(3, new rmo[] { new rmo(), new rnb(this) });
    a(2, new rmo[] { new rmo(), new rnf(this) });
    a(4, new rmo[] { new rng(this), new rnh(this, paramAppInterface) });
    a(5, new rmo[] { new rni(this), new rnj(this, paramAppInterface) });
    a(6, new rmo[] { new rnk(this), new rnl(this, paramAppInterface) });
    a(7, new rmo[] { new rnm(this), new rnc(this, paramAppInterface) });
    a(8, new rmo[] { new rnd(this), new rne(this) });
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public SkinData a(Context paramContext)
  {
    SkinData localSkinData = null;
    paramContext = bhhr.q(paramContext, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
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
      return rmp.a();
    }
    if ("guide".equals(paramString)) {
      return rmp.c();
    }
    return rmp.c();
  }
  
  public String a(String paramString1, String paramString2)
  {
    if ("skin".equals(paramString1)) {
      return rmp.a(paramString2);
    }
    if ("guide".equals(paramString1)) {
      return rmp.b(paramString2);
    }
    return rmp.b(paramString2);
  }
  
  public rmo a(int paramInt)
  {
    rmo[] arrayOfrmo = (rmo[])this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if ((arrayOfrmo != null) && (this.jdField_a_of_type_Int < arrayOfrmo.length)) {
      return arrayOfrmo[this.jdField_a_of_type_Int];
    }
    return null;
  }
  
  public void a(int paramInt, rmo... paramVarArgs)
  {
    this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, paramVarArgs);
  }
  
  public void a(Context paramContext, String paramString, BaseResData paramBaseResData)
  {
    bhhr.g(paramContext, paramString, paramBaseResData.seq);
  }
  
  public void a(rnn paramrnn)
  {
    synchronized (this.b)
    {
      if (!this.b.contains(paramrnn)) {
        this.b.add(paramrnn);
      }
      return;
    }
  }
  
  public void a(String[] paramArrayOfString)
  {
    bdla.b(null, "dc00899", "BizTechReport", "", "skin_download", "skin_guide", 0, 0, paramArrayOfString[0], paramArrayOfString[1], paramArrayOfString[2], String.valueOf(NetworkUtil.getSystemNetwork(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication())));
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
      this.jdField_a_of_type_Bhyt.a(false, paramString);
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
  
  public boolean a(String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, long paramLong3, bhyn parambhyn)
  {
    paramString1 = new SkinData(paramString1, paramString3, paramLong1, (int)paramLong2, (int)paramLong3);
    paramString2 = a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication().getBaseContext());
    if ((paramString2 != null) && (paramString2.id.equals(paramString1.id)) && (paramString2.seq != paramString1.seq) && (!this.jdField_a_of_type_JavaLangString.equals(paramString1.id))) {
      FileUtils.deleteDirectory(rmp.a(paramString2.id));
    }
    a(parambhyn);
    return super.a("skin", paramString1, 3);
  }
  
  public void b()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public void b(String paramString, BaseResData paramBaseResData)
  {
    bhhr.t(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), paramBaseResData.id);
    bhhr.B(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
  }
  
  public void b(rnn paramrnn)
  {
    synchronized (this.b)
    {
      this.b.remove(paramrnn);
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
    long l1 = bhhr.h(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin()) / 86400000L;
    long l2 = System.currentTimeMillis() / 86400000L;
    return (bdyn.a(new File(paramString))) && (rmp.a(paramBaseResData.id)) && (!bhhr.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), paramBaseResData.id)) && (l2 > l1);
  }
  
  public void onDestroy()
  {
    this.b.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rna
 * JD-Core Version:    0.7.0.1
 */