package dov.com.qq.im.ae;

import bmya;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.filament.CMShowUserLoader;
import com.tencent.ttpic.filament.CmShowAssetsData;
import com.tencent.ttpic.filter.Face3DLibJNI;
import com.tencent.ttpic.filter.Face3DLibJNI.CMFacePartId;
import java.util.HashMap;
import java.util.Map;

public class BlendShapeThread
  extends Thread
{
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "eyebrow", "eyelash", "mouth", "tongue", "tooth_down", "tooth_up", "eyes_l", "eyes_r" };
  private int jdField_a_of_type_Int;
  private bmya jdField_a_of_type_Bmya;
  private CmShowAssetsData jdField_a_of_type_ComTencentTtpicFilamentCmShowAssetsData;
  private HashMap<String, Integer> jdField_a_of_type_JavaUtilHashMap;
  private HashMap<String, HashMap<String, float[]>> b;
  private HashMap<String, Map> c;
  
  public BlendShapeThread(int paramInt, CmShowAssetsData paramCmShowAssetsData, bmya parambmya)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentTtpicFilamentCmShowAssetsData = paramCmShowAssetsData;
    this.jdField_a_of_type_Bmya = parambmya;
    a();
  }
  
  public BlendShapeThread(CmShowAssetsData paramCmShowAssetsData, bmya parambmya)
  {
    this(0, paramCmShowAssetsData, parambmya);
  }
  
  private HashMap<String, float[]> a(String paramString, HashMap<String, float[]> paramHashMap1, Face3DLibJNI paramFace3DLibJNI, HashMap<String, float[]> paramHashMap2, long paramLong, int[] paramArrayOfInt)
  {
    HashMap localHashMap;
    int i;
    if (this.b.get(paramString) != null)
    {
      localHashMap = (HashMap)this.b.get(paramString);
      i = 0;
      label27:
      if (i >= paramArrayOfInt.length) {
        break label157;
      }
      if ((paramHashMap1 != null) && (paramHashMap1.get(paramString) != null)) {
        break label68;
      }
    }
    for (;;)
    {
      i += 1;
      break label27;
      localHashMap = new HashMap();
      break;
      label68:
      float[] arrayOfFloat = new float[((float[])paramHashMap1.get(paramString)).length];
      String str = paramFace3DLibJNI.QQGetExpressNameById(paramLong, paramArrayOfInt[i]);
      paramFace3DLibJNI.QQGeneratePartExpression(paramLong, ((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).intValue(), paramArrayOfInt[i], (float[])paramHashMap2.get(str), (float[])paramHashMap1.get(paramString), arrayOfFloat);
      if (str != null) {
        localHashMap.put(str, arrayOfFloat);
      }
    }
    label157:
    this.b.put(paramString, localHashMap);
    return localHashMap;
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilHashMap.put("face", Integer.valueOf(Face3DLibJNI.CMFacePartId.face_part_face.value));
    this.jdField_a_of_type_JavaUtilHashMap.put("eyebrow", Integer.valueOf(Face3DLibJNI.CMFacePartId.face_part_eyebrow.value));
    this.jdField_a_of_type_JavaUtilHashMap.put("eyelash", Integer.valueOf(Face3DLibJNI.CMFacePartId.face_part_eyelash.value));
    this.jdField_a_of_type_JavaUtilHashMap.put("mouth", Integer.valueOf(Face3DLibJNI.CMFacePartId.face_part_mouth.value));
    this.jdField_a_of_type_JavaUtilHashMap.put("tongue", Integer.valueOf(Face3DLibJNI.CMFacePartId.face_part_tongue.value));
    this.jdField_a_of_type_JavaUtilHashMap.put("tooth_up", Integer.valueOf(Face3DLibJNI.CMFacePartId.face_part_tooth_up.value));
    this.jdField_a_of_type_JavaUtilHashMap.put("tooth_down", Integer.valueOf(Face3DLibJNI.CMFacePartId.face_part_tooth_down.value));
    this.jdField_a_of_type_JavaUtilHashMap.put("eyes_l", Integer.valueOf(Face3DLibJNI.CMFacePartId.face_part_eyes_l.value));
    this.jdField_a_of_type_JavaUtilHashMap.put("eyes_r", Integer.valueOf(Face3DLibJNI.CMFacePartId.face_part_eyes_r.value));
  }
  
  private void a(CMShowUserLoader paramCMShowUserLoader, Face3DLibJNI paramFace3DLibJNI, HashMap<String, float[]> paramHashMap, long paramLong, int[] paramArrayOfInt)
  {
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length == 0)) {
      return;
    }
    if (this.b == null) {
      this.b = new HashMap();
    }
    if (this.b.get("face") != null) {}
    String str;
    for (HashMap localHashMap = (HashMap)this.b.get("face");; localHashMap = new HashMap())
    {
      i = 0;
      while (i < paramArrayOfInt.length)
      {
        localObject = new float[((float[])paramHashMap.get("face")).length];
        paramFace3DLibJNI.QQGenerateFaceExpression(paramLong, paramArrayOfInt[i], (float[])paramHashMap.get("face"), (float[])localObject);
        str = paramFace3DLibJNI.QQGetExpressNameById(paramLong, paramArrayOfInt[i]);
        if (str != null) {
          localHashMap.put(str, localObject);
        }
        i += 1;
      }
    }
    this.b.put("face", localHashMap);
    LogUtils.i("LIB3DMM", "faceEx:" + localHashMap.size());
    paramCMShowUserLoader.setMorphData("face", localHashMap);
    if (this.jdField_a_of_type_Bmya != null) {
      this.jdField_a_of_type_Bmya.a(this.jdField_a_of_type_Int, "face", localHashMap);
    }
    Object localObject = jdField_a_of_type_ArrayOfJavaLangString;
    int j = localObject.length;
    int i = 0;
    label237:
    if (i < j)
    {
      str = localObject[i];
      if (paramHashMap.containsKey(str)) {
        break label269;
      }
    }
    for (;;)
    {
      i += 1;
      break label237;
      break;
      label269:
      paramCMShowUserLoader.setMorphData(str, a(str, paramHashMap, paramFace3DLibJNI, localHashMap, paramLong, paramArrayOfInt));
    }
  }
  
  public void run()
  {
    super.run();
    CMShowUserLoader localCMShowUserLoader = new CMShowUserLoader(this.jdField_a_of_type_Int);
    localCMShowUserLoader.setCmShowAssetsData(this.jdField_a_of_type_ComTencentTtpicFilamentCmShowAssetsData);
    if (this.jdField_a_of_type_Bmya != null) {
      this.jdField_a_of_type_Bmya.a(localCMShowUserLoader);
    }
    HashMap localHashMap = localCMShowUserLoader.getBaseData();
    if (!localHashMap.containsKey("face")) {
      return;
    }
    Face3DLibJNI localFace3DLibJNI = Face3DLibJNI.getInstance();
    long l = localFace3DLibJNI.QQInitDataWithBundle();
    this.c = new HashMap();
    a(localCMShowUserLoader, localFace3DLibJNI, localHashMap, l, localFace3DLibJNI.QQGetHighLvFaceExpressions(l));
    a(localCMShowUserLoader, localFace3DLibJNI, localHashMap, l, localFace3DLibJNI.QQGetMidLvFaceExpressions(l));
    localFace3DLibJNI.QQDestroy(l);
    LogUtils.i("LIB3DMM", "ENDDDD,userIndex:" + this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.BlendShapeThread
 * JD-Core Version:    0.7.0.1
 */