package com.tencent.videocut.utils.security;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/utils/security/Base64$Encoder;", "Lcom/tencent/videocut/utils/security/Base64$Coder;", "flags", "", "output", "", "(I[B)V", "alphabet", "count", "do_cr", "", "getDo_cr", "()Z", "do_newline", "getDo_newline", "do_padding", "getDo_padding", "tail", "tailLen", "getTailLen", "()I", "setTailLen", "(I)V", "maxOutputSize", "len", "process", "input", "offset", "finish", "Companion", "lib_utils_release"}, k=1, mv={1, 4, 2})
public final class Base64$Encoder
  extends Base64.Coder
{
  @NotNull
  public static final Base64.Encoder.Companion a = new Base64.Encoder.Companion(null);
  private static final byte[] b;
  private static final byte[] c;
  
  static
  {
    int i = (byte)65;
    int j = (byte)66;
    int k = (byte)67;
    int m = (byte)68;
    int n = (byte)69;
    int i1 = (byte)70;
    int i2 = (byte)71;
    int i3 = (byte)72;
    int i4 = (byte)73;
    int i5 = (byte)74;
    int i6 = (byte)75;
    int i7 = (byte)76;
    int i8 = (byte)77;
    int i9 = (byte)78;
    int i10 = (byte)79;
    int i11 = (byte)80;
    int i12 = (byte)81;
    int i13 = (byte)82;
    int i14 = (byte)83;
    int i15 = (byte)84;
    int i16 = (byte)85;
    int i17 = (byte)86;
    int i18 = (byte)87;
    int i19 = (byte)88;
    int i20 = (byte)89;
    int i21 = (byte)90;
    int i22 = (byte)97;
    int i23 = (byte)98;
    int i24 = (byte)99;
    int i25 = (byte)100;
    int i26 = (byte)101;
    int i27 = (byte)102;
    int i28 = (byte)103;
    int i29 = (byte)104;
    int i30 = (byte)105;
    int i31 = (byte)106;
    int i32 = (byte)107;
    int i33 = (byte)108;
    int i34 = (byte)109;
    int i35 = (byte)110;
    int i36 = (byte)111;
    int i37 = (byte)112;
    int i38 = (byte)113;
    int i39 = (byte)114;
    int i40 = (byte)115;
    int i41 = (byte)116;
    int i42 = (byte)117;
    int i43 = (byte)118;
    int i44 = (byte)119;
    int i45 = (byte)120;
    int i46 = (byte)121;
    int i47 = (byte)122;
    int i48 = (byte)48;
    int i49 = (byte)49;
    int i50 = (byte)50;
    int i51 = (byte)51;
    int i52 = (byte)52;
    int i53 = (byte)53;
    int i54 = (byte)54;
    int i55 = (byte)55;
    int i56 = (byte)56;
    int i57 = (byte)57;
    b = new byte[] { i, j, k, m, n, i1, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15, i16, i17, i18, i19, i20, i21, i22, i23, i24, i25, i26, i27, i28, i29, i30, i31, i32, i33, i34, i35, i36, i37, i38, i39, i40, i41, i42, i43, i44, i45, i46, i47, i48, i49, i50, i51, i52, i53, i54, i55, i56, i57, (byte)43, (byte)47 };
    c = new byte[] { i, j, k, m, n, i1, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15, i16, i17, i18, i19, i20, i21, i22, i23, i24, i25, i26, i27, i28, i29, i30, i31, i32, i33, i34, i35, i36, i37, i38, i39, i40, i41, i42, i43, i44, i45, i46, i47, i48, i49, i50, i51, i52, i53, i54, i55, i56, i57, (byte)45, (byte)95 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.utils.security.Base64.Encoder
 * JD-Core Version:    0.7.0.1
 */