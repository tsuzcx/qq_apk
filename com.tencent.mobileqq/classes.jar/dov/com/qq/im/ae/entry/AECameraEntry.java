package dov.com.qq.im.ae.entry;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import dov.com.qq.im.ae.AEBaseCameraUnit;
import dov.com.qq.im.ae.AECameraConfig;
import dov.com.qq.im.ae.AEPituCameraUnit;
import dov.com.qq.im.ae.mode.AECaptureMode;
import java.util.HashMap;
import java.util.Map;

public class AECameraEntry
{
  public static final AECameraEntry A = new AECameraEntry("circleGuidePicker", 28);
  public static final AECameraEntry B = new AECameraEntry("tribeShortVideoPicker", 29);
  public static final AECameraEntry C = new AECameraEntry("kanDianUGCPicPicker", 30);
  public static final AECameraEntry D = new AECameraEntry("ad", 33);
  public static final AECameraEntry E = new AECameraEntry("circleMultiCutAdditionalPick", 34);
  public static final AECameraEntry F = new AECameraEntry("webFromAIO", 35);
  public static final AECameraEntry G = new AECameraEntry("bless", 36);
  public static final AECameraEntry H = new AECameraEntry("miniAppPlay", 38);
  public static final AECameraEntry I = new AECameraEntry("qudongTakeFacePhoto", 1001, false);
  public static final AECameraEntry J = new AECameraEntry("web", 1002, false);
  public static final AECameraEntry K = new AECameraEntry("faceUnlock", 1003, false);
  public static final AECameraEntry a;
  private static final AECameraEntry[] jdField_a_of_type_ArrayOfDovComQqImAeEntryAECameraEntry = { b, c, e, r, q, s, g, i, k, l, m, n, o, u, t, w, I, J, v, x, z, B, C, F, G, D, H, K };
  public static final AECameraEntry b;
  public static final AECameraEntry c;
  public static final AECameraEntry d;
  public static final AECameraEntry e;
  public static final AECameraEntry f;
  public static final AECameraEntry g;
  public static final AECameraEntry h;
  public static final AECameraEntry i;
  public static final AECameraEntry j;
  public static final AECameraEntry k;
  public static final AECameraEntry l;
  public static final AECameraEntry m;
  public static final AECameraEntry n;
  public static final AECameraEntry o;
  public static final AECameraEntry p;
  public static final AECameraEntry q;
  public static final AECameraEntry r;
  public static final AECameraEntry s;
  public static final AECameraEntry t;
  public static final AECameraEntry u;
  public static final AECameraEntry v;
  public static final AECameraEntry w;
  public static final AECameraEntry x;
  public static final AECameraEntry y;
  public static final AECameraEntry z;
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_DovComQqImAeEntryAECameraEntry = new AECameraEntry("", -1);
    b = new AECameraEntry("h5", 0);
    c = new AECameraEntry("mainCamera", 1);
    d = new AECameraEntry("", 2);
    e = new AECameraEntry("aioMainCamera", 3);
    f = new AECameraEntry("", 4);
    g = new AECameraEntry("qzoneCamera", 5);
    h = new AECameraEntry("", 6);
    i = new AECameraEntry("aioGifCamera", 7);
    j = new AECameraEntry("", 8);
    k = new AECameraEntry("aioGroupSignin", 9);
    l = new AECameraEntry("qzoneSignin", 10);
    m = new AECameraEntry("qzoneBanner", 11);
    n = new AECameraEntry("qzoneTail", 12);
    o = new AECameraEntry("qzoneMoodList", 13);
    p = new AECameraEntry("", 14);
    q = new AECameraEntry("qzoneFriendPlus", 15);
    r = new AECameraEntry("qzoneFriendState", 16);
    s = new AECameraEntry("qzoneSlideCamera", 17);
    t = new AECameraEntry("aioChats", 18);
    u = new AECameraEntry("massSendBless", 19);
    v = new AECameraEntry("qzonePublishFrame", 20);
    w = new AECameraEntry("aioGifCameraTail", 23);
    x = new AECameraEntry("circleCamera", 25);
    y = new AECameraEntry("circlePickCamera", 26);
    z = new AECameraEntry("circleGuideCamera", 27);
  }
  
  private AECameraEntry(String paramString, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = true;
  }
  
  private AECameraEntry(String paramString, int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public static int a(Intent paramIntent)
  {
    if (paramIntent == null) {
      return jdField_a_of_type_DovComQqImAeEntryAECameraEntry.a();
    }
    return paramIntent.getIntExtra("VIDEO_STORY_FROM_TYPE", jdField_a_of_type_DovComQqImAeEntryAECameraEntry.a());
  }
  
  public static int a(AEBaseCameraUnit paramAEBaseCameraUnit)
  {
    int i2 = 200;
    int i1;
    if ((paramAEBaseCameraUnit != null) && (paramAEBaseCameraUnit.b() != null)) {
      i1 = paramAEBaseCameraUnit.b().j();
    }
    do
    {
      do
      {
        do
        {
          return i1;
          i1 = i2;
        } while (paramAEBaseCameraUnit == null);
        i1 = i2;
      } while (paramAEBaseCameraUnit.a() == null);
      i1 = i2;
    } while (paramAEBaseCameraUnit.a().getIntent() == null);
    return paramAEBaseCameraUnit.a().getIntent().getIntExtra("AECAMERA_MODE", 200);
  }
  
  public static int a(String paramString)
  {
    int i2 = 200;
    HashMap localHashMap = new HashMap(4);
    localHashMap.put("camera", Integer.valueOf(200));
    localHashMap.put("all", Integer.valueOf(201));
    localHashMap.put("gif", Integer.valueOf(202));
    localHashMap.put("singlegif", Integer.valueOf(203));
    localHashMap.put("cameraAndPlay", Integer.valueOf(204));
    localHashMap.put("cameraAndGif", Integer.valueOf(205));
    localHashMap.put("play", Integer.valueOf(206));
    localHashMap.put("playAndGif", Integer.valueOf(207));
    int i1 = i2;
    if (paramString != null)
    {
      i1 = i2;
      if (localHashMap.containsKey(paramString))
      {
        i1 = i2;
        if (localHashMap.get(paramString) != null) {
          i1 = ((Integer)localHashMap.get(paramString)).intValue();
        }
      }
    }
    return i1;
  }
  
  public static AECameraEntry a(int paramInt)
  {
    AECameraEntry[] arrayOfAECameraEntry = jdField_a_of_type_ArrayOfDovComQqImAeEntryAECameraEntry;
    int i2 = arrayOfAECameraEntry.length;
    int i1 = 0;
    while (i1 < i2)
    {
      AECameraEntry localAECameraEntry = arrayOfAECameraEntry[i1];
      if (paramInt == localAECameraEntry.a()) {
        return localAECameraEntry;
      }
      i1 += 1;
    }
    return jdField_a_of_type_DovComQqImAeEntryAECameraEntry;
  }
  
  public static AECameraEntry a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return jdField_a_of_type_DovComQqImAeEntryAECameraEntry;
    }
    AECameraEntry[] arrayOfAECameraEntry = jdField_a_of_type_ArrayOfDovComQqImAeEntryAECameraEntry;
    int i2 = arrayOfAECameraEntry.length;
    int i1 = 0;
    if (i1 < i2)
    {
      AECameraEntry localAECameraEntry = arrayOfAECameraEntry[i1];
      if (TextUtils.isEmpty(localAECameraEntry.a())) {}
      while (!paramString.equals(localAECameraEntry.a()))
      {
        i1 += 1;
        break;
      }
      return localAECameraEntry;
    }
    return jdField_a_of_type_DovComQqImAeEntryAECameraEntry;
  }
  
  @NonNull
  public static String a(@Nullable String paramString)
  {
    if ("camera".equals(paramString)) {
      return String.valueOf(AECaptureMode.NORMAL.name);
    }
    if ("play".equals(paramString)) {
      return String.valueOf(AECaptureMode.PLAY.name);
    }
    if ("gif".equals(paramString)) {
      return String.valueOf(AECaptureMode.GIF.name);
    }
    return String.valueOf(AECaptureMode.NORMAL.name);
  }
  
  public static boolean a(Activity paramActivity)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramActivity != null)
    {
      bool1 = bool2;
      if (paramActivity.getIntent() != null)
      {
        int i1 = paramActivity.getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", jdField_a_of_type_DovComQqImAeEntryAECameraEntry.a());
        if (i1 != J.a())
        {
          bool1 = bool2;
          if (i1 != I.a()) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static boolean a(Intent paramIntent)
  {
    boolean bool = false;
    if ((paramIntent == null) || (paramIntent.getIntExtra("VIDEO_STORY_JUMP_TO_TYPE", 0) == 0)) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean a(Intent paramIntent, int paramInt)
  {
    return (paramInt == 14) && (!a(paramIntent)) && (!b(paramIntent));
  }
  
  public static boolean a(AEPituCameraUnit paramAEPituCameraUnit)
  {
    if ((paramAEPituCameraUnit != null) && (paramAEPituCameraUnit.a() != null)) {
      return k(paramAEPituCameraUnit.a().getIntent());
    }
    return false;
  }
  
  public static int b(Intent paramIntent)
  {
    if (paramIntent == null) {
      return 0;
    }
    return paramIntent.getIntExtra("VIDEO_STORY_JUMP_TO_TYPE", 0);
  }
  
  public static boolean b(int paramInt)
  {
    return paramInt == t.a();
  }
  
  public static boolean b(Activity paramActivity)
  {
    if (paramActivity == null) {}
    do
    {
      return false;
      paramActivity = paramActivity.getIntent();
    } while (paramActivity == null);
    return d(paramActivity.getIntExtra("VIDEO_STORY_FROM_TYPE", jdField_a_of_type_DovComQqImAeEntryAECameraEntry.a()));
  }
  
  public static boolean b(Intent paramIntent)
  {
    return (paramIntent == null) || (paramIntent.getIntExtra("VIDEO_STORY_MEDIA_TYPE", 100) == 100);
  }
  
  public static int c(Intent paramIntent)
  {
    if (paramIntent == null) {
      return 100;
    }
    return paramIntent.getIntExtra("VIDEO_STORY_MEDIA_TYPE", 100);
  }
  
  public static boolean c(int paramInt)
  {
    return n.a() == paramInt;
  }
  
  public static boolean c(Activity paramActivity)
  {
    if (paramActivity == null) {}
    do
    {
      return false;
      paramActivity = paramActivity.getIntent();
    } while (paramActivity == null);
    if (paramActivity.hasExtra("ORIGIN_VIDEO_STORY_FROM_TYPE")) {}
    for (int i1 = paramActivity.getIntExtra("ORIGIN_VIDEO_STORY_FROM_TYPE", jdField_a_of_type_DovComQqImAeEntryAECameraEntry.a());; i1 = paramActivity.getIntExtra("VIDEO_STORY_FROM_TYPE", jdField_a_of_type_DovComQqImAeEntryAECameraEntry.a())) {
      return f(i1);
    }
  }
  
  public static boolean c(Intent paramIntent)
  {
    return (q(paramIntent)) || (r(paramIntent)) || (s(paramIntent));
  }
  
  public static boolean d(int paramInt)
  {
    return (paramInt == g.a()) || (paramInt == o.a()) || (paramInt == r.a()) || (paramInt == v.a());
  }
  
  public static boolean d(Activity paramActivity)
  {
    if (paramActivity == null) {}
    do
    {
      return false;
      paramActivity = paramActivity.getIntent();
    } while (paramActivity == null);
    int i1;
    if (paramActivity.hasExtra("ORIGIN_VIDEO_STORY_FROM_TYPE"))
    {
      i1 = paramActivity.getIntExtra("ORIGIN_VIDEO_STORY_FROM_TYPE", jdField_a_of_type_DovComQqImAeEntryAECameraEntry.a());
      if (n.a() != i1) {
        break label69;
      }
    }
    label69:
    for (boolean bool = true;; bool = false)
    {
      return bool;
      i1 = paramActivity.getIntExtra("VIDEO_STORY_FROM_TYPE", jdField_a_of_type_DovComQqImAeEntryAECameraEntry.a());
      break;
    }
  }
  
  public static boolean d(Intent paramIntent)
  {
    return (paramIntent != null) && (a(paramIntent) == n.a());
  }
  
  public static boolean e(int paramInt)
  {
    return paramInt == c.a();
  }
  
  public static boolean e(Intent paramIntent)
  {
    int i1 = a(paramIntent);
    return (i1 == k.a()) || (i1 == l.a());
  }
  
  public static boolean f(int paramInt)
  {
    return (paramInt == g.a()) || (paramInt == o.a()) || (paramInt == r.a()) || (paramInt == v.a());
  }
  
  public static boolean f(Intent paramIntent)
  {
    return a(paramIntent) == H.a();
  }
  
  public static boolean g(int paramInt)
  {
    return e.a() == paramInt;
  }
  
  public static boolean g(Intent paramIntent)
  {
    return (paramIntent != null) && (a(paramIntent) == e.a());
  }
  
  public static boolean h(int paramInt)
  {
    return (paramInt == x.a()) || (i(paramInt)) || (j(paramInt));
  }
  
  public static boolean h(Intent paramIntent)
  {
    return (paramIntent != null) && (a(paramIntent) == i.a());
  }
  
  public static boolean i(int paramInt)
  {
    return (paramInt == A.a()) || (paramInt == z.a());
  }
  
  public static boolean i(Intent paramIntent)
  {
    return (paramIntent != null) && (a(paramIntent) == I.a());
  }
  
  public static boolean j(int paramInt)
  {
    return paramInt == E.a();
  }
  
  public static boolean j(Intent paramIntent)
  {
    return (paramIntent != null) && (a(paramIntent) == J.a());
  }
  
  public static boolean k(int paramInt)
  {
    return (paramInt != e.a()) && (paramInt != i.a()) && (paramInt != p.a()) && (paramInt != w.a()) && (paramInt != x.a()) && (paramInt != I.a()) && (paramInt != J.a());
  }
  
  public static boolean k(Intent paramIntent)
  {
    return ((paramIntent != null) && ((a(paramIntent) == x.a()) || (l(paramIntent)))) || (n(paramIntent));
  }
  
  public static boolean l(Intent paramIntent)
  {
    return (paramIntent != null) && ((a(paramIntent) == z.a()) || (a(paramIntent) == A.a()));
  }
  
  public static boolean m(Intent paramIntent)
  {
    if (paramIntent == null) {}
    int i1;
    do
    {
      return false;
      i1 = a(paramIntent);
    } while ((i1 != F.a()) && (i1 != G.a()) && (i1 != D.a()));
    return true;
  }
  
  public static boolean n(Intent paramIntent)
  {
    return (paramIntent != null) && (a(paramIntent) == E.a());
  }
  
  private static boolean o(Intent paramIntent)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramIntent != null)
    {
      bool1 = bool2;
      if (paramIntent.getIntExtra("VIDEO_STORY_FROM_TYPE", jdField_a_of_type_DovComQqImAeEntryAECameraEntry.a()) == t.a()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private static boolean p(Intent paramIntent)
  {
    return (paramIntent != null) && (paramIntent.getIntExtra("VIDEO_STORY_MEDIA_TYPE", 100) == 101);
  }
  
  private static boolean q(Intent paramIntent)
  {
    return (d(paramIntent)) && (p(paramIntent));
  }
  
  private static boolean r(Intent paramIntent)
  {
    return (o(paramIntent)) && (p(paramIntent));
  }
  
  private static boolean s(Intent paramIntent)
  {
    return (e(paramIntent)) && (p(paramIntent));
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(int paramInt)
  {
    return this.jdField_a_of_type_Int == paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.entry.AECameraEntry
 * JD-Core Version:    0.7.0.1
 */