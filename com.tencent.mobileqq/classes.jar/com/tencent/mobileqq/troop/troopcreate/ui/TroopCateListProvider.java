package com.tencent.mobileqq.troop.troopcreate.ui;

import com.tencent.mobileqq.vas.config.business.qvip.QVIPPrettyTroopProcessor;
import com.tencent.mobileqq.vas.config.business.qvip.QVipPrettyTroopConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopCateListProvider
{
  private static TroopCateListProvider a;
  private static final HashMap<String, Integer> b = new HashMap();
  protected HashMap<String, TroopCateListProvider.TroopCateInfo> a;
  protected JSONArray a;
  protected JSONObject a;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiTroopCateListProvider = null;
    b.put("10009", Integer.valueOf(2130843848));
    b.put("10010", Integer.valueOf(2130843849));
    b.put("10011", Integer.valueOf(2130843850));
    b.put("24", Integer.valueOf(2130843851));
    b.put("25", Integer.valueOf(2130843852));
    b.put("26", Integer.valueOf(2130843853));
    b.put("27", Integer.valueOf(2130843854));
    b.put("28", Integer.valueOf(2130843855));
    b.put("29", Integer.valueOf(2130843856));
    b.put("30", Integer.valueOf(2130843857));
    b.put("31", Integer.valueOf(2130843858));
    b.put("32", Integer.valueOf(2130843859));
    b.put("20001", Integer.valueOf(2130843767));
    b.put("20002", Integer.valueOf(2130843768));
    b.put("20003", Integer.valueOf(2130847166));
  }
  
  private TroopCateListProvider()
  {
    this.jdField_a_of_type_JavaUtilHashMap = null;
    try
    {
      this.jdField_a_of_type_JavaUtilHashMap = new LinkedHashMap();
      this.jdField_a_of_type_OrgJsonJSONObject = new JSONObject("{\"0\":[\"TOP\",\"23\",\"28\",\"29\",\"25\",\"31\",\"30\",\"27\",\"24\",\"26\",\"32\"],\"23\":[\"同事•朋友\",\"10009\",\"10010\",\"10011\",\"10012\"],\"24\":[\"置业安家\",\"10015\",\"10017\",\"30007\",\"30008\"],\"25\":[\"游戏\"],\"26\":[\"品牌产品\"],\"27\":[\"粉丝\"],\"28\":[\"兴趣爱好\",\"10018\",\"10019\",\"10020\",\"10021\",\"10022\",\"10023\",\"10024\",\"30000\",\"30001\",\"30002\",\"10026\"],\"29\":[\"生活休闲\",\"10029\",\"10028\",\"30003\",\"10027\",\"10031\",\"10032\",\"30004\",\"10033\",\"30005\",\"30006\",\"10014\",\"10034\"],\"30\":[\"学习考试\",\"10035\",\"10036\",\"10037\",\"10038\",\"10039\",\"10040\",\"10041\",\"10042\",\"10043\",\"10044\",\"10045\",\"10046\"],\"31\":[\"行业交流\",\"10047\",\"10048\",\"10049\",\"10050\",\"10051\",\"10052\",\"10053\",\"10054\",\"10055\",\"10056\",\"10057\",\"10058\"],\"32\":[\"家校\"],\"10009\":[\"同事\"],\"10010\":[\"亲友\"],\"10011\":[\"同学\"],\"10012\":[\"办公\"],\"10013\":[\"同城\"],\"10014\":[\"同乡\"],\"10015\":[\"业主\"],\"10017\":[\"装修\"],\"10018\":[\"影视\"],\"10019\":[\"音乐\"],\"10020\":[\"星座\"],\"10021\":[\"动漫\"],\"10022\":[\"运动\"],\"10023\":[\"读书\"],\"10024\":[\"摄影\"],\"10026\":[\"其他\"],\"10027\":[\"购物\"],\"10028\":[\"旅游\"],\"10029\":[\"美食\"],\"10030\":[\"美容\"],\"10031\":[\"宠物\"],\"10032\":[\"健康\"],\"10033\":[\"母婴\"],\"10034\":[\"其他\"],\"10035\":[\"托福\"],\"10036\":[\"雅思\"],\"10037\":[\"CET 4/6\"],\"10038\":[\"GRE\"],\"10039\":[\"GMAT\"],\"10040\":[\"MBA\"],\"10041\":[\"考研\"],\"10042\":[\"高考\"],\"10043\":[\"中考\"],\"10044\":[\"职业认证\"],\"10045\":[\"公务员\"],\"10046\":[\"其他\"],\"10047\":[\"投资\"],\"10048\":[\"IT/互联网\"],\"10049\":[\"建筑工程\"],\"10050\":[\"服务\"],\"10051\":[\"传媒\"],\"10052\":[\"营销与广告\"],\"10053\":[\"教师\"],\"10054\":[\"律师\"],\"10055\":[\"公务员\"],\"10056\":[\"银行\"],\"10057\":[\"咨询\"],\"10058\":[\"其他\"], \"20001\":[\"2000人群\"], \"20002\":[\"3000人群\"], \"20003\":[\"靓号群\"], \"30000\":[\"舞蹈\"], \"30001\":[\"电子产品\"], \"30002\":[\"汽车\"], \"30003\":[\"交友\"],\"30004\":[\"兼职\"],\"30005\":[\"二手闲置\"],\"30006\":[\"公益\"],\"30007\":[\"房屋租赁\"],\"30008\":[\"房屋出售\"]}");
      if (QVIPPrettyTroopProcessor.c().b)
      {
        this.jdField_a_of_type_OrgJsonJSONArray = new JSONArray("[{\"title\":\"熟人与家校\",\"cates\":[\"23:10011\",\"23:10009\",\"23:10010\",\"32\"]},{\"title\":\"兴趣娱乐\",\"cates\":[\"25\",\"27\",\"28\",\"29\"]},{\"title\":\"学习交流\",\"cates\":[\"31\",\"30\",\"24\",\"26\"]},{\"title\":\"靓号群与超大群\",\"cates\":[\"20001\", \"20002\", \"20003\"]}]");
        return;
      }
      this.jdField_a_of_type_OrgJsonJSONArray = new JSONArray("[{\"title\":\"熟人与家校\",\"cates\":[\"23:10011\",\"23:10009\",\"23:10010\",\"32\"]},{\"title\":\"兴趣娱乐\",\"cates\":[\"25\",\"27\",\"28\",\"29\"]},{\"title\":\"学习交流\",\"cates\":[\"31\",\"30\",\"24\",\"26\"]},{\"title\":\"超大群\",\"cates\":[\"20001\", \"20002\"]}]");
      return;
    }
    catch (JSONException localJSONException)
    {
      this.jdField_a_of_type_OrgJsonJSONObject = new JSONObject();
      this.jdField_a_of_type_OrgJsonJSONArray = new JSONArray();
      localJSONException.printStackTrace();
    }
  }
  
  public static TroopCateListProvider a()
  {
    if (jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiTroopCateListProvider == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiTroopCateListProvider == null) {
          jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiTroopCateListProvider = new TroopCateListProvider();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiTroopCateListProvider;
  }
  
  public TroopCateListProvider.TroopCateInfo a(String paramString, boolean paramBoolean)
  {
    int i = paramString.indexOf(":");
    Object localObject1;
    if (i != -1)
    {
      localObject1 = paramString.substring(0, i);
      paramString = paramString.substring(i + 1);
    }
    else
    {
      localObject1 = null;
    }
    if (localObject1 == null) {
      i = 1;
    } else {
      i = 0;
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))
    {
      localObject2 = (TroopCateListProvider.TroopCateInfo)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
      if ((!paramBoolean) || ((((TroopCateListProvider.TroopCateInfo)localObject2).jdField_a_of_type_JavaUtilArrayList != null) && (!((TroopCateListProvider.TroopCateInfo)localObject2).jdField_a_of_type_JavaUtilArrayList.isEmpty()))) {
        return localObject2;
      }
    }
    Object localObject2 = this.jdField_a_of_type_OrgJsonJSONObject.optJSONArray(paramString);
    TroopCateListProvider.TroopCateInfo localTroopCateInfo = new TroopCateListProvider.TroopCateInfo();
    localTroopCateInfo.a(paramString);
    localTroopCateInfo.d = ((String)localObject1);
    localTroopCateInfo.jdField_b_of_type_Int = i;
    localTroopCateInfo.jdField_b_of_type_JavaLangString = ((JSONArray)localObject2).optString(0);
    int j = ((JSONArray)localObject2).length();
    if (j > 1)
    {
      localTroopCateInfo.jdField_a_of_type_Boolean = true;
      if (paramBoolean)
      {
        localTroopCateInfo.jdField_a_of_type_JavaUtilArrayList = new ArrayList(j);
        localObject1 = new StringBuilder();
        i = 1;
        while (i < j)
        {
          Object localObject3 = ((JSONArray)localObject2).optString(i);
          JSONArray localJSONArray = this.jdField_a_of_type_OrgJsonJSONObject.optJSONArray((String)localObject3);
          if ((localJSONArray != null) && (localJSONArray.length() != 0))
          {
            localObject3 = new TroopCateListProvider.TroopCateInfo((String)localObject3, localJSONArray.optString(0));
            ((TroopCateListProvider.TroopCateInfo)localObject3).d = paramString;
            localTroopCateInfo.jdField_a_of_type_JavaUtilArrayList.add(localObject3);
            if (i <= 2)
            {
              if (i != 1) {
                ((StringBuilder)localObject1).append("、");
              }
              ((StringBuilder)localObject1).append(((TroopCateListProvider.TroopCateInfo)localObject3).jdField_b_of_type_JavaLangString);
            }
          }
          i += 1;
        }
        localTroopCateInfo.c = ((StringBuilder)localObject1).toString();
      }
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localTroopCateInfo);
    return localTroopCateInfo;
  }
  
  public ArrayList<TroopCateListProvider.TroopCateInfo> a()
  {
    ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_OrgJsonJSONArray.length());
    int k = this.jdField_a_of_type_OrgJsonJSONArray.length();
    int i = 0;
    while (i < k)
    {
      Object localObject = this.jdField_a_of_type_OrgJsonJSONArray.optJSONObject(i);
      TroopCateListProvider.TroopCateInfo localTroopCateInfo1 = new TroopCateListProvider.TroopCateInfo();
      localTroopCateInfo1.jdField_b_of_type_Int = 2;
      localTroopCateInfo1.jdField_b_of_type_JavaLangString = ((JSONObject)localObject).optString("title");
      localArrayList.add(localTroopCateInfo1);
      localTroopCateInfo1.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      localObject = ((JSONObject)localObject).optJSONArray("cates");
      int m = ((JSONArray)localObject).length();
      int j = 0;
      while (j < m)
      {
        TroopCateListProvider.TroopCateInfo localTroopCateInfo2 = a(((JSONArray)localObject).optString(j), true);
        if (localTroopCateInfo2 != null) {
          localTroopCateInfo1.jdField_a_of_type_JavaUtilArrayList.add(localTroopCateInfo2);
        }
        j += 1;
      }
      i += 1;
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcreate.ui.TroopCateListProvider
 * JD-Core Version:    0.7.0.1
 */