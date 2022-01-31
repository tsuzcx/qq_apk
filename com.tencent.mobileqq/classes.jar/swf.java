import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.mobileqq.app.QQAppInterface;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class swf
  implements baug
{
  private baue jdField_a_of_type_Baue;
  bayj jdField_a_of_type_Bayj = new swg(this);
  TroopMemberApiService jdField_a_of_type_ComTencentBizTroopTroopMemberApiService;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<bayk> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  HashMap<Long, Bundle> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private ArrayList<baub> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  HashMap<Long, Bundle> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  private ArrayList<bayk> jdField_c_of_type_JavaUtilArrayList = new ArrayList();
  HashMap<String, Bundle> jdField_c_of_type_JavaUtilHashMap = new HashMap();
  
  public swf(TroopMemberApiService paramTroopMemberApiService, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService = paramTroopMemberApiService;
    this.jdField_a_of_type_Baue = paramQQAppInterface.getNetEngine(0);
  }
  
  private void a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      baub localbaub = (baub)localIterator.next();
      if (localbaub.jdField_a_of_type_JavaLangString.equals(paramString)) {
        localArrayList.add(localbaub);
      }
    }
    this.jdField_b_of_type_JavaUtilArrayList.removeAll(localArrayList);
  }
  
  public void a()
  {
    Object localObject2;
    if (this.jdField_a_of_type_Baue != null)
    {
      localObject1 = this.jdField_b_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (baub)((Iterator)localObject1).next();
        this.jdField_a_of_type_Baue.b((bave)localObject2);
      }
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (localObject1 != null)
    {
      localObject2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      bayk localbayk;
      while (((Iterator)localObject2).hasNext())
      {
        localbayk = (bayk)((Iterator)localObject2).next();
        ((bayf)localObject1).a(localbayk.jdField_c_of_type_JavaLangString, localbayk.jdField_a_of_type_Long);
      }
      localObject2 = this.jdField_c_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localbayk = (bayk)((Iterator)localObject2).next();
        ((bayf)localObject1).b(localbayk.jdField_c_of_type_JavaLangString, localbayk.jdField_a_of_type_Long);
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
      bayk localbayk = (bayk)localIterator.next();
      if (localbayk.jdField_a_of_type_Long == paramLong) {
        localArrayList.add(localbayk);
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
    bayf localbayf = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    this.jdField_a_of_type_Bayj.addFilter(new Class[] { baqy.class });
    localbayf.a(this.jdField_a_of_type_Bayj);
    bayk localbayk = new bayk();
    localbayk.jdField_a_of_type_Boolean = true;
    localbayk.jdField_c_of_type_Int = 10;
    localbayk.i = str;
    localbayk.jdField_a_of_type_Long = ((Math.random() * 1000000.0D));
    localbayk.jdField_c_of_type_JavaLangString = "0";
    localbayk.jdField_b_of_type_Int = 24;
    localbayk.jdField_a_of_type_JavaLangString = "PAJSSDKPicUploadProcess";
    localbayf.a(localbayk);
    this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(localbayk.jdField_a_of_type_Long), paramBundle);
    this.jdField_b_of_type_JavaUtilHashMap.put(Long.valueOf(localbayk.jdField_a_of_type_Long), paramBundle);
    this.jdField_a_of_type_JavaUtilArrayList.add(localbayk);
  }
  
  void b(long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_c_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      bayk localbayk = (bayk)localIterator.next();
      if (localbayk.jdField_a_of_type_Long == paramLong) {
        localArrayList.add(localbayk);
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
      baub localbaub = new baub();
      localbaub.jdField_a_of_type_Baug = this;
      localbaub.jdField_a_of_type_JavaLangString = str;
      localbaub.jdField_c_of_type_Long = 180000L;
      if (localbaub.jdField_a_of_type_JavaLangString == null) {
        break;
      }
      Object localObject1 = localbaub.jdField_a_of_type_JavaLangString.split("/");
      if (localObject1.length < 2) {
        break;
      }
      localObject1 = localObject1[(localObject1.length - 2)];
      localbaub.jdField_c_of_type_JavaLangString = (alof.aX + "c2bPIC/" + (String)localObject1 + ".png");
      Object localObject2 = new File(alof.aX + "c2bPIC/");
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
      if (this.jdField_a_of_type_Baue == null) {
        break;
      }
      this.jdField_a_of_type_Baue.a(localbaub);
      this.jdField_c_of_type_JavaUtilHashMap.put(str, paramBundle);
      this.jdField_b_of_type_JavaUtilArrayList.add(localbaub);
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
    this.jdField_a_of_type_Bayj.addFilter(new Class[] { baul.class });
    ((bayf)localObject).a(this.jdField_a_of_type_Bayj);
    localObject = new bayk();
    ((bayk)localObject).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    ((bayk)localObject).jdField_c_of_type_JavaLangString = "255";
    ((bayk)localObject).jdField_a_of_type_Int = 9999;
    ((bayk)localObject).jdField_b_of_type_Int = 32;
    ((bayk)localObject).jdField_a_of_type_Long = ((Math.random() * 1000000.0D));
    ((bayk)localObject).jdField_a_of_type_Boolean = true;
    ((bayk)localObject).i = str;
    ((bayk)localObject).jdField_e_of_type_Int = 102;
    ((bayk)localObject).l = true;
    ((bayk)localObject).n = 2;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((bayk)localObject);
    this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(((bayk)localObject).jdField_a_of_type_Long), paramBundle);
    this.jdField_b_of_type_JavaUtilHashMap.put(Long.valueOf(((bayk)localObject).jdField_a_of_type_Long), paramBundle);
    this.jdField_c_of_type_JavaUtilArrayList.add(localObject);
  }
  
  public void d(Bundle paramBundle)
  {
    String str = paramBundle.getString("pic_server_id");
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    this.jdField_a_of_type_Bayj.addFilter(new Class[] { bauk.class });
    ((bayf)localObject).a(this.jdField_a_of_type_Bayj);
    localObject = new bayk();
    ((bayk)localObject).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    ((bayk)localObject).jdField_c_of_type_JavaLangString = "255";
    ((bayk)localObject).jdField_a_of_type_Int = 9999;
    ((bayk)localObject).jdField_b_of_type_Int = 32;
    ((bayk)localObject).jdField_a_of_type_Long = ((Math.random() * 1000.0D));
    ((bayk)localObject).jdField_a_of_type_Boolean = false;
    ((bayk)localObject).jdField_e_of_type_JavaLangString = str;
    ((bayk)localObject).h = (alof.aX + "c2bPTT/" + str + ".amr");
    if (new File(((bayk)localObject).h).exists())
    {
      paramBundle.putString("pic_local_id", new sxb().a(((bayk)localObject).h));
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(26, paramBundle);
      return;
    }
    ((bayk)localObject).jdField_b_of_type_Boolean = true;
    ((bayk)localObject).d = 5;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((bayk)localObject);
    this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(((bayk)localObject).jdField_a_of_type_Long), paramBundle);
    this.jdField_b_of_type_JavaUtilHashMap.put(Long.valueOf(((bayk)localObject).jdField_a_of_type_Long), paramBundle);
    this.jdField_c_of_type_JavaUtilArrayList.add(localObject);
  }
  
  public void onResp(bavf parambavf)
  {
    Object localObject;
    Bundle localBundle;
    if ((parambavf != null) && ((parambavf.jdField_a_of_type_Bave instanceof baub)))
    {
      localObject = (baub)parambavf.jdField_a_of_type_Bave;
      if ((parambavf.jdField_a_of_type_Int == 0) || (parambavf.jdField_a_of_type_Int == 1))
      {
        localBundle = (Bundle)this.jdField_c_of_type_JavaUtilHashMap.remove(((baub)localObject).jdField_a_of_type_JavaLangString);
        a(((baub)localObject).jdField_a_of_type_JavaLangString);
        if (localBundle != null)
        {
          if ((((baub)localObject).jdField_a_of_type_JavaLangString == null) || (parambavf.jdField_a_of_type_Int != 0)) {
            break label293;
          }
          parambavf = ((baub)localObject).jdField_a_of_type_JavaLangString.split("/");
          if (parambavf.length < 2) {
            break label293;
          }
          localBundle.putString("pic_local_id", parambavf[(parambavf.length - 2)]);
          localObject = ((baub)localObject).jdField_c_of_type_JavaLangString;
          if ((localObject == null) || ("".equals(localObject))) {
            break label293;
          }
          parambavf = new File((String)localObject);
          if (!parambavf.exists()) {
            break label293;
          }
          localBundle.putString("pic_local_path", (String)localObject);
        }
      }
    }
    try
    {
      String str1 = bdhb.b((String)localObject);
      int i = ((String)localObject).lastIndexOf(".");
      if (i != -1)
      {
        String str2 = ((String)localObject).substring(i + 1);
        if ((str1 != null) && (!str1.equals(str2)))
        {
          localObject = ((String)localObject).substring(0, i) + "." + str1;
          if (parambavf.renameTo(new File((String)localObject))) {
            localBundle.putString("pic_local_path", (String)localObject);
          }
        }
      }
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(26, localBundle);
      return;
    }
    catch (Exception parambavf)
    {
      localBundle.putString("pic_local_id", "-1");
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(26, localBundle);
      return;
    }
    label293:
    localBundle.putString("pic_local_id", "-1");
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(26, localBundle);
  }
  
  public void onUpdateProgeress(bave parambave, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     swf
 * JD-Core Version:    0.7.0.1
 */