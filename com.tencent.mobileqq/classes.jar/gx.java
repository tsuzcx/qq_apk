import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public final class gx
{
  private static final gx[] jdField_a_of_type_ArrayOfGx = ;
  private final int jdField_a_of_type_Int;
  private final gz[] jdField_a_of_type_ArrayOfGz;
  private final int b;
  
  private gx(int paramInt, int[] paramArrayOfInt, gz... paramVarArgs)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ArrayOfGz = paramVarArgs;
    int k = paramVarArgs[0].a();
    paramArrayOfInt = paramVarArgs[0].a();
    int m = paramArrayOfInt.length;
    int i = 0;
    paramInt = j;
    while (paramInt < m)
    {
      paramVarArgs = paramArrayOfInt[paramInt];
      j = paramVarArgs.a();
      i += (paramVarArgs.b() + k) * j;
      paramInt += 1;
    }
    this.b = i;
  }
  
  public static gx a(int paramInt)
  {
    if ((paramInt < 1) || (paramInt > 40)) {
      throw new IllegalArgumentException();
    }
    return jdField_a_of_type_ArrayOfGx[(paramInt - 1)];
  }
  
  private static gx[] a()
  {
    Object localObject1 = new gz(7, new gy[] { new gy(1, 19) });
    Object localObject2 = new gz(10, new gy[] { new gy(1, 16) });
    Object localObject3 = new gz(13, new gy[] { new gy(1, 13) });
    Object localObject4 = new gz(17, new gy[] { new gy(1, 9) });
    localObject1 = new gx(1, new int[0], new gz[] { localObject1, localObject2, localObject3, localObject4 });
    localObject2 = new gz(10, new gy[] { new gy(1, 34) });
    localObject3 = new gz(16, new gy[] { new gy(1, 28) });
    localObject4 = new gz(22, new gy[] { new gy(1, 22) });
    Object localObject5 = new gz(28, new gy[] { new gy(1, 16) });
    localObject2 = new gx(2, new int[] { 6, 18 }, new gz[] { localObject2, localObject3, localObject4, localObject5 });
    localObject3 = new gz(15, new gy[] { new gy(1, 55) });
    localObject4 = new gz(26, new gy[] { new gy(1, 44) });
    localObject5 = new gz(18, new gy[] { new gy(2, 17) });
    Object localObject6 = new gz(22, new gy[] { new gy(2, 13) });
    localObject3 = new gx(3, new int[] { 6, 22 }, new gz[] { localObject3, localObject4, localObject5, localObject6 });
    localObject4 = new gz(20, new gy[] { new gy(1, 80) });
    localObject5 = new gz(18, new gy[] { new gy(2, 32) });
    localObject6 = new gz(26, new gy[] { new gy(2, 24) });
    Object localObject7 = new gz(16, new gy[] { new gy(4, 9) });
    localObject4 = new gx(4, new int[] { 6, 26 }, new gz[] { localObject4, localObject5, localObject6, localObject7 });
    localObject5 = new gz(26, new gy[] { new gy(1, 108) });
    localObject6 = new gz(24, new gy[] { new gy(2, 43) });
    localObject7 = new gz(18, new gy[] { new gy(2, 15), new gy(2, 16) });
    Object localObject8 = new gz(22, new gy[] { new gy(2, 11), new gy(2, 12) });
    localObject5 = new gx(5, new int[] { 6, 30 }, new gz[] { localObject5, localObject6, localObject7, localObject8 });
    localObject6 = new gz(18, new gy[] { new gy(2, 68) });
    localObject7 = new gz(16, new gy[] { new gy(4, 27) });
    localObject8 = new gz(24, new gy[] { new gy(4, 19) });
    Object localObject9 = new gz(28, new gy[] { new gy(4, 15) });
    localObject6 = new gx(6, new int[] { 6, 34 }, new gz[] { localObject6, localObject7, localObject8, localObject9 });
    localObject7 = new gz(20, new gy[] { new gy(2, 78) });
    localObject8 = new gz(18, new gy[] { new gy(4, 31) });
    localObject9 = new gz(18, new gy[] { new gy(2, 14), new gy(4, 15) });
    Object localObject10 = new gz(26, new gy[] { new gy(4, 13), new gy(1, 14) });
    localObject7 = new gx(7, new int[] { 6, 22, 38 }, new gz[] { localObject7, localObject8, localObject9, localObject10 });
    localObject8 = new gz(24, new gy[] { new gy(2, 97) });
    localObject9 = new gz(22, new gy[] { new gy(2, 38), new gy(2, 39) });
    localObject10 = new gz(22, new gy[] { new gy(4, 18), new gy(2, 19) });
    Object localObject11 = new gz(26, new gy[] { new gy(4, 14), new gy(2, 15) });
    localObject8 = new gx(8, new int[] { 6, 24, 42 }, new gz[] { localObject8, localObject9, localObject10, localObject11 });
    localObject9 = new gz(30, new gy[] { new gy(2, 116) });
    localObject10 = new gz(22, new gy[] { new gy(3, 36), new gy(2, 37) });
    localObject11 = new gz(20, new gy[] { new gy(4, 16), new gy(4, 17) });
    Object localObject12 = new gz(24, new gy[] { new gy(4, 12), new gy(4, 13) });
    localObject9 = new gx(9, new int[] { 6, 26, 46 }, new gz[] { localObject9, localObject10, localObject11, localObject12 });
    localObject10 = new gz(18, new gy[] { new gy(2, 68), new gy(2, 69) });
    localObject11 = new gz(26, new gy[] { new gy(4, 43), new gy(1, 44) });
    localObject12 = new gz(24, new gy[] { new gy(6, 19), new gy(2, 20) });
    Object localObject13 = new gz(28, new gy[] { new gy(6, 15), new gy(2, 16) });
    localObject10 = new gx(10, new int[] { 6, 28, 50 }, new gz[] { localObject10, localObject11, localObject12, localObject13 });
    localObject11 = new gz(20, new gy[] { new gy(4, 81) });
    localObject12 = new gz(30, new gy[] { new gy(1, 50), new gy(4, 51) });
    localObject13 = new gz(28, new gy[] { new gy(4, 22), new gy(4, 23) });
    Object localObject14 = new gz(24, new gy[] { new gy(3, 12), new gy(8, 13) });
    localObject11 = new gx(11, new int[] { 6, 30, 54 }, new gz[] { localObject11, localObject12, localObject13, localObject14 });
    localObject12 = new gz(24, new gy[] { new gy(2, 92), new gy(2, 93) });
    localObject13 = new gz(22, new gy[] { new gy(6, 36), new gy(2, 37) });
    localObject14 = new gz(26, new gy[] { new gy(4, 20), new gy(6, 21) });
    Object localObject15 = new gz(28, new gy[] { new gy(7, 14), new gy(4, 15) });
    localObject12 = new gx(12, new int[] { 6, 32, 58 }, new gz[] { localObject12, localObject13, localObject14, localObject15 });
    localObject13 = new gz(26, new gy[] { new gy(4, 107) });
    localObject14 = new gz(22, new gy[] { new gy(8, 37), new gy(1, 38) });
    localObject15 = new gz(24, new gy[] { new gy(8, 20), new gy(4, 21) });
    Object localObject16 = new gz(22, new gy[] { new gy(12, 11), new gy(4, 12) });
    localObject13 = new gx(13, new int[] { 6, 34, 62 }, new gz[] { localObject13, localObject14, localObject15, localObject16 });
    localObject14 = new gz(30, new gy[] { new gy(3, 115), new gy(1, 116) });
    localObject15 = new gz(24, new gy[] { new gy(4, 40), new gy(5, 41) });
    localObject16 = new gz(20, new gy[] { new gy(11, 16), new gy(5, 17) });
    Object localObject17 = new gz(24, new gy[] { new gy(11, 12), new gy(5, 13) });
    localObject14 = new gx(14, new int[] { 6, 26, 46, 66 }, new gz[] { localObject14, localObject15, localObject16, localObject17 });
    localObject15 = new gz(22, new gy[] { new gy(5, 87), new gy(1, 88) });
    localObject16 = new gz(24, new gy[] { new gy(5, 41), new gy(5, 42) });
    localObject17 = new gz(30, new gy[] { new gy(5, 24), new gy(7, 25) });
    Object localObject18 = new gz(24, new gy[] { new gy(11, 12), new gy(7, 13) });
    localObject15 = new gx(15, new int[] { 6, 26, 48, 70 }, new gz[] { localObject15, localObject16, localObject17, localObject18 });
    localObject16 = new gz(24, new gy[] { new gy(5, 98), new gy(1, 99) });
    localObject17 = new gz(28, new gy[] { new gy(7, 45), new gy(3, 46) });
    localObject18 = new gz(24, new gy[] { new gy(15, 19), new gy(2, 20) });
    Object localObject19 = new gz(30, new gy[] { new gy(3, 15), new gy(13, 16) });
    localObject16 = new gx(16, new int[] { 6, 26, 50, 74 }, new gz[] { localObject16, localObject17, localObject18, localObject19 });
    localObject17 = new gz(28, new gy[] { new gy(1, 107), new gy(5, 108) });
    localObject18 = new gz(28, new gy[] { new gy(10, 46), new gy(1, 47) });
    localObject19 = new gz(28, new gy[] { new gy(1, 22), new gy(15, 23) });
    Object localObject20 = new gz(28, new gy[] { new gy(2, 14), new gy(17, 15) });
    localObject17 = new gx(17, new int[] { 6, 30, 54, 78 }, new gz[] { localObject17, localObject18, localObject19, localObject20 });
    localObject18 = new gz(30, new gy[] { new gy(5, 120), new gy(1, 121) });
    localObject19 = new gz(26, new gy[] { new gy(9, 43), new gy(4, 44) });
    localObject20 = new gz(28, new gy[] { new gy(17, 22), new gy(1, 23) });
    Object localObject21 = new gz(28, new gy[] { new gy(2, 14), new gy(19, 15) });
    localObject18 = new gx(18, new int[] { 6, 30, 56, 82 }, new gz[] { localObject18, localObject19, localObject20, localObject21 });
    localObject19 = new gz(28, new gy[] { new gy(3, 113), new gy(4, 114) });
    localObject20 = new gz(26, new gy[] { new gy(3, 44), new gy(11, 45) });
    localObject21 = new gz(26, new gy[] { new gy(17, 21), new gy(4, 22) });
    Object localObject22 = new gz(26, new gy[] { new gy(9, 13), new gy(16, 14) });
    localObject19 = new gx(19, new int[] { 6, 30, 58, 86 }, new gz[] { localObject19, localObject20, localObject21, localObject22 });
    localObject20 = new gz(28, new gy[] { new gy(3, 107), new gy(5, 108) });
    localObject21 = new gz(26, new gy[] { new gy(3, 41), new gy(13, 42) });
    localObject22 = new gz(30, new gy[] { new gy(15, 24), new gy(5, 25) });
    Object localObject23 = new gz(28, new gy[] { new gy(15, 15), new gy(10, 16) });
    localObject20 = new gx(20, new int[] { 6, 34, 62, 90 }, new gz[] { localObject20, localObject21, localObject22, localObject23 });
    localObject21 = new gz(28, new gy[] { new gy(4, 116), new gy(4, 117) });
    localObject22 = new gz(26, new gy[] { new gy(17, 42) });
    localObject23 = new gz(28, new gy[] { new gy(17, 22), new gy(6, 23) });
    Object localObject24 = new gz(30, new gy[] { new gy(19, 16), new gy(6, 17) });
    localObject21 = new gx(21, new int[] { 6, 28, 50, 72, 94 }, new gz[] { localObject21, localObject22, localObject23, localObject24 });
    localObject22 = new gz(28, new gy[] { new gy(2, 111), new gy(7, 112) });
    localObject23 = new gz(28, new gy[] { new gy(17, 46) });
    localObject24 = new gz(30, new gy[] { new gy(7, 24), new gy(16, 25) });
    Object localObject25 = new gz(24, new gy[] { new gy(34, 13) });
    localObject22 = new gx(22, new int[] { 6, 26, 50, 74, 98 }, new gz[] { localObject22, localObject23, localObject24, localObject25 });
    localObject23 = new gz(30, new gy[] { new gy(4, 121), new gy(5, 122) });
    localObject24 = new gz(28, new gy[] { new gy(4, 47), new gy(14, 48) });
    localObject25 = new gz(30, new gy[] { new gy(11, 24), new gy(14, 25) });
    Object localObject26 = new gz(30, new gy[] { new gy(16, 15), new gy(14, 16) });
    localObject23 = new gx(23, new int[] { 6, 30, 54, 78, 102 }, new gz[] { localObject23, localObject24, localObject25, localObject26 });
    localObject24 = new gz(30, new gy[] { new gy(6, 117), new gy(4, 118) });
    localObject25 = new gz(28, new gy[] { new gy(6, 45), new gy(14, 46) });
    localObject26 = new gz(30, new gy[] { new gy(11, 24), new gy(16, 25) });
    Object localObject27 = new gz(30, new gy[] { new gy(30, 16), new gy(2, 17) });
    localObject24 = new gx(24, new int[] { 6, 28, 54, 80, 106 }, new gz[] { localObject24, localObject25, localObject26, localObject27 });
    localObject25 = new gz(26, new gy[] { new gy(8, 106), new gy(4, 107) });
    localObject26 = new gz(28, new gy[] { new gy(8, 47), new gy(13, 48) });
    localObject27 = new gz(30, new gy[] { new gy(7, 24), new gy(22, 25) });
    Object localObject28 = new gz(30, new gy[] { new gy(22, 15), new gy(13, 16) });
    localObject25 = new gx(25, new int[] { 6, 32, 58, 84, 110 }, new gz[] { localObject25, localObject26, localObject27, localObject28 });
    localObject26 = new gz(28, new gy[] { new gy(10, 114), new gy(2, 115) });
    localObject27 = new gz(28, new gy[] { new gy(19, 46), new gy(4, 47) });
    localObject28 = new gz(28, new gy[] { new gy(28, 22), new gy(6, 23) });
    Object localObject29 = new gz(30, new gy[] { new gy(33, 16), new gy(4, 17) });
    localObject26 = new gx(26, new int[] { 6, 30, 58, 86, 114 }, new gz[] { localObject26, localObject27, localObject28, localObject29 });
    localObject27 = new gz(30, new gy[] { new gy(8, 122), new gy(4, 123) });
    localObject28 = new gz(28, new gy[] { new gy(22, 45), new gy(3, 46) });
    localObject29 = new gz(30, new gy[] { new gy(8, 23), new gy(26, 24) });
    Object localObject30 = new gz(30, new gy[] { new gy(12, 15), new gy(28, 16) });
    localObject27 = new gx(27, new int[] { 6, 34, 62, 90, 118 }, new gz[] { localObject27, localObject28, localObject29, localObject30 });
    localObject28 = new gz(30, new gy[] { new gy(3, 117), new gy(10, 118) });
    localObject29 = new gz(28, new gy[] { new gy(3, 45), new gy(23, 46) });
    localObject30 = new gz(30, new gy[] { new gy(4, 24), new gy(31, 25) });
    Object localObject31 = new gz(30, new gy[] { new gy(11, 15), new gy(31, 16) });
    localObject28 = new gx(28, new int[] { 6, 26, 50, 74, 98, 122 }, new gz[] { localObject28, localObject29, localObject30, localObject31 });
    localObject29 = new gz(30, new gy[] { new gy(7, 116), new gy(7, 117) });
    localObject30 = new gz(28, new gy[] { new gy(21, 45), new gy(7, 46) });
    localObject31 = new gz(30, new gy[] { new gy(1, 23), new gy(37, 24) });
    Object localObject32 = new gz(30, new gy[] { new gy(19, 15), new gy(26, 16) });
    localObject29 = new gx(29, new int[] { 6, 30, 54, 78, 102, 126 }, new gz[] { localObject29, localObject30, localObject31, localObject32 });
    localObject30 = new gz(30, new gy[] { new gy(5, 115), new gy(10, 116) });
    localObject31 = new gz(28, new gy[] { new gy(19, 47), new gy(10, 48) });
    localObject32 = new gz(30, new gy[] { new gy(15, 24), new gy(25, 25) });
    Object localObject33 = new gz(30, new gy[] { new gy(23, 15), new gy(25, 16) });
    localObject30 = new gx(30, new int[] { 6, 26, 52, 78, 104, 130 }, new gz[] { localObject30, localObject31, localObject32, localObject33 });
    localObject31 = new gz(30, new gy[] { new gy(13, 115), new gy(3, 116) });
    localObject32 = new gz(28, new gy[] { new gy(2, 46), new gy(29, 47) });
    localObject33 = new gz(30, new gy[] { new gy(42, 24), new gy(1, 25) });
    Object localObject34 = new gz(30, new gy[] { new gy(23, 15), new gy(28, 16) });
    localObject31 = new gx(31, new int[] { 6, 30, 56, 82, 108, 134 }, new gz[] { localObject31, localObject32, localObject33, localObject34 });
    localObject32 = new gz(30, new gy[] { new gy(17, 115) });
    localObject33 = new gz(28, new gy[] { new gy(10, 46), new gy(23, 47) });
    localObject34 = new gz(30, new gy[] { new gy(10, 24), new gy(35, 25) });
    Object localObject35 = new gz(30, new gy[] { new gy(19, 15), new gy(35, 16) });
    localObject32 = new gx(32, new int[] { 6, 34, 60, 86, 112, 138 }, new gz[] { localObject32, localObject33, localObject34, localObject35 });
    localObject33 = new gz(30, new gy[] { new gy(17, 115), new gy(1, 116) });
    localObject34 = new gz(28, new gy[] { new gy(14, 46), new gy(21, 47) });
    localObject35 = new gz(30, new gy[] { new gy(29, 24), new gy(19, 25) });
    Object localObject36 = new gz(30, new gy[] { new gy(11, 15), new gy(46, 16) });
    localObject33 = new gx(33, new int[] { 6, 30, 58, 86, 114, 142 }, new gz[] { localObject33, localObject34, localObject35, localObject36 });
    localObject34 = new gz(30, new gy[] { new gy(13, 115), new gy(6, 116) });
    localObject35 = new gz(28, new gy[] { new gy(14, 46), new gy(23, 47) });
    localObject36 = new gz(30, new gy[] { new gy(44, 24), new gy(7, 25) });
    Object localObject37 = new gz(30, new gy[] { new gy(59, 16), new gy(1, 17) });
    localObject34 = new gx(34, new int[] { 6, 34, 62, 90, 118, 146 }, new gz[] { localObject34, localObject35, localObject36, localObject37 });
    localObject35 = new gz(30, new gy[] { new gy(12, 121), new gy(7, 122) });
    localObject36 = new gz(28, new gy[] { new gy(12, 47), new gy(26, 48) });
    localObject37 = new gz(30, new gy[] { new gy(39, 24), new gy(14, 25) });
    Object localObject38 = new gz(30, new gy[] { new gy(22, 15), new gy(41, 16) });
    localObject35 = new gx(35, new int[] { 6, 30, 54, 78, 102, 126, 150 }, new gz[] { localObject35, localObject36, localObject37, localObject38 });
    localObject36 = new gz(30, new gy[] { new gy(6, 121), new gy(14, 122) });
    localObject37 = new gz(28, new gy[] { new gy(6, 47), new gy(34, 48) });
    localObject38 = new gz(30, new gy[] { new gy(46, 24), new gy(10, 25) });
    Object localObject39 = new gz(30, new gy[] { new gy(2, 15), new gy(64, 16) });
    localObject36 = new gx(36, new int[] { 6, 24, 50, 76, 102, 128, 154 }, new gz[] { localObject36, localObject37, localObject38, localObject39 });
    localObject37 = new gz(30, new gy[] { new gy(17, 122), new gy(4, 123) });
    localObject38 = new gz(28, new gy[] { new gy(29, 46), new gy(14, 47) });
    localObject39 = new gz(30, new gy[] { new gy(49, 24), new gy(10, 25) });
    gz localgz1 = new gz(30, new gy[] { new gy(24, 15), new gy(46, 16) });
    localObject37 = new gx(37, new int[] { 6, 28, 54, 80, 106, 132, 158 }, new gz[] { localObject37, localObject38, localObject39, localgz1 });
    localObject38 = new gz(30, new gy[] { new gy(4, 122), new gy(18, 123) });
    localObject39 = new gz(28, new gy[] { new gy(13, 46), new gy(32, 47) });
    localgz1 = new gz(30, new gy[] { new gy(48, 24), new gy(14, 25) });
    gz localgz2 = new gz(30, new gy[] { new gy(42, 15), new gy(32, 16) });
    localObject38 = new gx(38, new int[] { 6, 32, 58, 84, 110, 136, 162 }, new gz[] { localObject38, localObject39, localgz1, localgz2 });
    localObject39 = new gz(30, new gy[] { new gy(20, 117), new gy(4, 118) });
    localgz1 = new gz(28, new gy[] { new gy(40, 47), new gy(7, 48) });
    localgz2 = new gz(30, new gy[] { new gy(43, 24), new gy(22, 25) });
    gz localgz3 = new gz(30, new gy[] { new gy(10, 15), new gy(67, 16) });
    localObject39 = new gx(39, new int[] { 6, 26, 54, 82, 110, 138, 166 }, new gz[] { localObject39, localgz1, localgz2, localgz3 });
    localgz1 = new gz(30, new gy[] { new gy(19, 118), new gy(6, 119) });
    localgz2 = new gz(28, new gy[] { new gy(18, 47), new gy(31, 48) });
    localgz3 = new gz(30, new gy[] { new gy(34, 24), new gy(34, 25) });
    gz localgz4 = new gz(30, new gy[] { new gy(20, 15), new gy(61, 16) });
    return new gx[] { localObject1, localObject2, localObject3, localObject4, localObject5, localObject6, localObject7, localObject8, localObject9, localObject10, localObject11, localObject12, localObject13, localObject14, localObject15, localObject16, localObject17, localObject18, localObject19, localObject20, localObject21, localObject22, localObject23, localObject24, localObject25, localObject26, localObject27, localObject28, localObject29, localObject30, localObject31, localObject32, localObject33, localObject34, localObject35, localObject36, localObject37, localObject38, localObject39, new gx(40, new int[] { 6, 30, 58, 86, 114, 142, 170 }, new gz[] { localgz1, localgz2, localgz3, localgz4 }) };
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public gz a(ErrorCorrectionLevel paramErrorCorrectionLevel)
  {
    return this.jdField_a_of_type_ArrayOfGz[paramErrorCorrectionLevel.ordinal()];
  }
  
  public int b()
  {
    return this.b;
  }
  
  public int c()
  {
    return this.jdField_a_of_type_Int * 4 + 17;
  }
  
  public String toString()
  {
    return String.valueOf(this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     gx
 * JD-Core Version:    0.7.0.1
 */