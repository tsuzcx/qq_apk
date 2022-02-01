package me.weishu.epic.art.arch;

import java.nio.ByteOrder;

public class Thumb2
  extends ShellCode
{
  public byte[] createBridgeJump(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    byte[] arrayOfByte = new byte[60];
    byte[] tmp8_6 = arrayOfByte;
    tmp8_6[0] = -33;
    byte[] tmp13_8 = tmp8_6;
    tmp13_8[1] = -8;
    byte[] tmp18_13 = tmp13_8;
    tmp18_13[2] = 48;
    byte[] tmp23_18 = tmp18_13;
    tmp23_18[3] = -64;
    byte[] tmp28_23 = tmp23_18;
    tmp28_23[4] = 96;
    byte[] tmp33_28 = tmp28_23;
    tmp33_28[5] = 69;
    byte[] tmp38_33 = tmp33_28;
    tmp38_33[6] = 64;
    byte[] tmp44_38 = tmp38_33;
    tmp44_38[7] = -16;
    byte[] tmp50_44 = tmp44_38;
    tmp50_44[8] = 25;
    byte[] tmp56_50 = tmp50_44;
    tmp56_50[9] = -128;
    byte[] tmp62_56 = tmp56_50;
    tmp62_56[10] = 8;
    byte[] tmp68_62 = tmp62_56;
    tmp68_62[11] = 72;
    byte[] tmp74_68 = tmp68_62;
    tmp74_68[12] = -33;
    byte[] tmp80_74 = tmp74_68;
    tmp80_74[13] = -8;
    byte[] tmp86_80 = tmp80_74;
    tmp86_80[14] = 40;
    byte[] tmp92_86 = tmp86_80;
    tmp92_86[15] = -64;
    byte[] tmp98_92 = tmp92_86;
    tmp98_92[16] = -52;
    byte[] tmp104_98 = tmp98_92;
    tmp104_98[17] = -8;
    byte[] tmp110_104 = tmp104_98;
    tmp110_104[18] = 0;
    byte[] tmp116_110 = tmp110_104;
    tmp116_110[19] = -48;
    byte[] tmp122_116 = tmp116_110;
    tmp122_116[20] = -52;
    byte[] tmp128_122 = tmp122_116;
    tmp128_122[21] = -8;
    byte[] tmp134_128 = tmp128_122;
    tmp134_128[22] = 4;
    byte[] tmp140_134 = tmp134_128;
    tmp140_134[23] = 32;
    byte[] tmp146_140 = tmp140_134;
    tmp146_140[24] = -52;
    byte[] tmp152_146 = tmp146_140;
    tmp152_146[25] = -8;
    byte[] tmp158_152 = tmp152_146;
    tmp158_152[26] = 8;
    byte[] tmp164_158 = tmp158_152;
    tmp164_158[27] = 48;
    byte[] tmp170_164 = tmp164_158;
    tmp170_164[28] = 99;
    byte[] tmp176_170 = tmp170_164;
    tmp176_170[29] = 70;
    byte[] tmp182_176 = tmp176_170;
    tmp182_176[30] = 5;
    byte[] tmp188_182 = tmp182_176;
    tmp188_182[31] = 74;
    byte[] tmp194_188 = tmp188_182;
    tmp194_188[32] = -52;
    byte[] tmp200_194 = tmp194_188;
    tmp200_194[33] = -8;
    byte[] tmp206_200 = tmp200_194;
    tmp206_200[34] = 12;
    byte[] tmp212_206 = tmp206_200;
    tmp212_206[35] = 32;
    byte[] tmp218_212 = tmp212_206;
    tmp218_212[36] = 74;
    byte[] tmp224_218 = tmp218_212;
    tmp224_218[37] = 70;
    byte[] tmp230_224 = tmp224_218;
    tmp230_224[38] = 74;
    byte[] tmp236_230 = tmp230_224;
    tmp236_230[39] = 70;
    byte[] tmp242_236 = tmp236_230;
    tmp242_236[40] = -33;
    byte[] tmp248_242 = tmp242_236;
    tmp248_242[41] = -8;
    byte[] tmp254_248 = tmp248_242;
    tmp254_248[42] = 4;
    byte[] tmp260_254 = tmp254_248;
    tmp260_254[43] = -16;
    byte[] tmp266_260 = tmp260_254;
    tmp266_260[44] = 0;
    byte[] tmp272_266 = tmp266_260;
    tmp272_266[45] = 0;
    byte[] tmp278_272 = tmp272_266;
    tmp278_272[46] = 0;
    byte[] tmp284_278 = tmp278_272;
    tmp284_278[47] = 0;
    byte[] tmp290_284 = tmp284_278;
    tmp290_284[48] = 0;
    byte[] tmp296_290 = tmp290_284;
    tmp296_290[49] = 0;
    byte[] tmp302_296 = tmp296_290;
    tmp302_296[50] = 0;
    byte[] tmp308_302 = tmp302_296;
    tmp308_302[51] = 0;
    byte[] tmp314_308 = tmp308_302;
    tmp314_308[52] = 0;
    byte[] tmp320_314 = tmp314_308;
    tmp320_314[53] = 0;
    byte[] tmp326_320 = tmp320_314;
    tmp326_320[54] = 0;
    byte[] tmp332_326 = tmp326_320;
    tmp332_326[55] = 0;
    byte[] tmp338_332 = tmp332_326;
    tmp338_332[56] = 0;
    byte[] tmp344_338 = tmp338_332;
    tmp344_338[57] = 0;
    byte[] tmp350_344 = tmp344_338;
    tmp350_344[58] = 0;
    byte[] tmp356_350 = tmp350_344;
    tmp356_350[59] = 0;
    tmp356_350;
    writeInt((int)paramLong1, ByteOrder.LITTLE_ENDIAN, tmp23_18, tmp23_18.length - 16);
    writeInt((int)paramLong2, ByteOrder.LITTLE_ENDIAN, tmp23_18, tmp23_18.length - 12);
    writeInt((int)paramLong3, ByteOrder.LITTLE_ENDIAN, tmp23_18, tmp23_18.length - 8);
    writeInt((int)tmp13_8, ByteOrder.LITTLE_ENDIAN, tmp23_18, tmp23_18.length - 4);
    return tmp23_18;
  }
  
  public byte[] createDirectJump(long paramLong)
  {
    byte[] arrayOfByte = new byte[8];
    byte[] tmp6_5 = arrayOfByte;
    tmp6_5[0] = -33;
    byte[] tmp11_6 = tmp6_5;
    tmp11_6[1] = -8;
    byte[] tmp16_11 = tmp11_6;
    tmp16_11[2] = 0;
    byte[] tmp21_16 = tmp16_11;
    tmp21_16[3] = -16;
    byte[] tmp26_21 = tmp21_16;
    tmp26_21[4] = 0;
    byte[] tmp31_26 = tmp26_21;
    tmp31_26[5] = 0;
    byte[] tmp36_31 = tmp31_26;
    tmp36_31[6] = 0;
    byte[] tmp42_36 = tmp36_31;
    tmp42_36[7] = 0;
    tmp42_36;
    writeInt((int)paramLong, ByteOrder.LITTLE_ENDIAN, tmp6_5, tmp6_5.length - 4);
    return tmp6_5;
  }
  
  public String getName()
  {
    return "Thumb2";
  }
  
  public int sizeOfBridgeJump()
  {
    return 60;
  }
  
  public int sizeOfDirectJump()
  {
    return 12;
  }
  
  public long toMem(long paramLong)
  {
    return 0xFFFFFFFE & paramLong;
  }
  
  public long toPC(long paramLong)
  {
    return toMem(paramLong) + 1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     me.weishu.epic.art.arch.Thumb2
 * JD-Core Version:    0.7.0.1
 */