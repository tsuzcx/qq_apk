import android.content.Context;
import android.media.AudioManager;
import com.tencent.av.VideoController;
import com.tencent.av.ui.VideoLayerUIBase;
import com.tencent.qphone.base.util.QLog;

public class mtq
{
  static boolean a;
  static boolean b;
  static boolean c;
  static boolean d;
  
  static String a(lid paramlid)
  {
    if (VideoLayerUIBase.a(paramlid)) {
      return paramlid.jdField_d_of_type_JavaLangString;
    }
    if (VideoLayerUIBase.b(paramlid)) {
      return String.valueOf(paramlid.jdField_g_of_type_Long);
    }
    if (QLog.isDevelopLevel()) {
      QLog.w("DataReport", 1, "getUin, error, sessionInfo[" + paramlid + "]");
    }
    return paramlid.jdField_d_of_type_JavaLangString;
  }
  
  public static void a()
  {
    azqs.b(null, "CliOper", "", "", "0X8004AD0", "0X8004AD0", 0, 0, "", "", "", "");
  }
  
  public static void a(int paramInt)
  {
    String str1 = "";
    String str2 = "";
    switch (paramInt)
    {
    }
    for (;;)
    {
      azqs.b(null, "CliOper", "", "", str1, str2, 0, 0, "", "", "", "");
      return;
      str1 = "0X8004E22";
      str2 = "0X8004E22";
      continue;
      str1 = "0X8004E21";
      str2 = "0X8004E21";
      continue;
      str1 = "0X8004E1F";
      str2 = "0X8004E1F";
      continue;
      str1 = "0X8004E20";
      str2 = "0X8004E20";
    }
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    int i = 1;
    String str1 = "";
    label25:
    String str2;
    if (paramInt2 == 1)
    {
      paramInt2 = i;
      if (paramInt1 != 2131372581) {
        break label75;
      }
      if (paramInt2 == 0) {
        break label62;
      }
      str1 = "0X8004E23";
      if (paramInt2 == 0) {
        break label68;
      }
      str2 = "0X8004E23";
    }
    for (;;)
    {
      azqs.b(null, "CliOper", "", "", str1, str2, 0, 0, "", "", "", "");
      return;
      paramInt2 = 0;
      break;
      label62:
      str1 = "0X80043C5";
      break label25;
      label68:
      str2 = "0X80043C5";
      continue;
      label75:
      if (paramInt1 == 2131372583)
      {
        if (paramInt2 != 0)
        {
          str1 = "0X8004368";
          label88:
          if (paramInt2 == 0) {
            break label105;
          }
        }
        label105:
        for (str2 = "0X8004368";; str2 = "0X8004450")
        {
          break;
          str1 = "0X8004450";
          break label88;
        }
      }
      str2 = "";
    }
  }
  
  public static void a(VideoController paramVideoController)
  {
    if (paramVideoController == null) {}
    int i;
    do
    {
      return;
      i = paramVideoController.a().jdField_d_of_type_Int;
      if (i == 1)
      {
        if (paramVideoController.a().k())
        {
          azqs.b(null, "CliOper", "", "", "0X800436B", "0X800436B", 0, 0, "", "", "", "");
          return;
        }
        azqs.b(null, "CliOper", "", "", "0X800434C", "0X800434C", 0, 0, String.valueOf(muz.a(paramVideoController.a())), "", "", "");
        return;
      }
    } while (i != 2);
    if (paramVideoController.a().k())
    {
      azqs.b(null, "CliOper", "", "", "0X80043CB", "0X80043CB", 0, 0, "", "", "", "");
      return;
    }
    azqs.b(null, "CliOper", "", "", "0X80043B7", "0X80043B7", 0, 0, String.valueOf(muz.a(paramVideoController.a())), "", "", "");
  }
  
  public static void a(VideoController paramVideoController, boolean paramBoolean)
  {
    if (paramVideoController == null) {}
    for (;;)
    {
      return;
      int i = paramVideoController.a().jdField_d_of_type_Int;
      if (i == 1) {
        if (paramVideoController.a().k()) {
          if (paramBoolean) {
            azqs.b(null, "CliOper", "", "", "0X8004373", "0X8004373", 0, 0, "", "", "", "");
          }
        }
      }
      while (paramVideoController.a().i == 1008)
      {
        if (!paramBoolean) {
          break label314;
        }
        azqs.b(null, "CliOper", "", "", "0X8005DA8", "0X8005DA8", 0, 0, "", "", "", "");
        return;
        azqs.b(null, "CliOper", "", "", "0X8004378", "0X8004378", 0, 0, "", "", "", "");
        continue;
        if (paramBoolean)
        {
          azqs.b(null, "CliOper", "", "", "0X800434F", "0X800434F", 0, 0, "", "", "", "");
        }
        else
        {
          azqs.b(null, "CliOper", "", "", "0X8004350", "0X8004350", 0, 0, "", "", "", "");
          continue;
          if (i == 2) {
            if (paramVideoController.a().k())
            {
              if (paramBoolean) {
                azqs.b(null, "CliOper", "", "", "0X80043D3", "0X80043D3", 0, 0, "", "", "", "");
              } else {
                azqs.b(null, "CliOper", "", "", "0X80043D4", "0X80043D4", 0, 0, "", "", "", "");
              }
            }
            else if (paramBoolean) {
              azqs.b(null, "CliOper", "", "", "0X80043BA", "0X80043BA", 0, 0, "", "", "", "");
            } else {
              azqs.b(null, "CliOper", "", "", "0X80043BB", "0X80043BB", 0, 0, "", "", "", "");
            }
          }
        }
      }
    }
    label314:
    azqs.b(null, "CliOper", "", "", "0X8005DAA", "0X8005DAA", 0, 0, "", "", "", "");
  }
  
