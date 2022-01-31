package com.tencent.mobileqq.troop.createNewTroop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopCateListProvider
{
  private static TroopCateListProvider a;
  private static final HashMap b = new HashMap();
  protected HashMap a;
  protected JSONArray a;
  protected JSONObject a;
  
  static
  {
    b.put("10009", Integer.valueOf(2130841289));
    b.put("10010", Integer.valueOf(2130841290));
    b.put("10011", Integer.valueOf(2130841291));
    b.put("24", Integer.valueOf(2130841292));
    b.put("25", Integer.valueOf(2130841293));
    b.put("26", Integer.valueOf(2130841294));
    b.put("27", Integer.valueOf(2130841295));
    b.put("28", Integer.valueOf(2130841296));
    b.put("29", Integer.valueOf(2130841297));
    b.put("30", Integer.valueOf(2130841298));
    b.put("31", Integer.valueOf(2130841299));
    b.put("32", Integer.valueOf(2130841300));
  }
  
  private TroopCateListProvider()
  {
    try
    {
      this.jdField_a_of_type_JavaUtilHashMap = new LinkedHashMap();
      this.jdField_a_of_type_OrgJsonJSONObject = new JSONObject("{\"0\":[\"TOP\",\"23\",\"28\",\"29\",\"25\",\"31\",\"30\",\"27\",\"24\",\"26\",\"32\"],\"23\":[\"同事•朋友\",\"10009\",\"10010\",\"10011\",\"10012\"],\"24\":[\"置业安家\",\"10015\",\"10017\"],\"25\":[\"游戏\"],\"26\":[\"品牌产品\"],\"27\":[\"粉丝\"],\"28\":[\"兴趣爱好\",\"10018\",\"10019\",\"10020\",\"10021\",\"10022\",\"10023\",\"10024\",\"10026\"],\"29\":[\"生活休闲\",\"10013\",\"10014\",\"10027\",\"10028\",\"10029\",\"10030\",\"10031\",\"10032\",\"10033\",\"10034\"],\"30\":[\"学习考试\",\"10035\",\"10036\",\"10037\",\"10038\",\"10039\",\"10040\",\"10041\",\"10042\",\"10043\",\"10044\",\"10045\",\"10046\"],\"31\":[\"行业交流\",\"10047\",\"10048\",\"10049\",\"10050\",\"10051\",\"10052\",\"10053\",\"10054\",\"10055\",\"10056\",\"10057\",\"10058\"],\"32\":[\"家校\"],\"10009\":[\"同事\"],\"10010\":[\"亲友\"],\"10011\":[\"同学\"],\"10012\":[\"办公\"],\"10013\":[\"同城\"],\"10014\":[\"同乡\"],\"10015\":[\"业主\"],\"10017\":[\"装修\"],\"10018\":[\"影视\"],\"10019\":[\"音乐\"],\"10020\":[\"星座\"],\"10021\":[\"动漫\"],\"10022\":[\"运动\"],\"10023\":[\"读书\"],\"10024\":[\"摄影\"],\"10026\":[\"其他\"],\"10027\":[\"购物\"],\"10028\":[\"旅游\"],\"10029\":[\"美食\"],\"10030\":[\"美容\"],\"10031\":[\"宠物\"],\"10032\":[\"健康\"],\"10033\":[\"母婴\"],\"10034\":[\"其他\"],\"10035\":[\"托福\"],\"10036\":[\"雅思\"],\"10037\":[\"CET 4/6\"],\"10038\":[\"GRE\"],\"10039\":[\"GMAT\"],\"10040\":[\"MBA\"],\"10041\":[\"考研\"],\"10042\":[\"高考\"],\"10043\":[\"中考\"],\"10044\":[\"职业认证\"],\"10045\":[\"公务员\"],\"10046\":[\"其他\"],\"10047\":[\"投资\"],\"10048\":[\"IT/互联网\"],\"10049\":[\"建筑工程\"],\"10050\":[\"服务\"],\"10051\":[\"传媒\"],\"10052\":[\"营销与广告\"],\"10053\":[\"教师\"],\"10054\":[\"律师\"],\"10055\":[\"公务员\"],\"10056\":[\"银行\"],\"10057\":[\"咨询\"],\"10058\":[\"其他\"]}");
      this.jdField_a_of_type_OrgJsonJSONArray = new JSONArray("[{\"title\":\"熟人与家校\",\"cates\":[\"23:10011\",\"23:10009\",\"23:10010\",\"32\"]},{\"title\":\"兴趣娱乐\",\"cates\":[\"25\",\"27\",\"28\",\"29\"]},{\"title\":\"学习交流\",\"cates\":[\"31\",\"30\",\"24\",\"26\"]}]");
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
    if (jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopTroopCateListProvider == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopTroopCateListProvider == null) {
        jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopTroopCateListProvider = new TroopCateListProvider();
      }
      return jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopTroopCateListProvider;
    }
    finally {}
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
    for (;;)
    {
      if (localObject1 == null) {}
      for (i = 1; this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString); i = 0)
      {
        localObject2 = (TroopCateListProvider.TroopCateInfo)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
        if ((paramBoolean) && ((((TroopCateListProvider.TroopCateInfo)localObject2).jdField_a_of_type_JavaUtilArrayList == null) || (((TroopCateListProvider.TroopCateInfo)localObject2).jdField_a_of_type_JavaUtilArrayList.isEmpty()))) {
          break;
        }
        return localObject2;
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
          if (i < j)
          {
            Object localObject3 = ((JSONArray)localObject2).optString(i);
            JSONArray localJSONArray = this.jdField_a_of_type_OrgJsonJSONObject.optJSONArray((String)localObject3);
            if ((localJSONArray == null) || (localJSONArray.length() == 0)) {}
            for (;;)
            {
              i += 1;
              break;
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
          }
          localTroopCateInfo.c = ((StringBuilder)localObject1).toString();
        }
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localTroopCateInfo);
      return localTroopCateInfo;
      localObject1 = null;
    }
  }
  
  public ArrayList a()
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
      if (j < m)
      {
        TroopCateListProvider.TroopCateInfo localTroopCateInfo2 = a(((JSONArray)localObject).optString(j), true);
        if (localTroopCateInfo2 == null) {}
        for (;;)
        {
          j += 1;
          break;
          localTroopCateInfo1.jdField_a_of_type_JavaUtilArrayList.add(localTroopCateInfo2);
        }
      }
      i += 1;
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.troop.createNewTroop.TroopCateListProvider
 * JD-Core Version:    0.7.0.1
 */