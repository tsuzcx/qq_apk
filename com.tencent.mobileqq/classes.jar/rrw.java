import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.mobileqq.app.QQAppInterface;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class rrw
  implements axrt
{
  private axrr jdField_a_of_type_Axrr;
  axvs jdField_a_of_type_Axvs = new rrx(this);
  TroopMemberApiService jdField_a_of_type_ComTencentBizTroopTroopMemberApiService;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<axvt> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  HashMap<Long, Bundle> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private ArrayList<axro> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  HashMap<Long, Bundle> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  private ArrayList<axvt> jdField_c_of_type_JavaUtilArrayList = new ArrayList();
  HashMap<String, Bundle> jdField_c_of_type_JavaUtilHashMap = new HashMap();
  
  public rrw(TroopMemberApiService paramTroopMemberApiService, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService = paramTroopMemberApiService;
    this.jdField_a_of_type_Axrr = paramQQAppInterface.getNetEngine(0);
  }
  
  private void a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      axro localaxro = (axro)localIterator.next();
      if (localaxro.jdField_a_of_type_JavaLangString.equals(paramString)) {
        localArrayList.add(localaxro);
      }
    }
    this.jdField_b_of_type_JavaUtilArrayList.removeAll(localArrayList);
  }
  
  public void a()
  {
    Object localObject2;
    if (this.jdField_a_of_type_Axrr != null)
    {
      localObject1 = this.jdField_b_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (axro)((Iterator)localObject1).next();
        this.jdField_a_of_type_Axrr.b((axsp)localObject2);
      }
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (localObject1 != null)
    {
      localObject2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      axvt localaxvt;
      while (((Iterator)localObject2).hasNext())
      {
        localaxvt = (axvt)((Iterator)localObject2).next();
        ((axvo)localObject1).a(localaxvt.jdField_c_of_type_JavaLangString, localaxvt.jdField_a_of_type_Long);
      }
      localObject2 = this.jdField_c_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localaxvt = (axvt)((Iterator)localObject2).next();
        ((axvo)localObject1).b(localaxvt.jdField_c_of_type_JavaLangString, localaxvt.jdField_a_of_type_Long);
      }
    }
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.jdField_b_of_type_JavaUtilHashMap.clear();
    this.jdField_c_of_type_JavaUtilHashMap.clear();
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_b_of_type_JavaUtilArrayList.clear();
  }
  
  void a(long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      axvt localaxvt = (axvt)localIterator.next();
      if (localaxvt.jdField_a_of_type_Long == paramLong) {
        localArrayList.add(localaxvt);
      }
    }
    this.jdField_a_of_type_JavaUtilArrayList.removeAll(localArrayList);
  }
  
  public void a(Bundle paramBundle)
  {
    if (mpl.a() == 0)
    {
      paramBundle.putLong("uniseq", 0L);
      paramBundle.putString("pic_server_id", "-1");
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(24, paramBundle);
      return;
    }
    String str = paramBundle.getString("pic_local_path");
    this.jdField_a_of_type_JavaLangString = paramBundle.getString("pic_puin");
    axvo localaxvo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    this.jdField_a_of_type_Axvs.addFilter(new Class[] { axom.class });
    localaxvo.a(this.jdField_a_of_type_Axvs);
    axvt localaxvt = new axvt();
    localaxvt.jdField_a_of_type_Boolean = true;
    localaxvt.jdField_c_of_type_Int = 10;
    localaxvt.i = str;
    localaxvt.jdField_a_of_type_Long = ((Math.random() * 1000000.0D));
    localaxvt.jdField_c_of_type_JavaLangString = "0";
    localaxvt.jdField_b_of_type_Int = 24;
    localaxvt.jdField_a_of_type_JavaLangString = "PAJSSDKPicUploadProcess";
    localaxvo.a(localaxvt);
    this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(localaxvt.jdField_a_of_type_Long), paramBundle);
    this.jdField_b_of_type_JavaUtilHashMap.put(Long.valueOf(localaxvt.jdField_a_of_type_Long), paramBundle);
    this.jdField_a_of_type_JavaUtilArrayList.add(localaxvt);
  }
  
  void b(long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_c_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      axvt localaxvt = (axvt)localIterator.next();
      if (localaxvt.jdField_a_of_type_Long == paramLong) {
        localArrayList.add(localaxvt);
      }
    }
    this.jdField_c_of_type_JavaUtilArrayList.removeAll(localArrayList);
  }
  
  public void b(Bundle paramBundle)
  {
    int k = 0;
    if (mpl.a() == 0)
    {
      paramBundle.putString("pic_local_id", "-1");
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(26, paramBundle);
    }
    do
    {
      return;
      String str = paramBundle.getString("pic_server_id");
      paramBundle.putInt("seq", paramBundle.getInt("seq", -1));
      axro localaxro = new axro();
      localaxro.jdField_a_of_type_Axrt = this;
      localaxro.jdField_a_of_type_JavaLangString = str;
      localaxro.jdField_c_of_type_Long = 180000L;
      if (localaxro.jdField_a_of_type_JavaLangString == null) {
        break;
      }
      Object localObject1 = localaxro.jdField_a_of_type_JavaLangString.split("/");
      if (localObject1.length < 2) {
        break;
      }
      localObject1 = localObject1[(localObject1.length - 2)];
      localaxro.jdField_c_of_type_JavaLangString = (ajed.aU + "c2bPIC/" + (String)localObject1 + ".png");
      Object localObject2 = new File(ajed.aU + "c2bPIC/");
      ArrayList localArrayList = new ArrayList();
      localObject2 = ((File)localObject2).listFiles();
      if (localObject2 != null)
      {
        int i = 0;
        int j;
        while (i < localObject2.length)
        {
          if (!localObject2[i].isDirectory())
          {
            j = localObject2[i].getName().lastIndexOf(".");
            if (j != -1) {
              localArrayList.add(localObject2[i].getName().substring(0, j));
            }
          }
          i += 1;
        }
        i = 0;
        for (;;)
        {
          j = k;
          if (i < localArrayList.size())
          {
            if (((String)localObject1).equalsIgnoreCase((String)localArrayList.get(i))) {
              j = 1;
            }
          }
          else
          {
            if (j == 0) {
              break;
            }
            paramBundle.putString("pic_local_id", (String)localObject1);
            this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(26, paramBundle);
            return;
          }
          i += 1;
        }
      }
      if (this.jdField_a_of_type_Axrr == null) {
        break;
      }
      this.jdField_a_of_type_Axrr.a(localaxro);
      this.jdField_c_of_type_JavaUtilHashMap.put(str, paramBundle);
      this.jdField_b_of_type_JavaUtilArrayList.add(localaxro);
    } while (paramBundle.getInt("is_showProgress_tips") != 1);
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(25, paramBundle);
    return;
    paramBundle.putString("pic_local_id", "-1");
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(26, paramBundle);
  }
  
  public void c(Bundle paramBundle)
  {
    String str = paramBundle.getString("pic_local_path");
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    this.jdField_a_of_type_Axvs.addFilter(new Class[] { axrw.class });
    ((axvo)localObject).a(this.jdField_a_of_type_Axvs);
    localObject = new axvt();
    ((axvt)localObject).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    ((axvt)localObject).jdField_c_of_type_JavaLangString = "255";
    ((axvt)localObject).jdField_a_of_type_Int = 9999;
    ((axvt)localObject).jdField_b_of_type_Int = 32;
    ((axvt)localObject).jdField_a_of_type_Long = ((Math.random() * 1000000.0D));
    ((axvt)localObject).jdField_a_of_type_Boolean = true;
    ((axvt)localObject).i = str;
    ((axvt)localObject).jdField_e_of_type_Int = 102;
    ((axvt)localObject).l = true;
    ((axvt)localObject).n = 2;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((axvt)localObject);
    this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(((axvt)localObject).jdField_a_of_type_Long), paramBundle);
    this.jdField_b_of_type_JavaUtilHashMap.put(Long.valueOf(((axvt)localObject).jdField_a_of_type_Long), paramBundle);
    this.jdField_c_of_type_JavaUtilArrayList.add(localObject);
  }
  
  public void d(Bundle paramBundle)
  {
    String str = paramBundle.getString("pic_server_id");
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    this.jdField_a_of_type_Axvs.addFilter(new Class[] { axrv.class });
    ((axvo)localObject).a(this.jdField_a_of_type_Axvs);
    localObject = new axvt();
    ((axvt)localObject).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    ((axvt)localObject).jdField_c_of_type_JavaLangString = "255";
    ((axvt)localObject).jdField_a_of_type_Int = 9999;
    ((axvt)localObject).jdField_b_of_type_Int = 32;
    ((axvt)localObject).jdField_a_of_type_Long = ((Math.random() * 1000.0D));
    ((axvt)localObject).jdField_a_of_type_Boolean = false;
    ((axvt)localObject).jdField_e_of_type_JavaLangString = str;
    ((axvt)localObject).h = (ajed.aU + "c2bPTT/" + str + ".amr");
    if (new File(((axvt)localObject).h).exists())
    {
      paramBundle.putString("pic_local_id", new rss().a(((axvt)localObject).h));
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(26, paramBundle);
      return;
    }
    ((axvt)localObject).jdField_b_of_type_Boolean = true;
    ((axvt)localObject).d = 5;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((axvt)localObject);
    this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(((axvt)localObject).jdField_a_of_type_Long), paramBundle);
    this.jdField_b_of_type_JavaUtilHashMap.put(Long.valueOf(((axvt)localObject).jdField_a_of_type_Long), paramBundle);
    this.jdField_c_of_type_JavaUtilArrayList.add(localObject);
  }
  
  public void onResp(axsq paramaxsq)
  {
    Object localObject;
    Bundle localBundle;
    if ((paramaxsq != null) && ((paramaxsq.jdField_a_of_type_Axsp instanceof axro)))
    {
      localObject = (axro)paramaxsq.jdField_a_of_type_Axsp;
      if ((paramaxsq.jdField_a_of_type_Int == 0) || (paramaxsq.jdField_a_of_type_Int == 1))
      {
        localBundle = (Bundle)this.jdField_c_of_type_JavaUtilHashMap.remove(((axro)localObject).jdField_a_of_type_JavaLangString);
        a(((axro)localObject).jdField_a_of_type_JavaLangString);
        if (localBundle != null)
        {
          if ((((axro)localObject).jdField_a_of_type_JavaLangString == null) || (paramaxsq.jdField_a_of_type_Int != 0)) {
            break label293;
          }
          paramaxsq = ((axro)localObject).jdField_a_of_type_JavaLangString.split("/");
          if (paramaxsq.length < 2) {
            break label293;
          }
          localBundle.putString("pic_local_id", paramaxsq[(paramaxsq.length - 2)]);
          localObject = ((axro)localObject).jdField_c_of_type_JavaLangString;
          if ((localObject == null) || ("".equals(localObject))) {
            break label293;
          }
          paramaxsq = new File((String)localObject);
          if (!paramaxsq.exists()) {
            break label293;
          }
          localBundle.putString("pic_local_path", (String)localObject);
        }
      }
    }
    try
    {
      String str1 = bace.b((String)localObject);
      int i = ((String)localObject).lastIndexOf(".");
      if (i != -1)
      {
        String str2 = ((String)localObject).substring(i + 1);
        if ((str1 != null) && (!str1.equals(str2)))
        {
          localObject = ((String)localObject).substring(0, i) + "." + str1;
          if (paramaxsq.renameTo(new File((String)localObject))) {
            localBundle.putString("pic_local_path", (String)localObject);
          }
        }
      }
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(26, localBundle);
      return;
    }
    catch (Exception paramaxsq)
    {
      localBundle.putString("pic_local_id", "-1");
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(26, localBundle);
      return;
    }
    label293:
    localBundle.putString("pic_local_id", "-1");
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(26, localBundle);
  }
  
  public void onUpdateProgeress(axsp paramaxsp, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rrw
 * JD-Core Version:    0.7.0.1
 */