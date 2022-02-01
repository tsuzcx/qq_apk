package com.tencent.tbs.one.impl.loader.dex;

import java.io.Closeable;
import java.io.File;
import java.util.UnknownFormatConversionException;

public class Elf
  implements Closeable
{
  static final int EI_CLASS = 4;
  static final int EI_DATA = 5;
  static final int EI_NIDENT = 16;
  static final char[] ElfMagic = { 127, 69, 76, 70, 0 };
  static final int PF_MASKOS = 267386880;
  static final int PF_MASKPROC = -268435456;
  static final int PF_R = 4;
  static final int PF_W = 2;
  static final int PF_X = 1;
  static final int PT_DYNAMIC = 2;
  static final int PT_INTERP = 3;
  static final int PT_LOAD = 1;
  static final int PT_NOTE = 4;
  static final int PT_NULL = 0;
  static final int PT_PHDR = 6;
  static final int PT_SHLIB = 5;
  static final int PT_TLS = 7;
  public static final String SHN_DYNAMIC = ".dynamic";
  public static final String SHN_DYNSTR = ".dynstr";
  public static final String SHN_DYNSYM = ".dynsym";
  public static final String SHN_HASH = ".hash";
  public static final String SHN_RODATA = ".rodata";
  public static final String SHN_SHSTRTAB = ".shstrtab";
  public static final String SHN_TEXT = ".text";
  static final int SHN_UNDEF = 0;
  static final int SHT_DYNAMIC = 6;
  static final int SHT_DYNSYM = 11;
  static final int SHT_HASH = 5;
  static final int SHT_PROGBITS = 1;
  static final int SHT_RELA = 4;
  static final int SHT_STRTAB = 3;
  static final int SHT_SYMTAB = 2;
  final char[] e_ident = new char[16];
  byte[] mDynStringTable;
  Elf.Elf_Sym[] mDynamicSymbols;
  private final Elf.Ehdr mHeader;
  Elf.Elf_Phdr[] mProgHeaders;
  boolean mReadMore;
  private final DataReader mReader;
  private final Elf.Elf_Shdr[] mSectionHeaders;
  private byte[] mStringTable;
  
  public Elf(File paramFile)
  {
    DataReader localDataReader = new DataReader(paramFile);
    this.mReader = localDataReader;
    localDataReader.readBytes(this.e_ident);
    if (!checkMagic()) {
      throw new UnknownFormatConversionException("Invalid elf magic: " + paramFile);
    }
    localDataReader.setIsLittleEndian(isLittleEndian());
    boolean bool = is64bit();
    int i;
    label238:
    Object localObject;
    if (bool)
    {
      paramFile = new Elf.Elf64_Ehdr();
      paramFile.e_type = localDataReader.readShort();
      paramFile.e_machine = localDataReader.readShort();
      paramFile.e_version = localDataReader.readInt();
      paramFile.e_entry = localDataReader.readLong();
      paramFile.e_phoff = localDataReader.readLong();
      paramFile.e_shoff = localDataReader.readLong();
      this.mHeader = paramFile;
      paramFile = this.mHeader;
      paramFile.e_flags = localDataReader.readInt();
      paramFile.e_ehsize = localDataReader.readShort();
      paramFile.e_phentsize = localDataReader.readShort();
      paramFile.e_phnum = localDataReader.readShort();
      paramFile.e_shentsize = localDataReader.readShort();
      paramFile.e_shnum = localDataReader.readShort();
      paramFile.e_shstrndx = localDataReader.readShort();
      this.mSectionHeaders = new Elf.Elf_Shdr[paramFile.e_shnum];
      i = 0;
      if (i >= paramFile.e_shnum) {
        break label581;
      }
      localDataReader.seek(paramFile.getSectionOffset() + paramFile.e_shentsize * i);
      if (!bool) {
        break label461;
      }
      localObject = new Elf.Elf64_Shdr();
      ((Elf.Elf64_Shdr)localObject).sh_name = localDataReader.readInt();
      ((Elf.Elf64_Shdr)localObject).sh_type = localDataReader.readInt();
      ((Elf.Elf64_Shdr)localObject).sh_flags = localDataReader.readLong();
      ((Elf.Elf64_Shdr)localObject).sh_addr = localDataReader.readLong();
      ((Elf.Elf64_Shdr)localObject).sh_offset = localDataReader.readLong();
      ((Elf.Elf64_Shdr)localObject).sh_size = localDataReader.readLong();
      ((Elf.Elf64_Shdr)localObject).sh_link = localDataReader.readInt();
      ((Elf.Elf64_Shdr)localObject).sh_info = localDataReader.readInt();
      ((Elf.Elf64_Shdr)localObject).sh_addralign = localDataReader.readLong();
      ((Elf.Elf64_Shdr)localObject).sh_entsize = localDataReader.readLong();
      this.mSectionHeaders[i] = localObject;
    }
    for (;;)
    {
      i += 1;
      break label238;
      paramFile = new Elf.Elf32_Ehdr();
      paramFile.e_type = localDataReader.readShort();
      paramFile.e_machine = localDataReader.readShort();
      paramFile.e_version = localDataReader.readInt();
      paramFile.e_entry = localDataReader.readInt();
      paramFile.e_phoff = localDataReader.readInt();
      paramFile.e_shoff = localDataReader.readInt();
      this.mHeader = paramFile;
      break;
      label461:
      localObject = new Elf.Elf32_Shdr();
      ((Elf.Elf32_Shdr)localObject).sh_name = localDataReader.readInt();
      ((Elf.Elf32_Shdr)localObject).sh_type = localDataReader.readInt();
      ((Elf.Elf32_Shdr)localObject).sh_flags = localDataReader.readInt();
      ((Elf.Elf32_Shdr)localObject).sh_addr = localDataReader.readInt();
      ((Elf.Elf32_Shdr)localObject).sh_offset = localDataReader.readInt();
      ((Elf.Elf32_Shdr)localObject).sh_size = localDataReader.readInt();
      ((Elf.Elf32_Shdr)localObject).sh_link = localDataReader.readInt();
      ((Elf.Elf32_Shdr)localObject).sh_info = localDataReader.readInt();
      ((Elf.Elf32_Shdr)localObject).sh_addralign = localDataReader.readInt();
      ((Elf.Elf32_Shdr)localObject).sh_entsize = localDataReader.readInt();
      this.mSectionHeaders[i] = localObject;
    }
    label581:
    if ((paramFile.e_shstrndx > -1) && (paramFile.e_shstrndx < this.mSectionHeaders.length))
    {
      localObject = this.mSectionHeaders[paramFile.e_shstrndx];
      if (((Elf.Elf_Shdr)localObject).sh_type == 3)
      {
        this.mStringTable = new byte[((Elf.Elf_Shdr)localObject).getSize()];
        localDataReader.seek(((Elf.Elf_Shdr)localObject).getOffset());
        localDataReader.readBytes(this.mStringTable);
        if (this.mReadMore) {
          readMore();
        }
        return;
      }
      throw new UnknownFormatConversionException("Wrong string section e_shstrndx=" + paramFile.e_shstrndx);
    }
    throw new UnknownFormatConversionException("Invalid e_shstrndx=" + paramFile.e_shstrndx);
  }
  
  public Elf(String paramString)
  {
    this(new File(paramString));
  }
  
  public Elf(String paramString, boolean paramBoolean)
  {
    this(paramString);
    if (paramBoolean) {
      this.mReader.close();
    }
  }
  
  /* Error */
  public static boolean isElf(File paramFile)
  {
    // Byte code:
    //   0: new 317	java/io/RandomAccessFile
    //   3: dup
    //   4: aload_0
    //   5: ldc_w 319
    //   8: invokespecial 322	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   11: astore 5
    //   13: aload 5
    //   15: astore 4
    //   17: aload 5
    //   19: invokevirtual 323	java/io/RandomAccessFile:readInt	()I
    //   22: istore_1
    //   23: iload_1
    //   24: i2l
    //   25: lstore_2
    //   26: aload 5
    //   28: invokestatic 328	com/tencent/tbs/one/impl/base/FileUtils:close	(Ljava/io/Closeable;)V
    //   31: lload_2
    //   32: ldc2_w 329
    //   35: lcmp
    //   36: ifne +57 -> 93
    //   39: iconst_1
    //   40: ireturn
    //   41: astore 6
    //   43: aconst_null
    //   44: astore 5
    //   46: aload 5
    //   48: astore 4
    //   50: ldc_w 332
    //   53: iconst_2
    //   54: anewarray 4	java/lang/Object
    //   57: dup
    //   58: iconst_0
    //   59: aload_0
    //   60: invokevirtual 335	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   63: aastore
    //   64: dup
    //   65: iconst_1
    //   66: aload 6
    //   68: aastore
    //   69: invokestatic 341	com/tencent/tbs/one/impl/base/Logging:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   72: aload 5
    //   74: invokestatic 328	com/tencent/tbs/one/impl/base/FileUtils:close	(Ljava/io/Closeable;)V
    //   77: lconst_0
    //   78: lstore_2
    //   79: goto -48 -> 31
    //   82: astore_0
    //   83: aconst_null
    //   84: astore 4
    //   86: aload 4
    //   88: invokestatic 328	com/tencent/tbs/one/impl/base/FileUtils:close	(Ljava/io/Closeable;)V
    //   91: aload_0
    //   92: athrow
    //   93: iconst_0
    //   94: ireturn
    //   95: astore_0
    //   96: goto -10 -> 86
    //   99: astore 6
    //   101: goto -55 -> 46
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	104	0	paramFile	File
    //   22	2	1	i	int
    //   25	54	2	l	long
    //   15	72	4	localRandomAccessFile1	java.io.RandomAccessFile
    //   11	62	5	localRandomAccessFile2	java.io.RandomAccessFile
    //   41	26	6	localThrowable1	java.lang.Throwable
    //   99	1	6	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   0	13	41	java/lang/Throwable
    //   0	13	82	finally
    //   17	23	95	finally
    //   50	72	95	finally
    //   17	23	99	java/lang/Throwable
  }
  
  private void readMore()
  {
    Elf.Ehdr localEhdr = this.mHeader;
    DataReader localDataReader = this.mReader;
    boolean bool = is64bit();
    Object localObject1 = getSectionByName(".dynsym");
    if (localObject1 != null)
    {
      localDataReader.seek(((Elf.Elf_Shdr)localObject1).getOffset());
      int j = ((Elf.Elf_Shdr)localObject1).getSize();
      char[] arrayOfChar;
      label72:
      Object localObject2;
      if (bool)
      {
        i = 24;
        j /= i;
        this.mDynamicSymbols = new Elf.Elf_Sym[j];
        arrayOfChar = new char[1];
        i = 0;
        if (i >= j) {
          break label279;
        }
        if (!bool) {
          break label185;
        }
        localObject2 = new Elf.Elf64_Sym();
        ((Elf.Elf64_Sym)localObject2).st_name = localDataReader.readInt();
        localDataReader.readBytes(arrayOfChar);
        ((Elf.Elf64_Sym)localObject2).st_info = arrayOfChar[0];
        localDataReader.readBytes(arrayOfChar);
        ((Elf.Elf64_Sym)localObject2).st_other = arrayOfChar[0];
        ((Elf.Elf64_Sym)localObject2).st_value = localDataReader.readLong();
        ((Elf.Elf64_Sym)localObject2).st_size = localDataReader.readLong();
        ((Elf.Elf64_Sym)localObject2).st_shndx = localDataReader.readShort();
        this.mDynamicSymbols[i] = localObject2;
      }
      for (;;)
      {
        i += 1;
        break label72;
        i = 16;
        break;
        label185:
        localObject2 = new Elf.Elf32_Sym();
        ((Elf.Elf32_Sym)localObject2).st_name = localDataReader.readInt();
        ((Elf.Elf32_Sym)localObject2).st_value = localDataReader.readInt();
        ((Elf.Elf32_Sym)localObject2).st_size = localDataReader.readInt();
        localDataReader.readBytes(arrayOfChar);
        ((Elf.Elf32_Sym)localObject2).st_info = arrayOfChar[0];
        localDataReader.readBytes(arrayOfChar);
        ((Elf.Elf32_Sym)localObject2).st_other = arrayOfChar[0];
        ((Elf.Elf32_Sym)localObject2).st_shndx = localDataReader.readShort();
        this.mDynamicSymbols[i] = localObject2;
      }
      label279:
      localObject1 = this.mSectionHeaders[localObject1.sh_link];
      localDataReader.seek(((Elf.Elf_Shdr)localObject1).getOffset());
      this.mDynStringTable = new byte[((Elf.Elf_Shdr)localObject1).getSize()];
      localDataReader.readBytes(this.mDynStringTable);
    }
    this.mProgHeaders = new Elf.Elf_Phdr[localEhdr.e_phnum];
    int i = 0;
    if (i < localEhdr.e_phnum)
    {
      localDataReader.seek(localEhdr.getProgramOffset() + localEhdr.e_phentsize * i);
      if (bool)
      {
        localObject1 = new Elf.Elf64_Phdr();
        ((Elf.Elf64_Phdr)localObject1).p_type = localDataReader.readInt();
        ((Elf.Elf64_Phdr)localObject1).p_offset = localDataReader.readInt();
        ((Elf.Elf64_Phdr)localObject1).p_vaddr = localDataReader.readLong();
        ((Elf.Elf64_Phdr)localObject1).p_paddr = localDataReader.readLong();
        ((Elf.Elf64_Phdr)localObject1).p_filesz = localDataReader.readLong();
        ((Elf.Elf64_Phdr)localObject1).p_memsz = localDataReader.readLong();
        ((Elf.Elf64_Phdr)localObject1).p_flags = localDataReader.readLong();
        ((Elf.Elf64_Phdr)localObject1).p_align = localDataReader.readLong();
        this.mProgHeaders[i] = localObject1;
      }
      for (;;)
      {
        i += 1;
        break;
        localObject1 = new Elf.Elf32_Phdr();
        ((Elf.Elf32_Phdr)localObject1).p_type = localDataReader.readInt();
        ((Elf.Elf32_Phdr)localObject1).p_offset = localDataReader.readInt();
        ((Elf.Elf32_Phdr)localObject1).p_vaddr = localDataReader.readInt();
        ((Elf.Elf32_Phdr)localObject1).p_paddr = localDataReader.readInt();
        ((Elf.Elf32_Phdr)localObject1).p_filesz = localDataReader.readInt();
        ((Elf.Elf32_Phdr)localObject1).p_memsz = localDataReader.readInt();
        ((Elf.Elf32_Phdr)localObject1).p_flags = localDataReader.readInt();
        ((Elf.Elf32_Phdr)localObject1).p_align = localDataReader.readInt();
        this.mProgHeaders[i] = localObject1;
      }
    }
  }
  
  final boolean checkMagic()
  {
    boolean bool = false;
    if (this.e_ident[0] == ElfMagic[0]) {
      bool = true;
    }
    return bool;
  }
  
  public void close()
  {
    this.mReader.close();
  }
  
  final char getDataEncoding()
  {
    return this.e_ident[5];
  }
  
  public final String getDynString(int paramInt)
  {
    if (paramInt == 0) {
      return "SHN_UNDEF";
    }
    int i = paramInt;
    while (this.mDynStringTable[i] != 0) {
      i += 1;
    }
    return new String(this.mDynStringTable, paramInt, i - paramInt);
  }
  
  final char getFileClass()
  {
    return this.e_ident[4];
  }
  
  public Elf.Ehdr getHeader()
  {
    return this.mHeader;
  }
  
  public DataReader getReader()
  {
    return this.mReader;
  }
  
  public final Elf.Elf_Shdr getSectionByName(String paramString)
  {
    Elf.Elf_Shdr[] arrayOfElf_Shdr = this.mSectionHeaders;
    int j = arrayOfElf_Shdr.length;
    int i = 0;
    while (i < j)
    {
      Elf.Elf_Shdr localElf_Shdr = arrayOfElf_Shdr[i];
      if (paramString.equals(getString(localElf_Shdr.sh_name))) {
        return localElf_Shdr;
      }
      i += 1;
    }
    return null;
  }
  
  public Elf.Elf_Shdr[] getSectionHeaders()
  {
    return this.mSectionHeaders;
  }
  
  public final String getString(int paramInt)
  {
    if (paramInt == 0) {
      return "SHN_UNDEF";
    }
    int i = paramInt;
    while (this.mStringTable[i] != 0) {
      i += 1;
    }
    return new String(this.mStringTable, paramInt, i - paramInt);
  }
  
  public final boolean is64bit()
  {
    return getFileClass() == '\002';
  }
  
  public final boolean isLittleEndian()
  {
    return getDataEncoding() == '\001';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.loader.dex.Elf
 * JD-Core Version:    0.7.0.1
 */