import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.mobileqq.app.QQAppInterface;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class seo
  implements aysa
{
  private ayry jdField_a_of_type_Ayry;
  ayvz jdField_a_of_type_Ayvz = new sep(this);
  TroopMemberApiService jdField_a_of_type_ComTencentBizTroopTroopMemberApiService;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<aywa> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  HashMap<Long, Bundle> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private ArrayList<ayrv> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  HashMap<Long, Bundle> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  private ArrayList<aywa> jdField_c_of_type_JavaUtilArrayList = new ArrayList();
  HashMap<String, Bundle> jdField_c_of_type_JavaUtilHashMap = new HashMap();
  
  public seo(TroopMemberApiService paramTroopMemberApiService, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService = paramTroopMemberApiService;
    this.jdField_a_of_type_Ayry = paramQQAppInterface.getNetEngine(0);
  }
  
  private void a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      ayrv localayrv = (ayrv)localIterator.next();
      if (localayrv.jdField_a_of_type_JavaLangString.equals(paramString)) {
        localArrayList.add(localayrv);
      }
    }
    this.jdField_b_of_type_JavaUtilArrayList.removeAll(localArrayList);
  }
  
  public void a()
  {
    Object localObject2;
    if (this.jdField_a_of_type_Ayry != null)
    {
      localObject1 = this.jdField_b_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ayrv)((Iterator)localObject1).next();
        this.jdField_a_of_type_Ayry.b((aysw)localObject2);
      }
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (localObject1 != null)
    {
      localObject2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      aywa localaywa;
      while (((Iterator)localObject2).hasNext())
      {
        localaywa = (aywa)((Iterator)localObject2).next();
        ((ayvv)localObject1).a(localaywa.jdField_c_of_type_JavaLangString, localaywa.jdField_a_of_type_Long);
      }
      localObject2 = this.jdField_c_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localaywa = (aywa)((Iterator)localObject2).next();
        ((ayvv)localObject1).b(localaywa.jdField_c_of_type_JavaLangString, localaywa.jdField_a_of_type_Long);
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
      aywa localaywa = (aywa)localIterator.next();
      if (localaywa.jdField_a_of_type_Long == paramLong) {
        localArrayList.add(localaywa);
      }
    }
    this.jdField_a_of_type_JavaUtilArrayList.removeAll(localArrayList);
  }
  
  public void a(Bundle paramBundle)
  {
    if (nam.a() == 0)
    {
      paramBundle.putLong("uniseq", 0L);
      paramBundle.putString("pic_server_id", "-1");
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(24, paramBundle);
      return;
    }
    String str = paramBundle.getString("pic_local_path");
    this.jdField_a_of_type_JavaLangString = paramBundle.getString("pic_puin");
    ayvv localayvv = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    this.jdField_a_of_type_Ayvz.addFilter(new Class[] { ayos.class });
    localayvv.a(this.jdField_a_of_type_Ayvz);
    aywa localaywa = new aywa();
    localaywa.jdField_a_of_type_Boolean = true;
    localaywa.jdField_c_of_type_Int = 10;
    localaywa.i = str;
    localaywa.jdField_a_of_type_Long = ((Math.random() * 1000000.0D));
    localaywa.jdField_c_of_type_JavaLangString = "0";
    localaywa.jdField_b_of_type_Int = 24;
    localaywa.jdField_a_of_type_JavaLangString = "PAJSSDKPicUploadProcess";
    localayvv.a(localaywa);
    this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(localaywa.jdField_a_of_type_Long), paramBundle);
    this.jdField_b_of_type_JavaUtilHashMap.put(Long.valueOf(localaywa.jdField_a_of_type_Long), paramBundle);
    this.jdField_a_of_type_JavaUtilArrayList.add(localaywa);
  }
  
  void b(long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_c_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      aywa localaywa = (aywa)localIterator.next();
      if (localaywa.jdField_a_of_type_Long == paramLong) {
        localArrayList.add(localaywa);
      }
    }
    this.jdField_c_of_type_JavaUtilArrayList.removeAll(localArrayList);
  }
  
  public void b(Bundle paramBundle)
  {
    int k = 0;
    if (nam.a() == 0)
    {
      paramBundle.putString("pic_local_id", "-1");
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(26, paramBundle);
    }
    do
    {
      return;
      String str = paramBundle.getString("pic_server_id");
      paramBundle.putInt("seq", paramBundle.getInt("seq", -1));
      ayrv localayrv = new ayrv();
      localayrv.jdField_a_of_type_Aysa = this;
      localayrv.jdField_a_of_type_JavaLangString = str;
      localayrv.jdField_c_of_type_Long = 180000L;
      if (localayrv.jdField_a_of_type_JavaLangString == null) {
        break;
      }
      Object localObject1 = localayrv.jdField_a_of_type_JavaLangString.split("/");
      if (localObject1.length < 2) {
        break;
      }
      localObject1 = localObject1[(localObject1.length - 2)];
      localayrv.jdField_c_of_type_JavaLangString = (ajsf.aW + "c2bPIC/" + (String)localObject1 + ".png");
      Object localObject2 = new File(ajsf.aW + "c2bPIC/");
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
      if (this.jdField_a_of_type_Ayry == null) {
        break;
      }
      this.jdField_a_of_type_Ayry.a(localayrv);
      this.jdField_c_of_type_JavaUtilHashMap.put(str, paramBundle);
      this.jdField_b_of_type_JavaUtilArrayList.add(localayrv);
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
    this.jdField_a_of_type_Ayvz.addFilter(new Class[] { aysd.class });
    ((ayvv)localObject).a(this.jdField_a_of_type_Ayvz);
    localObject = new aywa();
    ((aywa)localObject).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    ((aywa)localObject).jdField_c_of_type_JavaLangString = "255";
    ((aywa)localObject).jdField_a_of_type_Int = 9999;
    ((aywa)localObject).jdField_b_of_type_Int = 32;
    ((aywa)localObject).jdField_a_of_type_Long = ((Math.random() * 1000000.0D));
    ((aywa)localObject).jdField_a_of_type_Boolean = true;
    ((aywa)localObject).i = str;
    ((aywa)localObject).jdField_e_of_type_Int = 102;
    ((aywa)localObject).l = true;
    ((aywa)localObject).n = 2;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((aywa)localObject);
    this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(((aywa)localObject).jdField_a_of_type_Long), paramBundle);
    this.jdField_b_of_type_JavaUtilHashMap.put(Long.valueOf(((aywa)localObject).jdField_a_of_type_Long), paramBundle);
    this.jdField_c_of_type_JavaUtilArrayList.add(localObject);
  }
  
  public void d(Bundle paramBundle)
  {
    String str = paramBundle.getString("pic_server_id");
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    this.jdField_a_of_type_Ayvz.addFilter(new Class[] { aysc.class });
    ((ayvv)localObject).a(this.jdField_a_of_type_Ayvz);
    localObject = new aywa();
    ((aywa)localObject).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    ((aywa)localObject).jdField_c_of_type_JavaLangString = "255";
    ((aywa)localObject).jdField_a_of_type_Int = 9999;
    ((aywa)localObject).jdField_b_of_type_Int = 32;
    ((aywa)localObject).jdField_a_of_type_Long = ((Math.random() * 1000.0D));
    ((aywa)localObject).jdField_a_of_type_Boolean = false;
    ((aywa)localObject).jdField_e_of_type_JavaLangString = str;
    ((aywa)localObject).h = (ajsf.aW + "c2bPTT/" + str + ".amr");
    if (new File(((aywa)localObject).h).exists())
    {
      paramBundle.putString("pic_local_id", new sfk().a(((aywa)localObject).h));
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(26, paramBundle);
      return;
    }
    ((aywa)localObject).jdField_b_of_type_Boolean = true;
    ((aywa)localObject).d = 5;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((aywa)localObject);
    this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(((aywa)localObject).jdField_a_of_type_Long), paramBundle);
    this.jdField_b_of_type_JavaUtilHashMap.put(Long.valueOf(((aywa)localObject).jdField_a_of_type_Long), paramBundle);
    this.jdField_c_of_type_JavaUtilArrayList.add(localObject);
  }
  
  public void onResp(aysx paramaysx)
  {
    Object localObject;
    Bundle localBundle;
    if ((paramaysx != null) && ((paramaysx.jdField_a_of_type_Aysw instanceof ayrv)))
    {
      localObject = (ayrv)paramaysx.jdField_a_of_type_Aysw;
      if ((paramaysx.jdField_a_of_type_Int == 0) || (paramaysx.jdField_a_of_type_Int == 1))
      {
        localBundle = (Bundle)this.jdField_c_of_type_JavaUtilHashMap.remove(((ayrv)localObject).jdField_a_of_type_JavaLangString);
        a(((ayrv)localObject).jdField_a_of_type_JavaLangString);
        if (localBundle != null)
        {
          if ((((ayrv)localObject).jdField_a_of_type_JavaLangString == null) || (paramaysx.jdField_a_of_type_Int != 0)) {
            break label293;
          }
          paramaysx = ((ayrv)localObject).jdField_a_of_type_JavaLangString.split("/");
          if (paramaysx.length < 2) {
            break label293;
          }
          localBundle.putString("pic_local_id", paramaysx[(paramaysx.length - 2)]);
          localObject = ((ayrv)localObject).jdField_c_of_type_JavaLangString;
          if ((localObject == null) || ("".equals(localObject))) {
            break label293;
          }
          paramaysx = new File((String)localObject);
          if (!paramaysx.exists()) {
            break label293;
          }
          localBundle.putString("pic_local_path", (String)localObject);
        }
      }
    }
    try
    {
      String str1 = bbdj.b((String)localObject);
      int i = ((String)localObject).lastIndexOf(".");
      if (i != -1)
      {
        String str2 = ((String)localObject).substring(i + 1);
        if ((str1 != null) && (!str1.equals(str2)))
        {
          localObject = ((String)localObject).substring(0, i) + "." + str1;
          if (paramaysx.renameTo(new File((String)localObject))) {
            localBundle.putString("pic_local_path", (String)localObject);
          }
        }
      }
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(26, localBundle);
      return;
    }
    catch (Exception paramaysx)
    {
      localBundle.putString("pic_local_id", "-1");
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(26, localBundle);
      return;
    }
    label293:
    localBundle.putString("pic_local_id", "-1");
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(26, localBundle);
  }
  
  public void onUpdateProgeress(aysw paramaysw, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     seo
 * JD-Core Version:    0.7.0.1
 */