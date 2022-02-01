package org.light.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.HashMap;

public class LightFaceFeature
  implements Parcelable
{
  public static final Parcelable.Creator<LightFaceFeature> CREATOR = new LightFaceFeature.1();
  public int age;
  public String emotion;
  public HashMap<String, Boolean> expression_status_ = new HashMap();
  public float[] faceBoundsRect = new float[4];
  public float[] faceFeature256Points = new float[512];
  public float[] faceFeature256Visibility = new float[256];
  public float[] faceFeature3DPoints = new float[3000];
  public float[] faceFeaturePoints = new float['¦'];
  public float[] faceFeatureVisibility = new float[83];
  public float[] facePoint83 = new float['¦'];
  public float[] facePoint83Visibility = new float[83];
  public float[] facePoint90 = new float['´'];
  public float[] facePoint90Visibility = new float[90];
  public float[] facePoints = new float['¼'];
  public float[] facePointsVisible = new float[94];
  public String gender;
  public boolean hasOutline;
  public float[] imageSize = new float[2];
  public float[] leBounds = new float[4];
  public TTFaceOriginDataModel mTTFaceOriginDataModel;
  public float[] mouthBounds = new float[4];
  public float pitch;
  public float[] reBounds = new float[4];
  public float roll;
  public float[] transform3D = new float[16];
  public float yaw;
  
  public LightFaceFeature() {}
  
  protected LightFaceFeature(Parcel paramParcel)
  {
    this.imageSize = paramParcel.createFloatArray();
    this.faceBoundsRect = paramParcel.createFloatArray();
    this.leBounds = paramParcel.createFloatArray();
    this.reBounds = paramParcel.createFloatArray();
    this.mouthBounds = paramParcel.createFloatArray();
    this.pitch = paramParcel.readFloat();
    this.yaw = paramParcel.readFloat();
    this.roll = paramParcel.readFloat();
    boolean bool;
    if (paramParcel.readByte() != 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.hasOutline = bool;
    this.gender = paramParcel.readString();
    this.age = paramParcel.readInt();
    this.emotion = paramParcel.readString();
    this.facePoints = paramParcel.createFloatArray();
    this.facePointsVisible = paramParcel.createFloatArray();
    this.facePoint83 = paramParcel.createFloatArray();
    this.facePoint83Visibility = paramParcel.createFloatArray();
    this.facePoint90 = paramParcel.createFloatArray();
    this.facePoint90Visibility = paramParcel.createFloatArray();
    this.faceFeaturePoints = paramParcel.createFloatArray();
    this.faceFeatureVisibility = paramParcel.createFloatArray();
    this.faceFeature256Points = paramParcel.createFloatArray();
    this.faceFeature256Visibility = paramParcel.createFloatArray();
    this.faceFeature3DPoints = paramParcel.createFloatArray();
    this.transform3D = paramParcel.createFloatArray();
    this.expression_status_ = ((HashMap)paramParcel.readSerializable());
    this.mTTFaceOriginDataModel = ((TTFaceOriginDataModel)paramParcel.readSerializable());
  }
  
  public LightFaceFeature(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3, float[] paramArrayOfFloat4, float[] paramArrayOfFloat5, float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean, String paramString, float[] paramArrayOfFloat6, float[] paramArrayOfFloat7, float[] paramArrayOfFloat8, float[] paramArrayOfFloat9, float[] paramArrayOfFloat10, float[] paramArrayOfFloat11, float[] paramArrayOfFloat12, float[] paramArrayOfFloat13, float[] paramArrayOfFloat14, float[] paramArrayOfFloat15, HashMap<String, Boolean> paramHashMap)
  {
    this(paramArrayOfFloat1, paramArrayOfFloat2, paramArrayOfFloat3, paramArrayOfFloat4, paramArrayOfFloat5, paramFloat1, paramFloat2, paramFloat3, paramBoolean, paramString, paramArrayOfFloat6, paramArrayOfFloat7, paramArrayOfFloat8, paramArrayOfFloat9, paramArrayOfFloat10, paramArrayOfFloat11, paramArrayOfFloat12, paramArrayOfFloat13, paramArrayOfFloat14, paramArrayOfFloat15, paramHashMap, "");
  }
  
  public LightFaceFeature(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3, float[] paramArrayOfFloat4, float[] paramArrayOfFloat5, float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean, String paramString1, float[] paramArrayOfFloat6, float[] paramArrayOfFloat7, float[] paramArrayOfFloat8, float[] paramArrayOfFloat9, float[] paramArrayOfFloat10, float[] paramArrayOfFloat11, float[] paramArrayOfFloat12, float[] paramArrayOfFloat13, float[] paramArrayOfFloat14, float[] paramArrayOfFloat15, HashMap<String, Boolean> paramHashMap, String paramString2)
  {
    this.imageSize = paramArrayOfFloat1;
    this.faceBoundsRect = paramArrayOfFloat2;
    this.leBounds = paramArrayOfFloat3;
    this.reBounds = paramArrayOfFloat4;
    this.mouthBounds = paramArrayOfFloat5;
    this.pitch = paramFloat1;
    this.yaw = paramFloat2;
    this.roll = paramFloat3;
    this.hasOutline = paramBoolean;
    this.emotion = paramString1;
    this.facePoints = paramArrayOfFloat6;
    this.facePointsVisible = paramArrayOfFloat7;
    this.facePoint83 = paramArrayOfFloat8;
    this.facePoint83Visibility = paramArrayOfFloat9;
    this.faceFeaturePoints = this.facePoint83;
    this.faceFeatureVisibility = this.facePoint83Visibility;
    this.facePoint90 = paramArrayOfFloat10;
    this.facePoint90Visibility = paramArrayOfFloat11;
    this.faceFeature256Points = paramArrayOfFloat12;
    this.faceFeature256Visibility = paramArrayOfFloat13;
    this.faceFeature3DPoints = paramArrayOfFloat14;
    this.transform3D = paramArrayOfFloat15;
    this.expression_status_ = paramHashMap;
    this.gender = paramString2;
    this.mTTFaceOriginDataModel = new TTFaceOriginDataModel(paramArrayOfFloat6, paramArrayOfFloat7, paramFloat1, paramFloat2, paramFloat3);
  }
  
  public LightFaceFeature(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3, float[] paramArrayOfFloat4, float[] paramArrayOfFloat5, float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean, String paramString1, float[] paramArrayOfFloat6, float[] paramArrayOfFloat7, float[] paramArrayOfFloat8, float[] paramArrayOfFloat9, float[] paramArrayOfFloat10, float[] paramArrayOfFloat11, float[] paramArrayOfFloat12, float[] paramArrayOfFloat13, float[] paramArrayOfFloat14, float[] paramArrayOfFloat15, HashMap<String, Boolean> paramHashMap, String paramString2, int paramInt)
  {
    this.imageSize = paramArrayOfFloat1;
    this.faceBoundsRect = paramArrayOfFloat2;
    this.leBounds = paramArrayOfFloat3;
    this.reBounds = paramArrayOfFloat4;
    this.mouthBounds = paramArrayOfFloat5;
    this.pitch = paramFloat1;
    this.yaw = paramFloat2;
    this.roll = paramFloat3;
    this.hasOutline = paramBoolean;
    this.emotion = paramString1;
    this.facePoints = paramArrayOfFloat6;
    this.facePointsVisible = paramArrayOfFloat7;
    this.facePoint83 = paramArrayOfFloat8;
    this.facePoint83Visibility = paramArrayOfFloat9;
    this.faceFeaturePoints = this.facePoint83;
    this.faceFeatureVisibility = this.facePoint83Visibility;
    this.facePoint90 = paramArrayOfFloat10;
    this.facePoint90Visibility = paramArrayOfFloat11;
    this.faceFeature256Points = paramArrayOfFloat12;
    this.faceFeature256Visibility = paramArrayOfFloat13;
    this.faceFeature3DPoints = paramArrayOfFloat14;
    this.transform3D = paramArrayOfFloat15;
    this.expression_status_ = paramHashMap;
    this.gender = paramString2;
    this.age = paramInt;
    this.mTTFaceOriginDataModel = new TTFaceOriginDataModel(paramArrayOfFloat6, paramArrayOfFloat7, paramFloat1, paramFloat2, paramFloat3);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void readFromParcel(Parcel paramParcel)
  {
    this.imageSize = paramParcel.createFloatArray();
    this.faceBoundsRect = paramParcel.createFloatArray();
    this.leBounds = paramParcel.createFloatArray();
    this.reBounds = paramParcel.createFloatArray();
    this.mouthBounds = paramParcel.createFloatArray();
    this.pitch = paramParcel.readFloat();
    this.yaw = paramParcel.readFloat();
    this.roll = paramParcel.readFloat();
    boolean bool;
    if (paramParcel.readByte() != 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.hasOutline = bool;
    this.gender = paramParcel.readString();
    this.age = paramParcel.readInt();
    this.emotion = paramParcel.readString();
    this.facePoints = paramParcel.createFloatArray();
    this.facePointsVisible = paramParcel.createFloatArray();
    this.facePoint83 = paramParcel.createFloatArray();
    this.facePoint83Visibility = paramParcel.createFloatArray();
    this.facePoint90 = paramParcel.createFloatArray();
    this.facePoint90Visibility = paramParcel.createFloatArray();
    this.faceFeaturePoints = paramParcel.createFloatArray();
    this.faceFeatureVisibility = paramParcel.createFloatArray();
    this.faceFeature256Points = paramParcel.createFloatArray();
    this.faceFeature256Visibility = paramParcel.createFloatArray();
    this.faceFeature3DPoints = paramParcel.createFloatArray();
    this.transform3D = paramParcel.createFloatArray();
    this.expression_status_ = ((HashMap)paramParcel.readSerializable());
    this.mTTFaceOriginDataModel = ((TTFaceOriginDataModel)paramParcel.readSerializable());
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.light.bean.LightFaceFeature
 * JD-Core Version:    0.7.0.1
 */