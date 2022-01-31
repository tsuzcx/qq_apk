import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.mobileqq.app.QQAppInterface;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class swf
  implements bapx
{
  private bapv jdField_a_of_type_Bapv;
  baua jdField_a_of_type_Baua = new swg(this);
  TroopMemberApiService jdField_a_of_type_ComTencentBizTroopTroopMemberApiService;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<baub> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  HashMap<Long, Bundle> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private ArrayList<baps> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  HashMap<Long, Bundle> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  private ArrayList<baub> jdField_c_of_type_JavaUtilArrayList = new ArrayList();
  HashMap<String, Bundle> jdField_c_of_type_JavaUtilHashMap = new HashMap();
  
  public swf(TroopMemberApiService paramTroopMemberApiService, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService = paramTroopMemberApiService;
    this.jdField_a_of_type_Bapv = paramQQAppInterface.getNetEngine(0);
  }
  
  private void a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      baps localbaps = (baps)localIterator.next();
      if (localbaps.jdField_a_of_type_JavaLangString.equals(paramString)) {
        localArrayList.add(localbaps);
      }
    }
    this.jdField_b_of_type_JavaUtilArrayList.removeAll(localArrayList);
  }
  
  public void a()
  {
    Object localObject2;
    if (this.jdField_a_of_type_Bapv != null)
    {
      localObject1 = this.jdField_b_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (baps)((Iterator)localObject1).next();
        this.jdField_a_of_type_Bapv.b((baqv)localObject2);
      }
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (localObject1 != null)
    {
      localObject2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      baub localbaub;
      while (((Iterator)localObject2).hasNext())
      {
        localbaub = (baub)((Iterator)localObject2).next();
        ((batw)localObject1).a(localbaub.jdField_c_of_type_JavaLangString, localbaub.jdField_a_of_type_Long);
      }
      localObject2 = this.jdField_c_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localbaub = (baub)((Iterator)localObject2).next();
        ((batw)localObject1).b(localbaub.jdField_c_of_type_JavaLangString, localbaub.jdField_a_of_type_Long);
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
      baub localbaub = (baub)localIterator.next();
      if (localbaub.jdField_a_of_type_Long == paramLong) {
        localArrayList.add(localbaub);
      }
    }
    this.jdField_a_of_type_JavaUtilArrayList.removeAll(localArrayList);
  }
  
  public void a(Bundle paramBundle)
  {
    if (ndd.a() == 0)
    {
      paramBundle.putLong("uniseq", 0L);
      paramBundle.putString("pic_server_id", "-1");
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(24, paramBundle);
      return;
    }
    String str = paramBundle.getString("pic_local_path");
    this.jdField_a_of_type_JavaLangString = paramBundle.getString("pic_puin");
    batw localbatw = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    this.jdField_a_of_type_Baua.addFilter(new Class[] { bamp.class });
    localbatw.a(this.jdField_a_of_type_Baua);
    baub localbaub = new baub();
    localbaub.jdField_a_of_type_Boolean = true;
    localbaub.jdField_c_of_type_Int = 10;
    localbaub.i = str;
    localbaub.jdField_a_of_type_Long = ((Math.random() * 1000000.0D));
    localbaub.jdField_c_of_type_JavaLangString = "0";
    localbaub.jdField_b_of_type_Int = 24;
    localbaub.jdField_a_of_type_JavaLangString = "PAJSSDKPicUploadProcess";
    localbatw.a(localbaub);
    this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(localbaub.jdField_a_of_type_Long), paramBundle);
    this.jdField_b_of_type_JavaUtilHashMap.put(Long.valueOf(localbaub.jdField_a_of_type_Long), paramBundle);
    this.jdField_a_of_type_JavaUtilArrayList.add(localbaub);
  }
  
  void b(long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_c_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      baub localbaub = (baub)localIterator.next();
      if (localbaub.jdField_a_of_type_Long == paramLong) {
        localArrayList.add(localbaub);
      }
    }
    this.jdField_c_of_type_JavaUtilArrayList.removeAll(localArrayList);
  }
  
  public void b(Bundle paramBundle)
  {
    int k = 0;
    if (ndd.a() == 0)
    {
      paramBundle.putString("pic_local_id", "-1");
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(26, paramBundle);
    }
    do
    {
      return;
      String str = paramBundle.getString("pic_server_id");
      paramBundle.putInt("seq", paramBundle.getInt("seq", -1));
      baps localbaps = new baps();
      localbaps.jdField_a_of_type_Bapx = this;
      localbaps.jdField_a_of_type_JavaLangString = str;
      localbaps.jdField_c_of_type_Long = 180000L;
      if (localbaps.jdField_a_of_type_JavaLangString == null) {
        break;
      }
      Object localObject1 = localbaps.jdField_a_of_type_JavaLangString.split("/");
      if (localObject1.length < 2) {
        break;
      }
      localObject1 = localObject1[(localObject1.length - 2)];
      localbaps.jdField_c_of_type_JavaLangString = (aljq.aX + "c2bPIC/" + (String)localObject1 + ".png");
      Object localObject2 = new File(aljq.aX + "c2bPIC/");
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
      if (this.jdField_a_of_type_Bapv == null) {
        break;
      }
      this.jdField_a_of_type_Bapv.a(localbaps);
      this.jdField_c_of_type_JavaUtilHashMap.put(str, paramBundle);
      this.jdField_b_of_type_JavaUtilArrayList.add(localbaps);
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
    this.jdField_a_of_type_Baua.addFilter(new Class[] { baqc.class });
    ((batw)localObject).a(this.jdField_a_of_type_Baua);
    localObject = new baub();
    ((baub)localObject).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    ((baub)localObject).jdField_c_of_type_JavaLangString = "255";
    ((baub)localObject).jdField_a_of_type_Int = 9999;
    ((baub)localObject).jdField_b_of_type_Int = 32;
    ((baub)localObject).jdField_a_of_type_Long = ((Math.random() * 1000000.0D));
    ((baub)localObject).jdField_a_of_type_Boolean = true;
    ((baub)localObject).i = str;
    ((baub)localObject).jdField_e_of_type_Int = 102;
    ((baub)localObject).l = true;
    ((baub)localObject).n = 2;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((baub)localObject);
    this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(((baub)localObject).jdField_a_of_type_Long), paramBundle);
    this.jdField_b_of_type_JavaUtilHashMap.put(Long.valueOf(((baub)localObject).jdField_a_of_type_Long), paramBundle);
    this.jdField_c_of_type_JavaUtilArrayList.add(localObject);
  }
  
  public void d(Bundle paramBundle)
  {
    String str = paramBundle.getString("pic_server_id");
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    this.jdField_a_of_type_Baua.addFilter(new Class[] { baqb.class });
    ((batw)localObject).a(this.jdField_a_of_type_Baua);
    localObject = new baub();
    ((baub)localObject).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    ((baub)localObject).jdField_c_of_type_JavaLangString = "255";
    ((baub)localObject).jdField_a_of_type_Int = 9999;
    ((baub)localObject).jdField_b_of_type_Int = 32;
    ((baub)localObject).jdField_a_of_type_Long = ((Math.random() * 1000.0D));
    ((baub)localObject).jdField_a_of_type_Boolean = false;
    ((baub)localObject).jdField_e_of_type_JavaLangString = str;
    ((baub)localObject).h = (aljq.aX + "c2bPTT/" + str + ".amr");
    if (new File(((baub)localObject).h).exists())
    {
      paramBundle.putString("pic_local_id", new sxb().a(((baub)localObject).h));
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(26, paramBundle);
      return;
    }
    ((baub)localObject).jdField_b_of_type_Boolean = true;
    ((baub)localObject).d = 5;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((baub)localObject);
    this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(((baub)localObject).jdField_a_of_type_Long), paramBundle);
    this.jdField_b_of_type_JavaUtilHashMap.put(Long.valueOf(((baub)localObject).jdField_a_of_type_Long), paramBundle);
    this.jdField_c_of_type_JavaUtilArrayList.add(localObject);
  }
  
  public void onResp(baqw parambaqw)
  {
    Object localObject;
    Bundle localBundle;
    if ((parambaqw != null) && ((parambaqw.jdField_a_of_type_Baqv instanceof baps)))
    {
      localObject = (baps)parambaqw.jdField_a_of_type_Baqv;
      if ((parambaqw.jdField_a_of_type_Int == 0) || (parambaqw.jdField_a_of_type_Int == 1))
      {
        localBundle = (Bundle)this.jdField_c_of_type_JavaUtilHashMap.remove(((baps)localObject).jdField_a_of_type_JavaLangString);
        a(((baps)localObject).jdField_a_of_type_JavaLangString);
        if (localBundle != null)
        {
          if ((((baps)localObject).jdField_a_of_type_JavaLangString == null) || (parambaqw.jdField_a_of_type_Int != 0)) {
            break label293;
          }
          parambaqw = ((baps)localObject).jdField_a_of_type_JavaLangString.split("/");
          if (parambaqw.length < 2) {
            break label293;
          }
          localBundle.putString("pic_local_id", parambaqw[(parambaqw.length - 2)]);
          localObject = ((baps)localObject).jdField_c_of_type_JavaLangString;
          if ((localObject == null) || ("".equals(localObject))) {
            break label293;
          }
          parambaqw = new File((String)localObject);
          if (!parambaqw.exists()) {
            break label293;
          }
          localBundle.putString("pic_local_path", (String)localObject);
        }
      }
    }
    try
    {
      String str1 = bdcs.b((String)localObject);
      int i = ((String)localObject).lastIndexOf(".");
      if (i != -1)
      {
        String str2 = ((String)localObject).substring(i + 1);
        if ((str1 != null) && (!str1.equals(str2)))
        {
          localObject = ((String)localObject).substring(0, i) + "." + str1;
          if (parambaqw.renameTo(new File((String)localObject))) {
            localBundle.putString("pic_local_path", (String)localObject);
          }
        }
      }
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(26, localBundle);
      return;
    }
    catch (Exception parambaqw)
    {
      localBundle.putString("pic_local_id", "-1");
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(26, localBundle);
      return;
    }
    label293:
    localBundle.putString("pic_local_id", "-1");
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(26, localBundle);
  }
  
  public void onUpdateProgeress(baqv parambaqv, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     swf
 * JD-Core Version:    0.7.0.1
 */