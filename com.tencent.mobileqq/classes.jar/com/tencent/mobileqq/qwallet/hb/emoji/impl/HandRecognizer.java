package com.tencent.mobileqq.qwallet.hb.emoji.impl;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;

public class HandRecognizer
{
  public static final String a = "HandRecognizer";
  public YtHandBox a;
  private Runnable a;
  public volatile boolean a;
  public final String[] a;
  public YtHandBox b;
  public final String b;
  public boolean b;
  public final String[] b;
  public final String c;
  public boolean c;
  public final String d = "v3.0_int8_resnet18_3MB_1130.pb.rapidnetmodel_nhwc";
  public final String e = "v3.0_int8_resnet18_3MB_1130.pb_bin.rapidnetproto_nhwc";
  public final String f = "add_p_tu_1130_800k.rpdm";
  
  private HandRecognizer()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[] { "libYTHandDetector.so", "libnative-lib.so" };
    this.jdField_b_of_type_ArrayOfJavaLangString = new String[] { "YTHandDetector", "native-lib" };
    this.jdField_b_of_type_JavaLangString = "v3.0_1130_add_lift_epoch40.rapidnetmodel_nchw";
    this.jdField_c_of_type_JavaLangString = "v3.0_1130_add_lift_epoch40_bin.rapidnetproto_nchw_mod";
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbEmojiImplYtHandBox = new YtHandBox();
    this.jdField_b_of_type_ComTencentMobileqqQwalletHbEmojiImplYtHandBox = new YtHandBox();
    this.jdField_a_of_type_JavaLangRunnable = new HandRecognizer.1(this);
  }
  
  public native int doHandAlignment(YtHandBox paramYtHandBox1, YtHandBox paramYtHandBox2);
  
  public native int doHandClassify(YtHandBox paramYtHandBox, YtHandLabel paramYtHandLabel);
  
  public native int doHandClassifyWithGesture(YtHandBox paramYtHandBox, int paramInt, YtHandClassifyResult paramYtHandClassifyResult);
  
  public native int doHandDetection(YtHandBox paramYtHandBox);
  
  public native int doHandStable(YtHandBox paramYtHandBox1, YtHandBox paramYtHandBox2);
  
  public native String getNameOfLabel(int paramInt);
  
  public native int initHandAlignment(String paramString);
  
  public native int initHandClassify(String paramString1, String paramString2);
  
  public native int initHandDetection(String paramString1, String paramString2);
  
  public native int releaseHandAlignment();
  
  public native int releaseHandClassify();
  
  public native int releaseHandDetection();
  
  public native Bitmap updateBufferAndCvt2Bitmap(byte[] paramArrayOfByte, int paramInt1, int paramInt2, Bitmap.Config paramConfig);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.emoji.impl.HandRecognizer
 * JD-Core Version:    0.7.0.1
 */