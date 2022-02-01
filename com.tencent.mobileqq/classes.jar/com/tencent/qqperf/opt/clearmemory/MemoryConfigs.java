package com.tencent.qqperf.opt.clearmemory;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.MagnifierSDK;
import com.tencent.qqperf.monitor.base.IAPMModuleCelling;
import java.util.Random;
import mqq.app.MobileQQ;

public class MemoryConfigs
{
  public float a;
  public int a;
  public long a;
  public ClearMemoryConfig a;
  public String a;
  public boolean a;
  public float b;
  public long b;
  private String b;
  public boolean b;
  public float c;
  public boolean c;
  public float d;
  public boolean d;
  public boolean e = true;
  
  public MemoryConfigs()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Float = 0.0F;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 15;
    this.jdField_a_of_type_Long = 900000L;
    this.jdField_b_of_type_Float = 1.1F;
    this.jdField_c_of_type_Float = 1.1F;
    this.jdField_b_of_type_JavaLangString = "key_heap_level_AB_ramdom";
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_d_of_type_Float = -1.0F;
    this.jdField_b_of_type_Long = -1L;
    Object localObject = MagnifierSDK.a().a().b();
    this.jdField_a_of_type_ComTencentQqperfOptClearmemoryClearMemoryConfig = new ClearMemoryConfig("-1");
    this.jdField_a_of_type_ComTencentQqperfOptClearmemoryClearMemoryConfig.jdField_a_of_type_Boolean = true;
    a();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      if (((String)localObject).equals("0")) {
        return;
      }
      localObject = ((String)localObject).split("_");
      if (localObject.length > 1) {
        localObject = localObject[(((com.tencent.mobileqq.dpc.api.IDPCApi)com.tencent.mobileqq.qroute.QRoute.api(com.tencent.mobileqq.dpc.api.IDPCApi.class)).getAbRamdom() % localObject.length)];
      } else {
        localObject = localObject[0];
      }
      try
      {
        localObject = ((String)localObject).split("\\|");
        if (localObject.length < 7) {
          return;
        }
        arrayOfString = localObject[1].split(";");
        if (arrayOfString[0].equals("1"))
        {
          this.jdField_a_of_type_Boolean = true;
          this.jdField_a_of_type_Int = Integer.parseInt(arrayOfString[1]);
          if (this.jdField_a_of_type_Int > 50) {
            this.jdField_a_of_type_Int = 50;
          }
          if (this.jdField_a_of_type_Int < 1) {
            this.jdField_a_of_type_Int = 1;
          }
        }
        this.jdField_a_of_type_JavaLangString = localObject[2];
      }
      catch (Exception localException1)
      {
        String[] arrayOfString;
        label292:
        if (QLog.isColorLevel()) {
          QLog.d("Q.Memory.MemoryConfigs", 2, "parseDpc err", localException1);
        }
      }
    }
    try
    {
      this.jdField_a_of_type_Float = Float.valueOf(localObject[4]).floatValue();
      if (this.jdField_a_of_type_Float <= 1.0F) {
        break label297;
      }
      this.jdField_a_of_type_Float = 1.0F;
    }
    catch (Exception localException2)
    {
      break label292;
    }
    this.jdField_a_of_type_Float = 0.0F;
    try
    {
      label297:
      this.jdField_b_of_type_Float = Float.parseFloat(localObject[6]);
    }
    catch (Exception localException3)
    {
      label311:
      break label311;
    }
    this.jdField_b_of_type_Float = 0.001F;
    if (localObject.length >= 9) {
      a((String[])localObject);
    }
    if (localObject.length >= 10) {
      if ("1".equalsIgnoreCase(localObject[9])) {
        this.e = true;
      } else {
        this.e = false;
      }
    }
    if (localObject.length >= 11)
    {
      arrayOfString = localObject[10].split(";");
      if (arrayOfString.length >= 2)
      {
        this.jdField_d_of_type_Float = Float.parseFloat(arrayOfString[0]);
        this.jdField_b_of_type_Long = Long.parseLong(arrayOfString[1]);
      }
    }
    b((String[])localObject);
    return;
  }
  
  private void a()
  {
    Object localObject = MobileQQ.getContext().getSharedPreferences("MemoryManagerMemoryStat", 4);
    if (((SharedPreferences)localObject).getInt(this.jdField_b_of_type_JavaLangString, -1) == -1)
    {
      int i = new Random().nextInt(1000);
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putInt(this.jdField_b_of_type_JavaLangString, i);
      if (Build.VERSION.SDK_INT < 9) {
        ((SharedPreferences.Editor)localObject).commit();
      } else {
        ((SharedPreferences.Editor)localObject).apply();
      }
    }
    boolean bool;
    if (0.001F >= Math.random()) {
      bool = true;
    } else {
      bool = false;
    }
    this.jdField_c_of_type_Boolean = bool;
  }
  
  private void a(String[] paramArrayOfString)
  {
    try
    {
      paramArrayOfString = paramArrayOfString[8].split(";");
      if (paramArrayOfString.length >= 5)
      {
        if (this.jdField_a_of_type_ComTencentQqperfOptClearmemoryClearMemoryConfig == null) {
          this.jdField_a_of_type_ComTencentQqperfOptClearmemoryClearMemoryConfig = new ClearMemoryConfig(this.jdField_a_of_type_JavaLangString);
        } else {
          this.jdField_a_of_type_ComTencentQqperfOptClearmemoryClearMemoryConfig.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
        }
        if (paramArrayOfString[0].equals("1")) {
          this.jdField_a_of_type_ComTencentQqperfOptClearmemoryClearMemoryConfig.jdField_a_of_type_Boolean = true;
        } else if (paramArrayOfString[0].equals("0")) {
          this.jdField_a_of_type_ComTencentQqperfOptClearmemoryClearMemoryConfig.jdField_a_of_type_Boolean = false;
        } else if (MobileQQ.sProcessId == 1) {
          this.jdField_a_of_type_ComTencentQqperfOptClearmemoryClearMemoryConfig.jdField_a_of_type_Boolean = true;
        } else if (paramArrayOfString[0].equals("3")) {
          this.jdField_a_of_type_ComTencentQqperfOptClearmemoryClearMemoryConfig.jdField_a_of_type_Boolean = true;
        } else if (paramArrayOfString[0].equals("4")) {
          this.jdField_a_of_type_ComTencentQqperfOptClearmemoryClearMemoryConfig.jdField_a_of_type_Boolean = false;
        } else {
          this.jdField_a_of_type_ComTencentQqperfOptClearmemoryClearMemoryConfig.jdField_a_of_type_Boolean = true;
        }
        this.jdField_a_of_type_ComTencentQqperfOptClearmemoryClearMemoryConfig.b = Integer.parseInt(paramArrayOfString[1]);
        Object localObject = paramArrayOfString[2].split(",");
        if (localObject.length >= 4)
        {
          localObject = new ClearMemoryConfig.MemoryLevelInfo(Integer.parseInt(localObject[0]), Integer.parseInt(localObject[1]), Float.parseFloat(localObject[2]), Float.parseFloat(localObject[3]));
          this.jdField_a_of_type_ComTencentQqperfOptClearmemoryClearMemoryConfig.jdField_a_of_type_AndroidUtilSparseArray.put(1, localObject);
        }
        localObject = paramArrayOfString[3].split(",");
        if (localObject.length >= 4)
        {
          localObject = new ClearMemoryConfig.MemoryLevelInfo(Integer.parseInt(localObject[0]), Integer.parseInt(localObject[1]), Float.parseFloat(localObject[2]), Float.parseFloat(localObject[3]));
          this.jdField_a_of_type_ComTencentQqperfOptClearmemoryClearMemoryConfig.jdField_a_of_type_AndroidUtilSparseArray.put(2, localObject);
        }
        paramArrayOfString = paramArrayOfString[4].split(",");
        if (paramArrayOfString.length >= 4)
        {
          paramArrayOfString = new ClearMemoryConfig.MemoryLevelInfo(Integer.parseInt(paramArrayOfString[0]), Integer.parseInt(paramArrayOfString[1]), Float.parseFloat(paramArrayOfString[2]), Float.parseFloat(paramArrayOfString[3]));
          this.jdField_a_of_type_ComTencentQqperfOptClearmemoryClearMemoryConfig.jdField_a_of_type_AndroidUtilSparseArray.put(3, paramArrayOfString);
        }
        if (QLog.isColorLevel())
        {
          paramArrayOfString = new StringBuilder();
          paramArrayOfString.append("mClearMemoryConfig= ");
          paramArrayOfString.append(this.jdField_a_of_type_ComTencentQqperfOptClearmemoryClearMemoryConfig);
          QLog.d("Q.Memory.MemoryConfigs", 2, paramArrayOfString.toString());
          return;
        }
      }
    }
    catch (Exception paramArrayOfString)
    {
      paramArrayOfString.printStackTrace();
    }
  }
  
  private void b(String[] paramArrayOfString)
  {
    if (paramArrayOfString.length >= 12)
    {
      if ("1".equalsIgnoreCase(paramArrayOfString[11]))
      {
        this.jdField_d_of_type_Boolean = true;
        return;
      }
      this.jdField_d_of_type_Boolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqperf.opt.clearmemory.MemoryConfigs
 * JD-Core Version:    0.7.0.1
 */