package com.tencent.mobileqq.troop.memberlevel;

import android.graphics.Color;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopMemberLevelMapConfig
{
  private String jdField_a_of_type_JavaLangString = "";
  private HashMap<Integer, TroopMemberLevelMapItem> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<Integer> jdField_a_of_type_JavaUtilList = new ArrayList();
  private TreeMap<Integer, Integer> jdField_a_of_type_JavaUtilTreeMap = new TreeMap();
  private String jdField_b_of_type_JavaLangString = "";
  private HashMap<Integer, TroopMemberLevelColorItem> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  private String c = "";
  
  public static TroopMemberLevelMapConfig a(String paramString)
  {
    Object localObject1 = "";
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("content : ");
      ((StringBuilder)localObject2).append(paramString);
      QLog.d("TroopMemberLevelMapConfig", 2, ((StringBuilder)localObject2).toString());
    }
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    TreeMap localTreeMap = new TreeMap();
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = localObject1;
    try
    {
      Object localObject7 = new JSONObject(paramString);
      localObject2 = localObject1;
      paramString = ((JSONObject)localObject7).getJSONArray("grayTroopUins");
      int i;
      if (paramString != null) {
        try
        {
          if (paramString.length() > 0)
          {
            i = 0;
            while (i < paramString.length())
            {
              localArrayList.add(Integer.valueOf(paramString.getInt(i)));
              i += 1;
            }
          }
          localObject2 = localObject1;
        }
        catch (JSONException localJSONException1)
        {
          localObject2 = "";
          paramString = (String)localObject2;
        }
      }
      localObject6 = ((JSONObject)localObject7).getJSONArray("troopMemberLevelMap");
      Object localObject3 = localObject1;
      if (localObject6 != null)
      {
        localObject3 = localObject1;
        localObject2 = localObject1;
        if (((JSONArray)localObject6).length() > 0)
        {
          i = 0;
          paramString = (String)localObject1;
        }
      }
      for (;;)
      {
        localObject3 = paramString;
        localObject2 = paramString;
        int j;
        int k;
        int m;
        if (i < ((JSONArray)localObject6).length())
        {
          localObject2 = paramString;
          localObject3 = ((JSONArray)localObject6).getJSONObject(i);
          localObject2 = paramString;
          j = ((JSONObject)localObject3).getInt("begin");
          localObject2 = paramString;
          k = ((JSONObject)localObject3).getInt("end");
          localObject2 = paramString;
          m = ((JSONObject)localObject3).getInt("rankid");
          localObject1 = paramString;
        }
        try
        {
          localObject2 = new TroopMemberLevelMapItem(j, k, m, ((JSONObject)localObject3).getString("rankname"));
          localObject1 = paramString;
          localHashMap1.put(Integer.valueOf(((JSONObject)localObject3).getInt("rankid")), localObject2);
          i += 1;
        }
        catch (JSONException localJSONException4)
        {
          Object localObject4;
          paramString = (String)localObject1;
          break label642;
        }
      }
      paramString = (String)localObject3;
      localObject1 = paramString;
      localObject2 = ((JSONObject)localObject7).getJSONArray("titleBackgroundColor");
      if (localObject2 != null)
      {
        localObject1 = paramString;
        if (((JSONArray)localObject2).length() > 0)
        {
          i = 0;
          for (;;)
          {
            localObject1 = paramString;
            if (i >= ((JSONArray)localObject2).length()) {
              break;
            }
            localObject1 = paramString;
            localObject3 = ((JSONArray)localObject2).getJSONObject(i);
            localObject1 = paramString;
            localObject6 = new TroopMemberLevelColorItem(((JSONObject)localObject3).getInt("titleId"), ((JSONObject)localObject3).getString("start"), ((JSONObject)localObject3).getString("end"));
            localObject1 = paramString;
            localHashMap2.put(Integer.valueOf(((JSONObject)localObject3).getInt("titleId")), localObject6);
            i += 1;
          }
        }
      }
      localObject1 = paramString;
      localObject2 = ((JSONObject)localObject7).getJSONArray("oldLevelToNewLevelMap");
      if (localObject2 != null)
      {
        localObject1 = paramString;
        if (((JSONArray)localObject2).length() > 0)
        {
          i = 0;
          for (;;)
          {
            localObject1 = paramString;
            if (i >= ((JSONArray)localObject2).length()) {
              break;
            }
            localObject1 = paramString;
            localObject3 = ((JSONArray)localObject2).getJSONObject(i);
            localObject1 = paramString;
            localTreeMap.put(Integer.valueOf(((JSONObject)localObject3).getInt("old")), Integer.valueOf(((JSONObject)localObject3).getInt("new")));
            i += 1;
          }
        }
      }
      localObject1 = paramString;
      localObject2 = ((JSONObject)localObject7).getJSONObject("onlyLevelBackgroundColor");
      if (localObject2 != null)
      {
        localObject1 = paramString;
        localObject6 = ((JSONObject)localObject2).getString("start");
        try
        {
          localObject2 = ((JSONObject)localObject2).getString("end");
          localObject1 = localObject6;
        }
        catch (JSONException localJSONException2)
        {
          localObject2 = paramString;
          localObject1 = localObject6;
          break label649;
        }
      }
      else
      {
        localObject2 = paramString;
        localObject1 = localObject2;
      }
      try
      {
        localObject7 = ((JSONObject)localObject7).getString("newGroupMemberLevelJumpUrl");
        localObject4 = localObject2;
        localObject6 = localObject1;
        if (localObject7 == null) {
          break label662;
        }
        paramString = (String)localObject7;
      }
      catch (JSONException localJSONException3)
      {
        break label649;
      }
      localObject2 = paramString;
    }
    catch (JSONException localJSONException5)
    {
      paramString = (String)localObject2;
    }
    label642:
    localObject1 = localObject2;
    label649:
    localJSONException5.printStackTrace();
    Object localObject6 = localObject1;
    Object localObject5 = localObject2;
    label662:
    localObject1 = localObject6;
    localObject2 = localObject5;
    localObject5 = new TroopMemberLevelMapConfig();
    ((TroopMemberLevelMapConfig)localObject5).jdField_a_of_type_JavaUtilHashMap = localHashMap1;
    ((TroopMemberLevelMapConfig)localObject5).jdField_b_of_type_JavaUtilHashMap = localHashMap2;
    ((TroopMemberLevelMapConfig)localObject5).jdField_a_of_type_JavaUtilList = localArrayList;
    ((TroopMemberLevelMapConfig)localObject5).jdField_a_of_type_JavaUtilTreeMap = localTreeMap;
    ((TroopMemberLevelMapConfig)localObject5).jdField_a_of_type_JavaLangString = ((String)localObject1);
    ((TroopMemberLevelMapConfig)localObject5).jdField_b_of_type_JavaLangString = ((String)localObject2);
    ((TroopMemberLevelMapConfig)localObject5).c = paramString;
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("levelMap.size : ");
      paramString.append(localHashMap1.size());
      paramString.append(",levelColorMap.size :");
      paramString.append(localHashMap2.size());
      paramString.append(", tempGrayList.size :");
      paramString.append(localArrayList.size());
      QLog.d("TroopMemberLevelMapConfig", 2, paramString.toString());
    }
    return localObject5;
  }
  
  public int a(int paramInt)
  {
    Object localObject1 = this.jdField_a_of_type_JavaUtilHashMap;
    int j = 0;
    if (localObject1 == null) {
      return 0;
    }
    localObject1 = ((HashMap)localObject1).keySet().iterator();
    Object localObject2;
    do
    {
      i = j;
      if (!((Iterator)localObject1).hasNext()) {
        break;
      }
      localObject2 = ((Iterator)localObject1).next();
      localObject2 = (TroopMemberLevelMapItem)this.jdField_a_of_type_JavaUtilHashMap.get(localObject2);
    } while ((((TroopMemberLevelMapItem)localObject2).jdField_a_of_type_Int > paramInt) || (paramInt > ((TroopMemberLevelMapItem)localObject2).b));
    int i = ((TroopMemberLevelMapItem)localObject2).c;
    return i;
  }
  
  public String a()
  {
    return this.c;
  }
  
  public String a(int paramInt)
  {
    Object localObject1 = this.jdField_a_of_type_JavaUtilHashMap;
    Object localObject2 = "";
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberLevelMapConfig", 2, "getRankNameByLevel levelMap is null");
      }
      return "";
    }
    Iterator localIterator = ((HashMap)localObject1).keySet().iterator();
    do
    {
      localObject1 = localObject2;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject1 = (Integer)localIterator.next();
      localObject1 = (TroopMemberLevelMapItem)this.jdField_a_of_type_JavaUtilHashMap.get(localObject1);
    } while ((localObject1 == null) || (((TroopMemberLevelMapItem)localObject1).jdField_a_of_type_Int > paramInt) || (((TroopMemberLevelMapItem)localObject1).b < paramInt));
    localObject1 = ((TroopMemberLevelMapItem)localObject1).jdField_a_of_type_JavaLangString;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getRankNameByLevel strRankName = ");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("TroopMemberLevelMapConfig", 2, ((StringBuilder)localObject2).toString());
    }
    return localObject1;
  }
  
  public boolean a()
  {
    return TextUtils.isEmpty(this.c) ^ true;
  }
  
  public boolean a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isGrayTroop troopUin = ");
      localStringBuilder.append(paramString);
      QLog.d("TroopMemberLevelMapConfig", 2, localStringBuilder.toString());
    }
    boolean bool3 = TextUtils.isEmpty(paramString);
    boolean bool2 = false;
    boolean bool1 = true;
    if ((!bool3) && (this.jdField_a_of_type_JavaUtilList != null))
    {
      paramString = paramString.substring(paramString.length() - 1);
      int i = 0;
      for (;;)
      {
        bool1 = bool2;
        if (i >= this.jdField_a_of_type_JavaUtilList.size()) {
          break;
        }
        if (String.valueOf(this.jdField_a_of_type_JavaUtilList.get(i)).equals(paramString))
        {
          bool1 = true;
          break;
        }
        i += 1;
      }
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("isGrayTroop isGrayTroop = ");
        paramString.append(bool1);
        QLog.d("TroopMemberLevelMapConfig", 2, paramString.toString());
      }
      return bool1;
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("grayTroopUinList is null ? ");
      if (this.jdField_a_of_type_JavaUtilList != null) {
        bool1 = false;
      }
      paramString.append(bool1);
      QLog.d("TroopMemberLevelMapConfig", 2, paramString.toString());
    }
    return false;
  }
  
  public int[] a()
  {
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))) {
      return new int[] { Color.parseColor(this.jdField_a_of_type_JavaLangString), Color.parseColor(this.jdField_b_of_type_JavaLangString) };
    }
    return null;
  }
  
  public int[] a(int paramInt)
  {
    Object localObject = (TroopMemberLevelColorItem)this.jdField_b_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    if (localObject != null)
    {
      String str = ((TroopMemberLevelColorItem)localObject).jdField_a_of_type_JavaLangString;
      localObject = ((TroopMemberLevelColorItem)localObject).jdField_b_of_type_JavaLangString;
      return new int[] { Color.parseColor(str), Color.parseColor((String)localObject) };
    }
    return null;
  }
  
  public int b(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilTreeMap;
    int j = 0;
    int i = j;
    if (localObject != null)
    {
      if (((TreeMap)localObject).size() == 0) {
        return 0;
      }
      localObject = this.jdField_a_of_type_JavaUtilTreeMap.entrySet().iterator();
      int k;
      do
      {
        i = j;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        k = ((Integer)localEntry.getKey()).intValue();
        i = ((Integer)localEntry.getValue()).intValue();
      } while (paramInt != k);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.memberlevel.TroopMemberLevelMapConfig
 * JD-Core Version:    0.7.0.1
 */