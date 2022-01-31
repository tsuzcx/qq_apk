package com.tencent.mobileqq.worldcup;

import com.tencent.mobileqq.armap.sensor.rotation.Vector3;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class ARWorldCupVideoInfo
{
  public static int a;
  public static int b;
  ARWorldCupVideoInfo.BackConfirmDialogInfo jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupVideoInfo$BackConfirmDialogInfo;
  List jdField_a_of_type_JavaUtilList;
  Map jdField_a_of_type_JavaUtilMap;
  double[] jdField_a_of_type_ArrayOfDouble;
  ARWorldCupVideoInfo.BackConfirmDialogInfo jdField_b_of_type_ComTencentMobileqqWorldcupARWorldCupVideoInfo$BackConfirmDialogInfo;
  List jdField_b_of_type_JavaUtilList;
  double[] jdField_b_of_type_ArrayOfDouble;
  List c;
  List d;
  List e;
  
  static
  {
    jdField_a_of_type_Int = 1;
    jdField_b_of_type_Int = 2;
  }
  
  static ARWorldCupVideoInfo a(String paramString)
  {
    JSONObject localJSONObject;
    Object localObject3;
    Object localObject4;
    int i;
    try
    {
      localJSONObject = new JSONObject(paramString);
      paramString = new ARWorldCupVideoInfo();
      paramString.jdField_a_of_type_JavaUtilMap = new HashMap();
      localObject1 = localJSONObject.getJSONObject("videofileinfo");
      if (localObject1 != null)
      {
        localObject2 = ((JSONObject)localObject1).keys();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          localObject4 = ((JSONObject)localObject1).getJSONArray((String)localObject3);
          double[] arrayOfDouble = new double[((JSONArray)localObject4).length()];
          i = 0;
          while (i < arrayOfDouble.length)
          {
            arrayOfDouble[i] = ((JSONArray)localObject4).getDouble(i);
            i += 1;
          }
          paramString.jdField_a_of_type_JavaUtilMap.put(localObject3, arrayOfDouble);
        }
      }
      localObject1 = localJSONObject.getJSONObject("360ballvideoinfo");
    }
    catch (Exception paramString)
    {
      QLog.d("ARWorldCupGlobalSceneRenderable_ARWorldCupGameUtil", 1, String.format("parseJson, Exception\n%s", new Object[] { paramString }));
      return null;
    }
    Object localObject2 = ((JSONObject)localObject1).getJSONArray("translatearray");
    if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0))
    {
      paramString.jdField_a_of_type_ArrayOfDouble = new double[((JSONArray)localObject2).length()];
      i = 0;
      while (i < ((JSONArray)localObject2).length())
      {
        paramString.jdField_a_of_type_ArrayOfDouble[i] = ((JSONArray)localObject2).getDouble(i);
        i += 1;
      }
    }
    Object localObject1 = ((JSONObject)localObject1).getJSONArray("timearray");
    if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0))
    {
      paramString.jdField_b_of_type_ArrayOfDouble = new double[((JSONArray)localObject1).length()];
      i = 0;
      while (i < ((JSONArray)localObject1).length())
      {
        paramString.jdField_b_of_type_ArrayOfDouble[i] = ((JSONArray)localObject1).getDouble(i);
        i += 1;
      }
    }
    localObject1 = localJSONObject.getJSONObject("360balltoastinfo");
    if (localObject1 != null)
    {
      localObject2 = ((JSONObject)localObject1).getJSONArray("360bigscreeninfo");
      if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0))
      {
        paramString.e = new ArrayList();
        i = 0;
        while (i < ((JSONArray)localObject2).length())
        {
          localObject3 = ((JSONArray)localObject2).getJSONObject(i);
          localObject4 = new ARWorldCupVideoInfo.BigScreenShowInfo();
          ((ARWorldCupVideoInfo.BigScreenShowInfo)localObject4).b = ((float)((JSONObject)localObject3).optDouble("scale"));
          ((ARWorldCupVideoInfo.BigScreenShowInfo)localObject4).jdField_a_of_type_Float = ((float)((JSONObject)localObject3).optDouble("endtime"));
          ((ARWorldCupVideoInfo.BigScreenShowInfo)localObject4).c = ((float)((JSONObject)localObject3).optDouble("x"));
          ((ARWorldCupVideoInfo.BigScreenShowInfo)localObject4).d = ((float)((JSONObject)localObject3).optDouble("y"));
          ((ARWorldCupVideoInfo.BigScreenShowInfo)localObject4).e = ((float)((JSONObject)localObject3).optDouble("z"));
          ((ARWorldCupVideoInfo.BigScreenShowInfo)localObject4).f = ((float)((JSONObject)localObject3).optDouble("height"));
          ((ARWorldCupVideoInfo.BigScreenShowInfo)localObject4).g = ((float)((JSONObject)localObject3).optDouble("width"));
          paramString.e.add(localObject4);
          i += 1;
        }
      }
      localObject2 = ((JSONObject)localObject1).getJSONArray("360loopinfo");
      if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0))
      {
        paramString.jdField_a_of_type_JavaUtilList = new ArrayList();
        i = 0;
        while (i < ((JSONArray)localObject2).length())
        {
          localObject3 = ((JSONArray)localObject2).getJSONObject(i);
          localObject4 = new ARWorldCupVideoInfo.PlayGuideShowInfo();
          ((ARWorldCupVideoInfo.PlayGuideShowInfo)localObject4).jdField_a_of_type_Float = ((float)((JSONObject)localObject3).optDouble("starttime"));
          ((ARWorldCupVideoInfo.PlayGuideShowInfo)localObject4).b = ((float)((JSONObject)localObject3).optDouble("endtime"));
          ((ARWorldCupVideoInfo.PlayGuideShowInfo)localObject4).c = ((JSONObject)localObject3).optInt("type");
          ((ARWorldCupVideoInfo.PlayGuideShowInfo)localObject4).jdField_a_of_type_JavaLangString = ((JSONObject)localObject3).optString("text");
          paramString.jdField_a_of_type_JavaUtilList.add(localObject4);
          i += 1;
        }
      }
      localObject2 = ((JSONObject)localObject1).getJSONArray("360senceinfo");
      if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0))
      {
        paramString.jdField_b_of_type_JavaUtilList = new ArrayList();
        i = 0;
        while (i < ((JSONArray)localObject2).length())
        {
          localObject3 = ((JSONArray)localObject2).getJSONObject(i);
          localObject4 = new ARWorldCupVideoInfo.PlayGuideShowInfo();
          ((ARWorldCupVideoInfo.PlayGuideShowInfo)localObject4).jdField_a_of_type_Float = ((float)((JSONObject)localObject3).optDouble("starttime"));
          ((ARWorldCupVideoInfo.PlayGuideShowInfo)localObject4).b = ((float)((JSONObject)localObject3).optDouble("endtime"));
          ((ARWorldCupVideoInfo.PlayGuideShowInfo)localObject4).c = ((JSONObject)localObject3).optInt("type");
          ((ARWorldCupVideoInfo.PlayGuideShowInfo)localObject4).jdField_a_of_type_JavaLangString = ((JSONObject)localObject3).optString("text");
          paramString.jdField_b_of_type_JavaUtilList.add(localObject4);
          i += 1;
        }
      }
      localObject2 = ((JSONObject)localObject1).getJSONArray("getballinfo");
      if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0))
      {
        paramString.c = new ArrayList();
        i = 0;
        while (i < ((JSONArray)localObject2).length())
        {
          localObject3 = ((JSONArray)localObject2).getJSONObject(i);
          localObject4 = new ARWorldCupVideoInfo.PlayGuideShowInfo();
          ((ARWorldCupVideoInfo.PlayGuideShowInfo)localObject4).jdField_a_of_type_Float = ((float)((JSONObject)localObject3).optDouble("starttime"));
          ((ARWorldCupVideoInfo.PlayGuideShowInfo)localObject4).b = ((float)((JSONObject)localObject3).optDouble("endtime"));
          ((ARWorldCupVideoInfo.PlayGuideShowInfo)localObject4).c = ((JSONObject)localObject3).optInt("type");
          ((ARWorldCupVideoInfo.PlayGuideShowInfo)localObject4).jdField_a_of_type_JavaLangString = ((JSONObject)localObject3).optString("text");
          paramString.c.add(localObject4);
          i += 1;
        }
      }
      localObject1 = ((JSONObject)localObject1).getJSONArray("gamechoieinfo");
      if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0))
      {
        paramString.d = new ArrayList();
        i = 0;
        while (i < ((JSONArray)localObject1).length())
        {
          localObject2 = ((JSONArray)localObject1).getJSONObject(i);
          localObject3 = new ARWorldCupVideoInfo.PlayGuideShowInfo();
          ((ARWorldCupVideoInfo.PlayGuideShowInfo)localObject3).jdField_a_of_type_Float = ((float)((JSONObject)localObject2).optDouble("starttime"));
          ((ARWorldCupVideoInfo.PlayGuideShowInfo)localObject3).b = ((float)((JSONObject)localObject2).optDouble("endtime"));
          ((ARWorldCupVideoInfo.PlayGuideShowInfo)localObject3).c = ((JSONObject)localObject2).optInt("type");
          ((ARWorldCupVideoInfo.PlayGuideShowInfo)localObject3).jdField_a_of_type_JavaLangString = ((JSONObject)localObject2).optString("text");
          paramString.d.add(localObject3);
          i += 1;
        }
      }
    }
    if (localJSONObject.has("traversiondoordialog"))
    {
      localObject1 = localJSONObject.getJSONObject("traversiondoordialog");
      if (localObject1 != null)
      {
        localObject2 = new ARWorldCupVideoInfo.BackConfirmDialogInfo();
        ((ARWorldCupVideoInfo.BackConfirmDialogInfo)localObject2).jdField_a_of_type_JavaLangString = ((JSONObject)localObject1).optString("context");
        ((ARWorldCupVideoInfo.BackConfirmDialogInfo)localObject2).b = ((JSONObject)localObject1).optString("back");
        ((ARWorldCupVideoInfo.BackConfirmDialogInfo)localObject2).c = ((JSONObject)localObject1).optString("confirm");
        paramString.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupVideoInfo$BackConfirmDialogInfo = ((ARWorldCupVideoInfo.BackConfirmDialogInfo)localObject2);
      }
    }
    if (localJSONObject.has("gamedialog"))
    {
      localJSONObject = localJSONObject.getJSONObject("gamedialog");
      if (localJSONObject != null)
      {
        localObject1 = new ARWorldCupVideoInfo.BackConfirmDialogInfo();
        ((ARWorldCupVideoInfo.BackConfirmDialogInfo)localObject1).jdField_a_of_type_JavaLangString = localJSONObject.optString("context");
        ((ARWorldCupVideoInfo.BackConfirmDialogInfo)localObject1).b = localJSONObject.optString("back");
        ((ARWorldCupVideoInfo.BackConfirmDialogInfo)localObject1).c = localJSONObject.optString("confirm");
        paramString.jdField_b_of_type_ComTencentMobileqqWorldcupARWorldCupVideoInfo$BackConfirmDialogInfo = ((ARWorldCupVideoInfo.BackConfirmDialogInfo)localObject1);
      }
    }
    return paramString;
  }
  
  private List a(int paramInt)
  {
    switch (paramInt)
    {
    case 5: 
    case 7: 
    default: 
      return null;
    case 4: 
      return this.jdField_b_of_type_JavaUtilList;
    case 6: 
      return this.c;
    }
    return this.d;
  }
  
  public static boolean a(double paramDouble1, double paramDouble2)
  {
    return Math.abs(paramDouble1 - paramDouble2) <= 0.2000000029802322D;
  }
  
  public Vector3 a(long paramLong)
  {
    Object localObject1;
    boolean bool;
    label77:
    Object localObject2;
    if ((paramLong < 0L) || (this.jdField_a_of_type_ArrayOfDouble == null) || (this.jdField_b_of_type_ArrayOfDouble == null))
    {
      localObject1 = new StringBuilder().append("getTranslateByTime:").append(paramLong).append("|");
      if (this.jdField_a_of_type_ArrayOfDouble == null)
      {
        bool = true;
        localObject1 = ((StringBuilder)localObject1).append(bool).append("|");
        if (this.jdField_b_of_type_ArrayOfDouble != null) {
          break label105;
        }
        bool = true;
        QLog.d("ARWorldCupGlobalSceneRenderable_ARWorldCupGameUtilgetTranslateByTime", 1, bool);
        localObject2 = null;
      }
    }
    for (;;)
    {
      return localObject2;
      bool = false;
      break;
      label105:
      bool = false;
      break label77;
      localObject1 = null;
      int i = 0;
      localObject2 = localObject1;
      try
      {
        if (i < this.jdField_b_of_type_ArrayOfDouble.length - 1)
        {
          localObject2 = localObject1;
          if (paramLong > this.jdField_b_of_type_ArrayOfDouble[i])
          {
            localObject2 = localObject1;
            if (paramLong <= this.jdField_b_of_type_ArrayOfDouble[(i + 1)])
            {
              double d1 = (this.jdField_a_of_type_ArrayOfDouble[((i + 1) * 3)] - this.jdField_a_of_type_ArrayOfDouble[(i * 3)]) * (paramLong - this.jdField_b_of_type_ArrayOfDouble[i]) / (this.jdField_b_of_type_ArrayOfDouble[(i + 1)] - this.jdField_b_of_type_ArrayOfDouble[i]);
              double d2 = this.jdField_a_of_type_ArrayOfDouble[(i * 3)];
              double d3 = (this.jdField_a_of_type_ArrayOfDouble[((i + 1) * 3 + 1)] - this.jdField_a_of_type_ArrayOfDouble[(i * 3 + 1)]) * (paramLong - this.jdField_b_of_type_ArrayOfDouble[i]) / (this.jdField_b_of_type_ArrayOfDouble[(i + 1)] - this.jdField_b_of_type_ArrayOfDouble[i]);
              double d4 = this.jdField_a_of_type_ArrayOfDouble[(i * 3 + 1)];
              double d5 = (this.jdField_a_of_type_ArrayOfDouble[((i + 1) * 3 + 2)] - this.jdField_a_of_type_ArrayOfDouble[(i * 3 + 2)]) * (paramLong - this.jdField_b_of_type_ArrayOfDouble[i]) / (this.jdField_b_of_type_ArrayOfDouble[(i + 1)] - this.jdField_b_of_type_ArrayOfDouble[i]);
              double d6 = this.jdField_a_of_type_ArrayOfDouble[(i * 3 + 2)];
              localObject2 = new Vector3();
              ((Vector3)localObject2).set((float)(d5 + d6), (float)(d3 + d4), (float)(d1 + d2));
              QLog.d("ARWorldCupGlobalSceneRenderable_ARWorldCupGameUtilgetTranslateByTime", 1, "getTranslateByTime:" + paramLong + "|" + ((Vector3)localObject2).x + "|" + ((Vector3)localObject2).y + "|" + ((Vector3)localObject2).z);
            }
          }
          i += 1;
          localObject1 = localObject2;
        }
      }
      catch (Exception localException)
      {
        QLog.e("ARWorldCupGlobalSceneRenderable_ARWorldCupGameUtil", 1, String.format("getTranslateByTime, Exception\n%s", new Object[] { localException }));
      }
    }
    return null;
  }
  
  public ARWorldCupVideoInfo.BackConfirmDialogInfo a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupVideoInfo$BackConfirmDialogInfo;
    }
    return this.jdField_b_of_type_ComTencentMobileqqWorldcupARWorldCupVideoInfo$BackConfirmDialogInfo;
  }
  
  public ARWorldCupVideoInfo.BigScreenShowInfo a()
  {
    if ((this.e == null) || (this.e.size() <= 0)) {
      return null;
    }
    return (ARWorldCupVideoInfo.BigScreenShowInfo)this.e.get(0);
  }
  
  public ARWorldCupVideoInfo.PlayGuideShowInfo a(float paramFloat)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return null;
    }
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilList.size()) {
      if (!a(((ARWorldCupVideoInfo.PlayGuideShowInfo)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_Float, paramFloat)) {}
    }
    for (ARWorldCupVideoInfo.PlayGuideShowInfo localPlayGuideShowInfo = (ARWorldCupVideoInfo.PlayGuideShowInfo)this.jdField_a_of_type_JavaUtilList.get(i);; localPlayGuideShowInfo = null)
    {
      return localPlayGuideShowInfo;
      i += 1;
      break;
    }
  }
  
  public ARWorldCupVideoInfo.PlayGuideShowInfo a(long paramLong, int paramInt)
  {
    Object localObject = a(paramInt);
    if (localObject == null) {
      return null;
    }
    paramInt = 0;
    if (paramInt < ((List)localObject).size()) {
      if (!a(((ARWorldCupVideoInfo.PlayGuideShowInfo)((List)localObject).get(paramInt)).jdField_a_of_type_Float, paramLong / 1000.0D)) {}
    }
    for (localObject = (ARWorldCupVideoInfo.PlayGuideShowInfo)((List)localObject).get(paramInt);; localObject = null)
    {
      return localObject;
      paramInt += 1;
      break;
    }
  }
  
  public double[] a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilMap == null) {
      return null;
    }
    Object localObject;
    switch (paramInt)
    {
    default: 
      localObject = null;
    }
    while ((localObject != null) && (this.jdField_a_of_type_JavaUtilMap.containsKey(localObject)))
    {
      return (double[])this.jdField_a_of_type_JavaUtilMap.get(localObject);
      localObject = "game_center_00";
      continue;
      localObject = "game_left_00";
      continue;
      localObject = "game_right_00";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.worldcup.ARWorldCupVideoInfo
 * JD-Core Version:    0.7.0.1
 */