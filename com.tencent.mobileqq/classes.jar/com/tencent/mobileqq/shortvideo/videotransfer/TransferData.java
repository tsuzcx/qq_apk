package com.tencent.mobileqq.shortvideo.videotransfer;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class TransferData
{
  private long jdField_a_of_type_Long = -10L;
  public TransferConfig.ConfigData a;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public TransferData()
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoVideotransferTransferConfig$ConfigData = new TransferConfig.ConfigData();
    a(null);
    a(null);
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public String a()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)) {}
    while (!this.jdField_a_of_type_ComTencentMobileqqShortvideoVideotransferTransferConfig$ConfigData.a()) {
      return null;
    }
    JSONArray localJSONArray;
    String str;
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("config_data", this.jdField_a_of_type_ComTencentMobileqqShortvideoVideotransferTransferConfig$ConfigData.a());
      localJSONObject.put("reverse_shift", this.jdField_a_of_type_Long);
      localJSONArray = new JSONArray();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        localJSONArray.put((Long)localIterator.next());
        continue;
        return str;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      str = null;
    }
    for (;;)
    {
      str.put("pos_list", localJSONArray);
      str = str.toString();
    }
  }
  
  public ArrayList a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(TransferConfig.ConfigData paramConfigData)
  {
    if (paramConfigData != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoVideotransferTransferConfig$ConfigData.jdField_a_of_type_Int = paramConfigData.jdField_a_of_type_Int;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoVideotransferTransferConfig$ConfigData.jdField_a_of_type_JavaLangString = paramConfigData.jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoVideotransferTransferConfig$ConfigData.b = paramConfigData.b;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoVideotransferTransferConfig$ConfigData.jdField_a_of_type_Long = paramConfigData.jdField_a_of_type_Long;
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoVideotransferTransferConfig$ConfigData.jdField_a_of_type_Int = -1;
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      paramString = new JSONObject(paramString);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoVideotransferTransferConfig$ConfigData.a(paramString.optString("config_data"));
      JSONArray localJSONArray = paramString.optJSONArray("pos_list");
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      if ((localJSONArray != null) && (localJSONArray.length() > 0))
      {
        int i = 0;
        while (i < localJSONArray.length())
        {
          this.jdField_a_of_type_JavaUtilArrayList.add(Long.valueOf(localJSONArray.getLong(i)));
          i += 1;
        }
      }
      this.jdField_a_of_type_Long = paramString.optLong("reverse_shift");
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void a(ArrayList paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
      Collections.sort(this.jdField_a_of_type_JavaUtilArrayList);
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.videotransfer.TransferData
 * JD-Core Version:    0.7.0.1
 */