  public static void a(String paramString)
  {
    azqs.b(null, "dc00898", "", "", "0X800A2CD", "0X800A2CD", VideoController.a().a().jdField_d_of_type_Int, 0, paramString, "", "", "");
  }
  
  static void a(String paramString, int paramInt)
  {
    azqs.b(null, "dc00898", "", "", paramString, paramString, paramInt, 0, "", "", "", "");
  }
  
  public static void a(boolean paramBoolean)
  {
    String str1;
    if (paramBoolean)
    {
      str1 = "0X80049A8";
      if (!paramBoolean) {
        break label43;
      }
    }
    label43:
    for (String str2 = "0X80049A8";; str2 = "0X80049B8")
    {
      azqs.b(null, "CliOper", "", "", str1, str2, 0, 0, "", "", "", "");
      return;
      str1 = "0X80049B8";
      break;
    }
  }
  
  public static void a(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean) {
      if (paramInt == 10) {
        azqs.b(null, "CliOper", "", "", "0X800592B", "0X800592B", 0, 0, "", "", "", "");
      }
    }
    do
    {
      do
      {
        return;
        if (paramInt == 2)
        {
          azqs.b(null, "CliOper", "", "", "0X80046D1", "0X80046D1", 0, 0, "", "", "", "");
          return;
        }
      } while (paramInt != 1);
      azqs.b(null, "CliOper", "", "", "0X8004CE7", "0X8004CE7", 0, 0, "", "", "", "");
      return;
      if (paramInt == 10)
      {
        azqs.b(null, "CliOper", "", "", "0X800592C", "0X800592C", 0, 0, "", "", "", "");
        return;
      }
      if (paramInt == 2)
      {
        azqs.b(null, "CliOper", "", "", "0X80046D2", "0X80046D2", 0, 0, "", "", "", "");
        return;
      }
    } while (paramInt != 1);
    azqs.b(null, "CliOper", "", "", "0X8004CE6", "0X8004CE6", 0, 0, "", "", "", "");
  }
  
  public static void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    String str1;
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        str1 = "0X80049A2";
        if (!paramBoolean2) {
          break label47;
        }
      }
      label47:
      for (str2 = "0X80049A2";; str2 = "0X80049B1")
      {
        azqs.b(null, "CliOper", "", "", str1, str2, 0, 0, "", "", "", "");
        return;
        str1 = "0X80049B1";
        break;
      }
    }
    if (paramBoolean2)
    {
      str1 = "0X800499F";
      label60:
      if (!paramBoolean2) {
        break label76;
      }
    }
    label76:
    for (String str2 = "0X800499F";; str2 = "0X80049AE")
    {
      break;
      str1 = "0X80049AE";
      break label60;
    }
  }
  
  public static void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if (paramInt == 1) {
      if (paramBoolean2) {
        azqs.b(null, "CliOper", "", "", "0X80041B9", "0X80041B9", 0, 0, "", "", "", "");
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          azqs.b(null, "CliOper", "", "", "0X80041BC", "0X80041BC", 0, 0, "", "", "", "");
          return;
          if (paramInt != 10) {
            break;
          }
          if ((paramBoolean1) && (!paramBoolean2)) {
            azqs.b(null, "CliOper", "", "", "0X800593F", "0X800593F", 0, 0, "", "", "", "");
          }
        } while (!paramBoolean2);
        azqs.b(null, "CliOper", "", "", "0X800593C", "0X800593C", 0, 0, "", "", "", "");
        return;
      } while (paramInt != 2);
      if ((paramBoolean1) && (!paramBoolean2)) {
        azqs.b(null, "CliOper", "", "", "0X80046E9", "0X80046E9", 0, 0, "", "", "", "");
      }
    } while (!paramBoolean2);
    azqs.b(null, "CliOper", "", "", "0X80046E6", "0X80046E6", 0, 0, "", "", "", "");
  }
  
  public static void b()
  {
    azqs.b(null, "CliOper", "", "", "0X8004AD1", "0X8004AD1", 0, 0, "", "", "", "");
  }
  
  public static void b(int paramInt)
  {
    if (paramInt == 2) {
      azqs.b(null, "CliOper", "", "", "0X8004F5E", "0X8004F5E", 0, 0, "", "", "", "");
    }
    do
    {
      return;
      if (paramInt == 10)
      {
        azqs.b(null, "CliOper", "", "", "0X800594C", "0X800594C", 0, 0, "", "", "", "");
        return;
      }
    } while (paramInt != 1);
    azqs.b(null, "CliOper", "", "", "0X8004CFA", "0X8004CFA", 0, 0, "", "", "", "");
  }
  
  public static void b(int paramInt1, int paramInt2)
  {
    switch (paramInt2)
    {
    }
    do
    {
      do
      {
        return;
        if (paramInt1 == 1)
        {
          azqs.b(null, "CliOper", "", "", "0X800442A", "0X800442A", 0, 0, "", "", "", "");
          return;
        }
      } while (paramInt1 != 2);
      azqs.b(null, "CliOper", "", "", "0X800442B", "0X800442B", 0, 0, "", "", "", "");
      return;
      if (paramInt1 == 1)
      {
        azqs.b(null, "CliOper", "", "", "0X8004429", "0X8004429", 0, 0, "", "", "", "");
        return;
      }
    } while (paramInt1 != 2);
    azqs.b(null, "CliOper", "", "", "0X800442C", "0X800442C", 0, 0, "", "", "", "");
  }
  
  public static void b(VideoController paramVideoController)
  {
    if (paramVideoController == null) {}
    int i;
    do
    {
      return;
      i = paramVideoController.a().jdField_d_of_type_Int;
      if (i == 1)
      {
        if (paramVideoController.a().k())
        {
          azqs.b(null, "CliOper", "", "", "0X800436C", "0X800436C", 0, 0, "", "", "", "");
          return;
        }
        azqs.b(null, "CliOper", "", "", "0X800434D", "0X800434D", 0, 0, "", "", "", "");
        return;
      }
    } while (i != 2);
    if (paramVideoController.a().k())
    {
      azqs.b(null, "CliOper", "", "", "0X80043CC", "0X80043CC", 0, 0, "", "", "", "");
      return;
    }
    azqs.b(null, "CliOper", "", "", "0X80043B8", "0X80043B8", 0, 0, "", "", "", "");
  }
  
  public static void b(VideoController paramVideoController, boolean paramBoolean)
  {
    if ((paramVideoController == null) || (paramVideoController.a().jdField_e_of_type_Long == 0L)) {
      return;
    }
    Object localObject1 = paramVideoController.a();
    int j = paramVideoController.a().B;
    AudioManager localAudioManager = (AudioManager)((Context)localObject1).getSystemService("audio");
    int i = localAudioManager.getStreamVolume(j);
    j = localAudioManager.getStreamMaxVolume(j);
    i = (int)(i / j * 100.0F);
    if (i < 30) {
      i = 1;
    }
    for (;;)
    {
      label75:
      localObject1 = paramVideoController.a().q;
      String str;
      label99:
      Object localObject2;
      if ("DEVICE_EARPHONE".equals(localObject1))
      {
        str = "0";
        j = paramVideoController.a().jdField_d_of_type_Int;
        if (j != 1) {
          break label408;
        }
        switch (i)
        {
        default: 
          localObject1 = null;
          label143:
          localObject2 = localObject1;
          if (paramBoolean)
          {
            localObject2 = localObject1;
            if (paramVideoController.a().jdField_e_of_type_Boolean) {
              if (localAudioManager.isBluetoothA2dpOn())
              {
                str = "3";
                paramVideoController = (VideoController)localObject1;
                localObject1 = str;
              }
            }
          }
          break;
        }
      }
      while ((paramVideoController != null) && (localObject1 != null))
      {
        azqs.b(null, "CliOper", "", "", paramVideoController, paramVideoController, 0, 0, (String)localObject1, "", "", "");
        return;
        if ((i >= 30) && (i <= 70))
        {
          i = 2;
          break label75;
        }
        if (i <= 70) {
          break label605;
        }
        i = 3;
        break label75;
        if ("DEVICE_SPEAKERPHONE".equals(localObject1))
        {
          str = "1";
          break label99;
        }
        if ("DEVICE_WIREDHEADSET".equals(localObject1))
        {
          str = "2";
          break label99;
        }
        if ("DEVICE_BLUETOOTHHEADSET".equals(localObject1))
        {
          str = "3";
          break label99;
        }
        str = "4";
        break label99;
        if (paramBoolean)
        {
          localObject1 = "0X800437B";
          break label143;
        }
        localObject1 = "0X800437E";
        break label143;
        if (paramBoolean)
        {
          localObject1 = "0X800437C";
          break label143;
        }
        localObject1 = "0X800437F";
        break label143;
        if (paramBoolean)
        {
          localObject1 = "0X800437D";
          break label143;
        }
        localObject1 = "0X8004380";
        break label143;
        if (localAudioManager.isWiredHeadsetOn())
        {
          str = "2";
          paramVideoController = (VideoController)localObject1;
          localObject1 = str;
        }
        else
        {
          str = "0";
          paramVideoController = (VideoController)localObject1;
          localObject1 = str;
          continue;
          label408:
          if (j == 2)
          {
            switch (i)
            {
            default: 
              localObject1 = null;
            }
            for (;;)
            {
              localObject2 = localObject1;
              if (!paramBoolean) {
                break label586;
              }
              localObject2 = localObject1;
              if (!paramVideoController.a().jdField_e_of_type_Boolean) {
                break label586;
              }
              if (!localAudioManager.isBluetoothA2dpOn()) {
                break label548;
              }
              str = "3";
              paramVideoController = (VideoController)localObject1;
              localObject1 = str;
              break;
              if (paramBoolean)
              {
                localObject1 = "0X80043D6";
              }
              else
              {
                localObject1 = "0X80043D9";
                continue;
                if (paramBoolean)
                {
                  localObject1 = "0X80043D7";
                }
                else
                {
                  localObject1 = "0X80043DA";
                  continue;
                  if (paramBoolean) {
                    localObject1 = "0X80043D8";
                  } else {
                    localObject1 = "0X80043DB";
                  }
                }
              }
            }
            label548:
            if (localAudioManager.isWiredHeadsetOn())
            {
              str = "2";
              paramVideoController = (VideoController)localObject1;
              localObject1 = str;
            }
            else
            {
              str = "1";
              paramVideoController = (VideoController)localObject1;
              localObject1 = str;
              continue;
              label586:
              localObject1 = str;
              paramVideoController = localObject2;
            }
          }
          else
          {
            localObject1 = str;
            paramVideoController = null;
          }
        }
      }
      label605:
      i = 0;
    }
  }
  
  static void b(String paramString)
  {
    azqs.b(null, "dc00898", "", "", paramString, paramString, 0, 0, "", "", "", "");
  }
  
  public static void b(boolean paramBoolean)
  {
    String str1;
    if (paramBoolean)
    {
      str1 = "0X80049A9";
      if (!paramBoolean) {
        break label46;
      }
    }
    label46:
    for (String str2 = "0X80049A9";; str2 = "0X80049B9")
    {
      azqs.b(null, "CliOper", "", "", str1, str2, 0, 0, "", "", "", "");
      return;
      str1 = "0X80049B9";
      break;
    }
  }
  
  public static void b(boolean paramBoolean, int paramInt)
  {
    if (paramInt == 1) {
      if (paramBoolean) {
        azqs.b(null, "CliOper", "", "", "0X8004CF9", "0X8004CF9", 0, 0, "", "", "", "");
      }
    }
    do
    {
      return;
      azqs.b(null, "CliOper", "", "", "0X8004CF5", "0X8004CF5", 0, 0, "", "", "", "");
      return;
      if (paramInt == 10)
      {
        if (paramBoolean)
        {
          azqs.b(null, "CliOper", "", "", "0X800594B", "0X800594B", 0, 0, "", "", "", "");
          return;
        }
        azqs.b(null, "CliOper", "", "", "0X8005947", "0X8005947", 0, 0, "", "", "", "");
        return;
      }
    } while (paramInt != 2);
    if (paramBoolean)
    {
      azqs.b(null, "CliOper", "", "", "0X8004F5D", "0X8004F5D", 0, 0, "", "", "", "");
      return;
    }
    azqs.b(null, "CliOper", "", "", "0X8004F59", "0X8004F59", 0, 0, "", "", "", "");
  }
  
  public static void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    String str1;
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        str1 = "0X80049A3";
        if (!paramBoolean2) {
          break label50;
        }
      }
      label50:
      for (str2 = "0X80049A3";; str2 = "0X80049B2")
      {
        azqs.b(null, "CliOper", "", "", str1, str2, 0, 0, "", "", "", "");
        return;
        str1 = "0X80049B2";
        break;
      }
    }
    if (paramBoolean2)
    {
      str1 = "0X80049A0";
      label65:
      if (!paramBoolean2) {
        break label83;
      }
    }
    label83:
    for (String str2 = "0X80049A0";; str2 = "0X80049AF")
    {
      break;
      str1 = "0X80049AF";
      break label65;
    }
  }
  
  public static void b(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if (paramInt == 1) {
      if (paramBoolean2) {
        azqs.b(null, "CliOper", "", "", "0x80041BA", "0x80041BA", 0, 0, "", "", "", "");
      }
    }
    do
    {
      do
      {
        return;
        azqs.b(null, "CliOper", "", "", "0x80041BD", "0x80041BD", 0, 0, "", "", "", "");
        return;
      } while (paramInt != 10);
      if ((paramBoolean1) && (!paramBoolean2)) {
        azqs.b(null, "CliOper", "", "", "0x8005940", "0x8005940", 0, 0, "", "", "", "");
      }
    } while (!paramBoolean2);
    azqs.b(null, "CliOper", "", "", "0x800593D", "0x800593D", 0, 0, "", "", "", "");
  }
  
  public static void c()
  {
    azqs.b(null, "CliOper", "", "", "0X8004E1A", "0X8004E1A", 0, 0, "", "", "", "");
  }
  
  public static void c(int paramInt)
  {
    int i = VideoController.a().a().jdField_d_of_type_Int;
    String str;
    switch (paramInt)
    {
    default: 
      return;
    case 2131372899: 
      str = "0X800A154";
    }
    for (;;)
    {
      azqs.b(null, "dc00898", "", "", str, str, i, 0, "", "", "", "");
      return;
      str = "0X800A154";
      continue;
      str = "0X800A155";
      continue;
      str = "0X800A156";
      continue;
      str = "0X800A157";
      continue;
      str = "0X800A158";
      continue;
      str = "0X800A15A";
      continue;
      str = "0X800A15B";
      continue;
      str = "0X800A15C";
      continue;
      str = "0X800A15D";
      continue;
      str = "0X800A159";
    }
  }
  
  public static void c(VideoController paramVideoController)
  {
    if (paramVideoController == null) {}
    int i;
    do
    {
      return;
      i = paramVideoController.a().jdField_d_of_type_Int;
      if (i == 1)
      {
        if (paramVideoController.a().k())
        {
          if (paramVideoController.a().jdField_g_of_type_Boolean)
          {
            azqs.b(null, "CliOper", "", "", "0X8004381", "0X8004381", 0, 0, "", "", "", "");
            return;
          }
          azqs.b(null, "CliOper", "", "", "0X8004382", "0X8004382", 0, 0, "", "", "", "");
          return;
        }
        if (paramVideoController.a().jdField_g_of_type_Boolean)
        {
          azqs.b(null, "CliOper", "", "", "0X8004353", "0X8004353", 0, 0, "", "", "", "");
          return;
        }
        azqs.b(null, "CliOper", "", "", "0X8004354", "0X8004354", 0, 0, "", "", "", "");
        return;
      }
    } while (i != 2);
    if (paramVideoController.a().k())
    {
      if (paramVideoController.a().jdField_g_of_type_Boolean)
      {
        azqs.b(null, "CliOper", "", "", "0X80043DC", "0X80043DC", 0, 0, "", "", "", "");
        return;
      }
      azqs.b(null, "CliOper", "", "", "0X80043DD", "0X80043DD", 0, 0, "", "", "", "");
      return;
    }
    if (paramVideoController.a().jdField_g_of_type_Boolean)
    {
      azqs.b(null, "CliOper", "", "", "0X80043BE", "0X80043BE", 0, 0, "", "", "", "");
      return;
    }
    azqs.b(null, "CliOper", "", "", "0X80043BF", "0X80043BF", 0, 0, "", "", "", "");
  }
  
  public static void c(VideoController paramVideoController, boolean paramBoolean)
  {
    if (paramVideoController == null) {}
    label172:
    do
    {
      do
      {
        int i;
        do
        {
          do
          {
            do
            {
              return;
              i = paramVideoController.a().jdField_d_of_type_Int;
              if (i != 1) {
                break label172;
              }
              if (!paramBoolean) {
                break;
              }
            } while (paramVideoController.a().jdField_e_of_type_Boolean);
            if (paramVideoController.a().jdField_g_of_type_Boolean)
            {
              azqs.b(null, "CliOper", "", "", "0X8004356", "0X8004356", 0, 0, "", "", "", "");
              return;
            }
            azqs.b(null, "CliOper", "", "", "0X8004355", "0X8004355", 0, 0, "", "", "", "");
            return;
          } while (paramVideoController.a().jdField_e_of_type_Long <= 0L);
          if (paramVideoController.a().jdField_g_of_type_Boolean)
          {
            azqs.b(null, "CliOper", "", "", "0X8004384", "0X8004384", 0, 0, "", "", "", "");
            return;
          }
          azqs.b(null, "CliOper", "", "", "0X8004383", "0X8004383", 0, 0, "", "", "", "");
          return;
        } while (i != 2);
        if (!paramBoolean) {
          break;
        }
      } while (paramVideoController.a().jdField_e_of_type_Boolean);
      if (paramVideoController.a().jdField_g_of_type_Boolean)
      {
        azqs.b(null, "CliOper", "", "", "0X80043C1", "0X80043C1", 0, 0, "", "", "", "");
        return;
      }
      azqs.b(null, "CliOper", "", "", "0X80043C0", "0X80043C0", 0, 0, "", "", "", "");
      return;
    } while (paramVideoController.a().jdField_e_of_type_Long <= 0L);
    if (paramVideoController.a().jdField_g_of_type_Boolean)
    {
      azqs.b(null, "CliOper", "", "", "0X80043DF", "0X80043DF", 0, 0, "", "", "", "");
      return;
    }
    azqs.b(null, "CliOper", "", "", "0X80043DE", "0X80043DE", 0, 0, "", "", "", "");
  }
  
  public static void c(boolean paramBoolean)
  {
    String str1;
    if (paramBoolean) {
      str1 = "0X8004ACC";
    }
    for (String str2 = "0X8004ACC";; str2 = "0X8004AC9")
    {
      azqs.b(null, "CliOper", "", "", str1, str2, 0, 0, "", "", "", "");
      return;
      str1 = "0X8004AC9";
    }
  }
  
  public static void c(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean) {
      if (paramInt != 1) {}
    }
    do
    {
      do
      {
        do
        {
          return;
          if (paramInt == 10)
          {
            azqs.b(null, "CliOper", "", "", "0X8005926", "0X8005926", 0, 0, "", "", "", "");
            return;
          }
        } while (paramInt != 2);
        azqs.b(null, "CliOper", "", "", "0X80046CC", "0X80046CC", 0, 0, "", "", "", "");
        return;
      } while (paramInt == 1);
      if (paramInt == 10)
      {
        azqs.b(null, "CliOper", "", "", "0X8005927", "0X8005927", 0, 0, "", "", "", "");
        return;
      }
    } while (paramInt != 2);
    azqs.b(null, "CliOper", "", "", "0X80046CD", "0X80046CD", 0, 0, "", "", "", "");
  }
  
  public static void c(boolean paramBoolean1, boolean paramBoolean2)
  {
    String str1;
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        str1 = "0X80049A4";
        if (!paramBoolean2) {
          break label50;
        }
      }
      label50:
      for (str2 = "0X80049A4";; str2 = "0X80049B3")
      {
        azqs.b(null, "CliOper", "", "", str1, str2, 0, 0, "", "", "", "");
        return;
        str1 = "0X80049B3";
        break;
      }
    }
    if (paramBoolean2)
    {
      str1 = "0X80049A1";
      label65:
      if (!paramBoolean2) {
        break label83;
      }
    }
    label83:
    for (String str2 = "0X80049A1";; str2 = "0X80049B0")
    {
      break;
      str1 = "0X80049B0";
      break label65;
    }
  }
  
  public static void d()
  {
    azqs.b(null, "CliOper", "", "", "0X8004E1B", "0X8004E1B", 0, 0, "", "", "", "");
  }
  
  public static void d(VideoController paramVideoController)
  {
    if (paramVideoController == null) {}
    String str;
    int i;
    label258:
    do
    {
      return;
      switch (paramVideoController.a().y)
      {
      default: 
        str = "8";
      }
      for (;;)
      {
        i = paramVideoController.a().jdField_d_of_type_Int;
        if (i != 1) {
          break label258;
        }
        if (!paramVideoController.a().k()) {
          break;
        }
        azqs.b(null, "CliOper", "", "", "0X8004389", "0X8004389", 0, 0, "", "", "", "");
        return;
        if (paramVideoController.a().n >= 0)
        {
          str = "1";
        }
        else
        {
          str = "0";
          continue;
          if (!paramVideoController.a().s)
          {
            str = "2";
          }
          else
          {
            str = "4";
            continue;
            str = "3";
            continue;
            str = "5";
            continue;
            str = "6";
            continue;
            str = "7";
            continue;
            str = "10";
            continue;
            str = "9";
          }
        }
      }
      azqs.b(null, "CliOper", "", "", "0X8004358", "0X8004358", 0, 0, str, "", "", "");
      return;
    } while (i != 2);
    if (paramVideoController.a().k())
    {
      azqs.b(null, "CliOper", "", "", "0X80043E4", "0X80043E4", 0, 0, "", "", "", "");
      return;
    }
    azqs.b(null, "CliOper", "", "", "0X80043C3", "0X80043C3", 0, 0, str, "", "", "");
  }
  
  public static void d(boolean paramBoolean)
  {
    String str1;
    if (paramBoolean) {
      str1 = "0X8004ACD";
    }
    for (String str2 = "0X8004ACD";; str2 = "0X8004ACA")
    {
      azqs.b(null, "CliOper", "", "", str1, str2, 0, 0, "", "", "", "");
      return;
      str1 = "0X8004ACA";
    }
  }
  
  public static void d(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean) {
      if (paramInt == 1) {
        azqs.b(null, "CliOper", "", "", "0X8004CF7", "0X8004CF7", 0, 0, "", "", "", "");
      }
    }
    do
    {
      do
      {
        return;
        if (paramInt == 10)
        {
          azqs.b(null, "CliOper", "", "", "0X8005949", "0X8005949", 0, 0, "", "", "", "");
          return;
        }
      } while (paramInt != 2);
      azqs.b(null, "CliOper", "", "", "0X8004F5B", "0X8004F5B", 0, 0, "", "", "", "");
      return;
      if (paramInt == 1)
      {
        azqs.b(null, "CliOper", "", "", "0X8004CF4", "0X8004CF4", 0, 0, "", "", "", "");
        return;
      }
      if (paramInt == 10)
      {
        azqs.b(null, "CliOper", "", "", "0X8005946", "0X8005946", 0, 0, "", "", "", "");
        return;
      }
    } while (paramInt != 2);
    azqs.b(null, "CliOper", "", "", "0X8004F58", "0X8004F58", 0, 0, "", "", "", "");
  }
  
  public static void d(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      azqs.b(null, "CliOper", "", "", "0X8009F5A", "0X8009F5A", 0, 0, "", "", "", "");
    }
    if (paramBoolean2) {
      azqs.b(null, "CliOper", "", "", "0X8009F5B", "0X8009F5B", 0, 0, "", "", "", "");
    }
  }
  
  public static void e()
  {
    azqs.b(null, "CliOper", "", "", "0X8004E1D", "0X8004E1D", 0, 0, "", "", "", "");
  }
  
  public static void e(VideoController paramVideoController)
  {
    if (paramVideoController == null) {}
    int i;
    do
    {
      return;
      i = paramVideoController.a().jdField_d_of_type_Int;
      if (i == 1)
      {
        azqs.b(null, "CliOper", "", "", "0X800435E", "0X800435E", 0, 0, "", "", "", "");
        return;
      }
    } while (i != 2);
    azqs.b(null, "CliOper", "", "", "0X80043C9", "0X80043C9", 0, 0, "", "", "", "");
  }
  
  public static void e(boolean paramBoolean)
  {
    String str1;
    if (paramBoolean) {
      str1 = "0X8004ACE";
    }
    for (String str2 = "0X8004ACE";; str2 = "0X8004ACB")
    {
      azqs.b(null, "CliOper", "", "", str1, str2, 0, 0, "", "", "", "");
      return;
      str1 = "0X8004ACB";
    }
  }
  
  public static void e(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        azqs.b(null, "dc00898", "", "", "0X800A014", "0X800A014", 0, 0, "", "", "", "");
        return;
      }
      azqs.b(null, "dc00898", "", "", "0X800A015", "0X800A015", 0, 0, "", "", "", "");
      return;
    }
    if (paramBoolean2)
    {
      azqs.b(null, "dc00898", "", "", "0X800A016", "0X800A016", 0, 0, "", "", "", "");
      return;
    }
    azqs.b(null, "dc00898", "", "", "0X800A017", "0X800A017", 0, 0, "", "", "", "");
  }
  
  public static void f()
  {
    lid locallid = VideoController.a().a();
    int i = locallid.jdField_d_of_type_Int;
    azqs.b(null, "dc00898", "", a(locallid), "0X800A2CC", "0X800A2CC", i, 0, "", "", "", "");
  }
  
  public static void f(VideoController paramVideoController)
  {
    if (paramVideoController == null) {}
    int i;
    do
    {
      return;
      i = paramVideoController.a().jdField_d_of_type_Int;
      if (i == 1)
      {
        azqs.b(null, "CliOper", "", "", "0X8004394", "0X8004394", 0, 0, "", "", "", "");
        return;
      }
    } while (i != 2);
    azqs.b(null, "CliOper", "", "", "0X80043F2", "0X80043F2", 0, 0, "", "", "", "");
  }
  
  public static void f(boolean paramBoolean)
  {
    if (paramBoolean) {
      azqs.b(null, "CliOper", "", "", "0X8005615", "0X8005615", 0, 0, "", "", "", "");
    }
  }
  
  public static void g(VideoController paramVideoController)
  {
    if (paramVideoController == null) {}
    int i;
    do
    {
      return;
      i = paramVideoController.a().jdField_d_of_type_Int;
      if (i == 1)
      {
        azqs.b(null, "CliOper", "", "", "0X8004370", "0X8004370", 0, 0, "", "", "", "");
        return;
      }
    } while (i != 2);
    azqs.b(null, "CliOper", "", "", "0X80043D0", "0X80043D0", 0, 0, "", "", "", "");
  }
  
  public static void h(VideoController paramVideoController)
  {
    if (paramVideoController == null) {}
    int i;
    do
    {
      return;
      i = paramVideoController.a().jdField_d_of_type_Int;
      if (i == 1)
      {
        azqs.b(null, "CliOper", "", "", "0X8004388", "0X8004388", 0, 0, "", "", "", "");
        return;
      }
    } while (i != 2);
    azqs.b(null, "CliOper", "", "", "0X80043E3", "0X80043E3", 0, 0, "", "", "", "");
  }
  
  public static void i(VideoController paramVideoController)
  {
    if (paramVideoController == null) {}
    int i;
    do
    {
      return;
      i = paramVideoController.a().jdField_d_of_type_Int;
      if (i == 1)
      {
        if (paramVideoController.a().O)
        {
          azqs.b(null, "CliOper", "", "", "0X8004351", "0X8004351", 0, 0, "", "", "", "");
          return;
        }
        azqs.b(null, "CliOper", "", "", "0X8004352", "0X8004352", 0, 0, "", "", "", "");
        return;
      }
    } while (i != 2);
    if (paramVideoController.a().O)
    {
      azqs.b(null, "CliOper", "", "", "0X80043BC", "0X80043BC", 0, 0, "", "", "", "");
      return;
    }
    azqs.b(null, "CliOper", "", "", "0X80043BD", "0X80043BD", 0, 0, "", "", "", "");
  }
  
  public static void j(VideoController paramVideoController)
  {
    if (paramVideoController == null) {}
    while ((!paramVideoController.a().k()) || (paramVideoController.a().jdField_d_of_type_Int != 1) || (paramVideoController.a().O)) {
      return;
    }
    azqs.b(null, "CliOper", "", "", "0X8004379", "0X8004379", 0, 0, "", "", "", "");
  }
  
  public static void k(VideoController paramVideoController)
  {
    if (a) {}
    int i;
    do
    {
      do
      {
        return;
        a = true;
      } while ((paramVideoController == null) || (!paramVideoController.a().k()));
      i = paramVideoController.a().jdField_d_of_type_Int;
      if (i == 1)
      {
        azqs.b(null, "CliOper", "", "", "0X800437A", "0X800437A", 0, 0, "", "", "", "");
        return;
      }
    } while (i != 2);
    azqs.b(null, "CliOper", "", "", "0X80043D5", "0X80043D5", 0, 0, "", "", "", "");
  }
  
  public static void l(VideoController paramVideoController)
  {
    if (paramVideoController == null) {}
    String str;
    int i;
    label263:
    do
    {
      return;
      str = "";
      if (!paramVideoController.a().t) {
        switch (paramVideoController.a().y)
        {
        default: 
          str = "8";
        }
      }
      for (;;)
      {
        i = paramVideoController.a().jdField_d_of_type_Int;
        if (i != 1) {
          break label263;
        }
        if (!paramVideoController.a().k()) {
          break;
        }
        azqs.b(null, "CliOper", "", "", "0X800438A", "0X800438A", 0, 0, "", "", "", "");
        return;
        if (paramVideoController.a().n >= 0)
        {
          str = "1";
        }
        else
        {
          str = "0";
          continue;
          if (!paramVideoController.a().s)
          {
            str = "2";
          }
          else
          {
            str = "4";
            continue;
            str = "3";
            continue;
            str = "5";
            continue;
            str = "6";
            continue;
            str = "7";
            continue;
            str = "9";
          }
        }
      }
      azqs.b(null, "CliOper", "", "", "0X800435B", "0X800435B", 0, 0, str, "", "", "");
      return;
    } while (i != 2);
    if (paramVideoController.a().k())
    {
      azqs.b(null, "CliOper", "", "", "0X80043E5", "0X80043E5", 0, 0, "", "", "", "");
      return;
    }
    azqs.b(null, "CliOper", "", "", "0X80043C6", "0X80043C6", 0, 0, str, "", "", "");
  }
  
  public static void m(VideoController paramVideoController)
  {
    if (b) {}
    do
    {
      return;
      b = true;
    } while ((paramVideoController == null) || ((!paramVideoController.a().j) && (!paramVideoController.a().k)));
    azqs.b(null, "CliOper", "", "", "0X800438F", "0X800438F", 0, 0, "", "", "", "");
  }
  
  public static void n(VideoController paramVideoController)
  {
    if (c) {}
    do
    {
      return;
      c = true;
    } while ((paramVideoController == null) || (paramVideoController.a().j) || (paramVideoController.a().k));
    azqs.b(null, "CliOper", "", "", "0X80043EB", "0X80043EB", 0, 0, "", "", "", "");
  }
  
  public static void o(VideoController paramVideoController)
  {
    if (d) {}
    int i;
    do
    {
      do
      {
        return;
        d = true;
      } while (paramVideoController == null);
      i = paramVideoController.a().jdField_d_of_type_Int;
      if (i == 1)
      {
        azqs.b(null, "CliOper", "", "", "0X8004395", "0X8004395", 0, 0, "", "", "", "");
        return;
      }
    } while (i != 2);
    azqs.b(null, "CliOper", "", "", "0X80043F3", "0X80043F3", 0, 0, "", "", "", "");
  }
  
  public static void p(VideoController paramVideoController)
  {
    String str1 = "";
    String str2 = "";
    if (paramVideoController.a().jdField_d_of_type_Int == 1)
    {
      str1 = "0X8004360";
      str2 = "0X8004361";
    }
    for (;;)
    {
      azqs.b(null, "CliOper", "", "", str1, str2, 0, 0, "", "", "", "");
      return;
      if (paramVideoController.a().jdField_d_of_type_Int == 2)
      {
        str1 = "0X800444C";
        str2 = "0X800444C";
      }
    }
  }
  
  public static void q(VideoController paramVideoController)
  {
    String str1 = "";
    String str2 = "";
    if (paramVideoController.a().jdField_d_of_type_Int == 1)
    {
      str1 = "0X8004361";
      str2 = "0X8004362";
    }
    for (;;)
    {
      azqs.b(null, "CliOper", "", "", str1, str2, 0, 0, "", "", "", "");
      return;
      if (paramVideoController.a().jdField_d_of_type_Int == 2)
      {
        str1 = "0X800444D";
        str2 = "0X800444D";
      }
    }
  }
  
  public static void r(VideoController paramVideoController)
  {
    String str = "";
    if (paramVideoController.a().jdField_d_of_type_Int == 1) {
      str = "0X8004369";
    }
    for (;;)
    {
      azqs.b(null, "CliOper", "", "", str, str, 0, 0, "", "", "", "");
      return;
      if (paramVideoController.a().jdField_d_of_type_Int == 2) {
        str = "0X8004451";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mtq
 * JD-Core Version:    0.7.0.1
 */