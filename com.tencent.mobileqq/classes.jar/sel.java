import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.mobileqq.app.QQAppInterface;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class sel
  implements aysc
{
  private aysa jdField_a_of_type_Aysa;
  aywb jdField_a_of_type_Aywb = new sem(this);
  TroopMemberApiService jdField_a_of_type_ComTencentBizTroopTroopMemberApiService;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<aywc> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  HashMap<Long, Bundle> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private ArrayList<ayrx> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  HashMap<Long, Bundle> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  private ArrayList<aywc> jdField_c_of_type_JavaUtilArrayList = new ArrayList();
  HashMap<String, Bundle> jdField_c_of_type_JavaUtilHashMap = new HashMap();
  
  public sel(TroopMemberApiService paramTroopMemberApiService, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService = paramTroopMemberApiService;
    this.jdField_a_of_type_Aysa = paramQQAppInterface.getNetEngine(0);
  }
  
  private void a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      ayrx localayrx = (ayrx)localIterator.next();
      if (localayrx.jdField_a_of_type_JavaLangString.equals(paramString)) {
        localArrayList.add(localayrx);
      }
    }
    this.jdField_b_of_type_JavaUtilArrayList.removeAll(localArrayList);
  }
  
  public void a()
  {
    Object localObject2;
    if (this.jdField_a_of_type_Aysa != null)
    {
      localObject1 = this.jdField_b_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ayrx)((Iterator)localObject1).next();
        this.jdField_a_of_type_Aysa.b((aysy)localObject2);
      }
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (localObject1 != null)
    {
      localObject2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      aywc localaywc;
      while (((Iterator)localObject2).hasNext())
      {
        localaywc = (aywc)((Iterator)localObject2).next();
        ((ayvx)localObject1).a(localaywc.jdField_c_of_type_JavaLangString, localaywc.jdField_a_of_type_Long);
      }
      localObject2 = this.jdField_c_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localaywc = (aywc)((Iterator)localObject2).next();
        ((ayvx)localObject1).b(localaywc.jdField_c_of_type_JavaLangString, localaywc.jdField_a_of_type_Long);
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
      aywc localaywc = (aywc)localIterator.next();
      if (localaywc.jdField_a_of_type_Long == paramLong) {
        localArrayList.add(localaywc);
      }
    }
    this.jdField_a_of_type_JavaUtilArrayList.removeAll(localArrayList);
  }
  
  public void a(Bundle paramBundle)
  {
    if (naj.a() == 0)
    {
      paramBundle.putLong("uniseq", 0L);
      paramBundle.putString("pic_server_id", "-1");
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(24, paramBundle);
      return;
    }
    String str = paramBundle.getString("pic_local_path");
    this.jdField_a_of_type_JavaLangString = paramBundle.getString("pic_puin");
    ayvx localayvx = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    this.jdField_a_of_type_Aywb.addFilter(new Class[] { ayou.class });
    localayvx.a(this.jdField_a_of_type_Aywb);
    aywc localaywc = new aywc();
    localaywc.jdField_a_of_type_Boolean = true;
    localaywc.jdField_c_of_type_Int = 10;
    localaywc.i = str;
    localaywc.jdField_a_of_type_Long = ((Math.random() * 1000000.0D));
    localaywc.jdField_c_of_type_JavaLangString = "0";
    localaywc.jdField_b_of_type_Int = 24;
    localaywc.jdField_a_of_type_JavaLangString = "PAJSSDKPicUploadProcess";
    localayvx.a(localaywc);
    this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(localaywc.jdField_a_of_type_Long), paramBundle);
    this.jdField_b_of_type_JavaUtilHashMap.put(Long.valueOf(localaywc.jdField_a_of_type_Long), paramBundle);
    this.jdField_a_of_type_JavaUtilArrayList.add(localaywc);
  }
  
  void b(long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_c_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      aywc localaywc = (aywc)localIterator.next();
      if (localaywc.jdField_a_of_type_Long == paramLong) {
        localArrayList.add(localaywc);
      }
    }
    this.jdField_c_of_type_JavaUtilArrayList.removeAll(localArrayList);
  }
  
  public void b(Bundle paramBundle)
  {
    int k = 0;
    if (naj.a() == 0)
    {
      paramBundle.putString("pic_local_id", "-1");
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(26, paramBundle);
    }
    do
    {
      return;
      String str = paramBundle.getString("pic_server_id");
      paramBundle.putInt("seq", paramBundle.getInt("seq", -1));
      ayrx localayrx = new ayrx();
      localayrx.jdField_a_of_type_Aysc = this;
      localayrx.jdField_a_of_type_JavaLangString = str;
      localayrx.jdField_c_of_type_Long = 180000L;
      if (localayrx.jdField_a_of_type_JavaLangString == null) {
        break;
      }
      Object localObject1 = localayrx.jdField_a_of_type_JavaLangString.split("/");
      if (localObject1.length < 2) {
        break;
      }
      localObject1 = localObject1[(localObject1.length - 2)];
      localayrx.jdField_c_of_type_JavaLangString = (ajsd.aW + "c2bPIC/" + (String)localObject1 + ".png");
      Object localObject2 = new File(ajsd.aW + "c2bPIC/");
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
      if (this.jdField_a_of_type_Aysa == null) {
        break;
      }
      this.jdField_a_of_type_Aysa.a(localayrx);
      this.jdField_c_of_type_JavaUtilHashMap.put(str, paramBundle);
      this.jdField_b_of_type_JavaUtilArrayList.add(localayrx);
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
    this.jdField_a_of_type_Aywb.addFilter(new Class[] { aysf.class });
    ((ayvx)localObject).a(this.jdField_a_of_type_Aywb);
    localObject = new aywc();
    ((aywc)localObject).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    ((aywc)localObject).jdField_c_of_type_JavaLangString = "255";
    ((aywc)localObject).jdField_a_of_type_Int = 9999;
    ((aywc)localObject).jdField_b_of_type_Int = 32;
    ((aywc)localObject).jdField_a_of_type_Long = ((Math.random() * 1000000.0D));
    ((aywc)localObject).jdField_a_of_type_Boolean = true;
    ((aywc)localObject).i = str;
    ((aywc)localObject).jdField_e_of_type_Int = 102;
    ((aywc)localObject).l = true;
    ((aywc)localObject).n = 2;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((aywc)localObject);
    this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(((aywc)localObject).jdField_a_of_type_Long), paramBundle);
    this.jdField_b_of_type_JavaUtilHashMap.put(Long.valueOf(((aywc)localObject).jdField_a_of_type_Long), paramBundle);
    this.jdField_c_of_type_JavaUtilArrayList.add(localObject);
  }
  
  public void d(Bundle paramBundle)
  {
    String str = paramBundle.getString("pic_server_id");
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    this.jdField_a_of_type_Aywb.addFilter(new Class[] { ayse.class });
    ((ayvx)localObject).a(this.jdField_a_of_type_Aywb);
    localObject = new aywc();
    ((aywc)localObject).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    ((aywc)localObject).jdField_c_of_type_JavaLangString = "255";
    ((aywc)localObject).jdField_a_of_type_Int = 9999;
    ((aywc)localObject).jdField_b_of_type_Int = 32;
    ((aywc)localObject).jdField_a_of_type_Long = ((Math.random() * 1000.0D));
    ((aywc)localObject).jdField_a_of_type_Boolean = false;
    ((aywc)localObject).jdField_e_of_type_JavaLangString = str;
    ((aywc)localObject).h = (ajsd.aW + "c2bPTT/" + str + ".amr");
    if (new File(((aywc)localObject).h).exists())
    {
      paramBundle.putString("pic_local_id", new sfh().a(((aywc)localObject).h));
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(26, paramBundle);
      return;
    }
    ((aywc)localObject).jdField_b_of_type_Boolean = true;
    ((aywc)localObject).d = 5;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((aywc)localObject);
    this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(((aywc)localObject).jdField_a_of_type_Long), paramBundle);
    this.jdField_b_of_type_JavaUtilHashMap.put(Long.valueOf(((aywc)localObject).jdField_a_of_type_Long), paramBundle);
    this.jdField_c_of_type_JavaUtilArrayList.add(localObject);
  }
  
  public void onResp(aysz paramaysz)
  {
    Object localObject;
    Bundle localBundle;
    if ((paramaysz != null) && ((paramaysz.jdField_a_of_type_Aysy instanceof ayrx)))
    {
      localObject = (ayrx)paramaysz.jdField_a_of_type_Aysy;
      if ((paramaysz.jdField_a_of_type_Int == 0) || (paramaysz.jdField_a_of_type_Int == 1))
      {
        localBundle = (Bundle)this.jdField_c_of_type_JavaUtilHashMap.remove(((ayrx)localObject).jdField_a_of_type_JavaLangString);
        a(((ayrx)localObject).jdField_a_of_type_JavaLangString);
        if (localBundle != null)
        {
          if ((((ayrx)localObject).jdField_a_of_type_JavaLangString == null) || (paramaysz.jdField_a_of_type_Int != 0)) {
            break label293;
          }
          paramaysz = ((ayrx)localObject).jdField_a_of_type_JavaLangString.split("/");
          if (paramaysz.length < 2) {
            break label293;
          }
          localBundle.putString("pic_local_id", paramaysz[(paramaysz.length - 2)]);
          localObject = ((ayrx)localObject).jdField_c_of_type_JavaLangString;
          if ((localObject == null) || ("".equals(localObject))) {
            break label293;
          }
          paramaysz = new File((String)localObject);
          if (!paramaysz.exists()) {
            break label293;
          }
          localBundle.putString("pic_local_path", (String)localObject);
        }
      }
    }
    try
    {
      String str1 = bbdx.b((String)localObject);
      int i = ((String)localObject).lastIndexOf(".");
      if (i != -1)
      {
        String str2 = ((String)localObject).substring(i + 1);
        if ((str1 != null) && (!str1.equals(str2)))
        {
          localObject = ((String)localObject).substring(0, i) + "." + str1;
          if (paramaysz.renameTo(new File((String)localObject))) {
            localBundle.putString("pic_local_path", (String)localObject);
          }
        }
      }
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(26, localBundle);
      return;
    }
    catch (Exception paramaysz)
    {
      localBundle.putString("pic_local_id", "-1");
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(26, localBundle);
      return;
    }
    label293:
    localBundle.putString("pic_local_id", "-1");
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(26, localBundle);
  }
  
  public void onUpdateProgeress(aysy paramaysy, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     sel
 * JD-Core Version:    0.7.0.1
 */